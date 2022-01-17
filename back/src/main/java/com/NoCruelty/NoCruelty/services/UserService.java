package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.enums.Rol;
import com.NoCruelty.NoCruelty.models.User;
import com.NoCruelty.NoCruelty.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ZoneService zoneService;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    
    public void save(String name, String surname, String password, String email, Long phone) throws Exception {

        validateModify(name, surname, password, email, phone);

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email); 
        user.setPhone(0);

//        Zone zone = zoneService.searchZone(email, surname);
//        user.setZone(zone);

        userRepository.save(user);
    }

    @Transactional
    public User searchForId(String id) {
        return userRepository.getById(id);
    }

    public void modify(String name, String surname, String password, String email, Long phone) {
        User user = searchForId(name);

        validateModify(name, surname, password, email, phone);

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(0);
        user.setRol(Rol.ROL_USER);

        userRepository.save(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user= userRepository.findByUsername(username);
//
//        List<GrantedAuthority> permisos = new ArrayList<>();
//
//        if (user.get().getRol() != null) {
//            permisos.add(new SimpleGrantedAuthority(Rol.ROL_USER.toString()));
//            permisos.add(new SimpleGrantedAuthority(user.get().getRol().toString()));
//        } else if (user.get().getRol().equals("ROLE_ADMIN")) {
//            permisos.add(new SimpleGrantedAuthority(Rol.ROL_USER.toString()));
//            permisos.add(new SimpleGrantedAuthority(user.get().getRol().toString()));
//        } else {
//            permisos.add(new SimpleGrantedAuthority("ROLE_GUEST"));
//        }
//
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session = attr.getRequest().getSession(true);
//        session.setAttribute("userSession", user);
//
//        User user2 = new User(user.get().getName(), user2.get().getPassword(), permisos);
//        
//        return user;
//    }


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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
