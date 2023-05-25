package com.iset.sante.controllers;

import com.iset.sante.entities.Role;
import com.iset.sante.entities.User;
import com.iset.sante.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

	@Autowired
	private UserService service;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index2";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	//@GetMapping("/login")
	//public String showlogin(Model model) {

	//	return "login";
	//}



	@PostMapping("/process_register")
	public String processRegister(User user) {
		service.registerDefaultUser(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}


	@GetMapping("/ok")
	public String dash(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);

		return "dash";
	}
	@GetMapping("/listusers")
	public String listusers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);

		return "listusers";
	}

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = service.get(id);
		List<Role> listRoles = service.listRoles();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		return "user_form";
	}
	@GetMapping("login")




	@PostMapping("/users/save")
	public String saveUser(User user) {
		service.save(user);
		
		return "redirect:/users";
	}	
}
