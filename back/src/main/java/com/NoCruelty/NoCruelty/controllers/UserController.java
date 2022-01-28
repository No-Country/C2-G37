package com.NoCruelty.NoCruelty.controllers;

import com.NoCruelty.NoCruelty.models.User;
import com.NoCruelty.NoCruelty.services.UserService;
import com.NoCruelty.NoCruelty.services.ZoneService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/")
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ZoneService zoneService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password) {
        System.out.println(email);
        System.out.println(password);

        return new ResponseEntity<>("Login existoso", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROL_USER')")
        @GetMapping("/perfil")
    public String perfil(Model model) {
        Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        model.addAttribute("user", userService.searchForEmail(userDetails.getPassword()));

        return "perfil";
    }

    @GetMapping("/register")
    public ResponseEntity<Object> registroUser(@RequestBody User user) throws Exception {
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("user.getPassword() = " + user.getPassword());
        System.out.println("user.getSurname() = " + user.getSurname());
        System.out.println("user.getZone() = " + user.getZone());
        System.out.println("user.getRol() = " + user.getRol());
        System.out.println("user.getPhone() = " + user.getPhone());

        try {
            userService.save(user.getName(), user.getSurname(), user.getPassword(), user.getEmail(), user.getPhone(), user.getZone().getProvince(), user.getZone().getCountry());
            return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ResponseEntity<>("Usuario no creado", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/modificar")
    public ResponseEntity<Object> moddificarUser(@PathVariable String email, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("email = " + email);
        return new ResponseEntity<>(email + " " + name + " " + surname, HttpStatus.OK);

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("idUser");
        return "redict:/";
    }
}
