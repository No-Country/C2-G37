package com.NoCruelty.NoCruelty.controllers;

import com.NoCruelty.NoCruelty.services.UserService;
import com.NoCruelty.NoCruelty.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user")
public class UserController {
    
    	@Autowired
	private UserService userService;

	@Autowired
	private ZoneService zoneService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PreAuthorize("hasRole('ROL_USER')")
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		model.addAttribute("user", userService.searchForEmail(userDetails.getPassword()));
                
                return "perfil";
	}
	
	@GetMapping("/registrarse")
	public String registrarse(Model model) {
		model.addAttribute("zona", zoneService.listar());
		return "registrarse";
	}
	
	@PostMapping("/registroUser")
	public String registroUser(RedirectAttributes redirectAt, @RequestParam String name, @RequestParam String surname,
									 @RequestParam String password, @RequestParam String email, 
									 @RequestParam Long phone, @RequestParam String province, @RequestParam String country ) throws Exception {
		try {
			userService.save(name, surname, password, email, phone, province, country);
			return "redirect:/";
		} catch (Error e) {
			redirectAt.addFlashAttribute("error", e.getMessage());
			return "redirect:/voluntario/registrarse";
		}
		
	}
	
	@PreAuthorize("hasRole('ROL_USER')")
	@GetMapping("/modificarUser")
	public String modificarUser(Model model) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		model.addAttribute("user", userService.searchForEmail(userDetails.getPassword()));
		return "modificarUser";
	
	}
    
}
