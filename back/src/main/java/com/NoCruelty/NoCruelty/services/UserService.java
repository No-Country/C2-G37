package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.enums.Rol;
import com.NoCruelty.NoCruelty.models.User;
import com.NoCruelty.NoCruelty.models.Zone;
import com.NoCruelty.NoCruelty.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ZoneService zoneService;
    private Long id;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public void save(String name, String surname, String password, String email, Long phone, String province, String localidad) throws Exception {

        validateModify(name, surname, password, email, phone);

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(0);

        Zone zone = zoneService.searchZone(province, localidad);
        user.setZone(zone);

        userRepository.save(user);
    }

    @Transactional
    public User searchForId(Long id) {
        return userRepository.getById(id);
    }

    @Transactional
    public User searchForEmail(String email) {
        return userRepository.getById(email);
    }

    public void modify(String name, String surname, String password, String email, Long phone) {
        User user = searchForId(id);

        validateModify(name, surname, password, email, phone);

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setPhone(0);
        user.setRol(Rol.ROL_USER);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = userRepository.findByUsername(username);

        List<GrantedAuthority> permisos = new ArrayList<>();

        if (users.get().getRol() != null) {
            permisos.add(new SimpleGrantedAuthority(Rol.ROL_USER.toString()));
            permisos.add(new SimpleGrantedAuthority(users.get().getRol().toString()));
        } else if (users.get().getRol().equals("ROLE_ADMIN")) {
            permisos.add(new SimpleGrantedAuthority(Rol.ROL_USER.toString()));
            permisos.add(new SimpleGrantedAuthority(users.get().getRol().toString()));
        } else {
            permisos.add(new SimpleGrantedAuthority("ROLE_GUEST"));
        }

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.setAttribute("userSession", users);

        User user = new User(users.get(), users.get().getPassword(), permisos);

        return (UserDetails) user;
    }

    public void validateModify(String name, String surname, String password, String email, Long phone) throws Error {

        if (name == null || name.isEmpty()) {
            throw new Error("Ingresó un nombre vacio o nulo");
        }

        if (surname == null || surname.isEmpty()) {
            throw new Error("Ingresó el apellido vacio o nulo");
        }

        if (password == null || password.isEmpty()) {
            throw new Error("Ingresó un nombre vacio o nulo");
        }

        if (email == null || email.isEmpty()) {
            throw new Error("Ingresó el apellido vacio o nulo");
        }

        if (phone == null) {
            throw new Error("Ingresó un DNI vacio o nulo");
        }
    }
}
