package com.iset.sante.controllers;


import com.iset.sante.entities.Message;
import com.iset.sante.repositories.MessageRepository;
import com.iset.sante.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ramesh Fadatare
 *
 */
@Controller
public class HomeController
{
	@Autowired
	private EvenementService  EvenementService;
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/home")
	public String home(Model model)

	{
		model.addAttribute("msgs", messageRepository.findAll());		
		return "redirect:/";
	}
	@GetMapping("/Consultation")
	public String viewConstPage(Model model)
	{
		return "consultation";
	}


	@PostMapping("/messages")
	public String saveMessage(Message message)
	{
		messageRepository.save(message);
		return "redirect:/home";
	}
	@RequestMapping(value = "/evenement", method = RequestMethod.GET)
	public ModelAndView ok() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userhome"); // resources/template/home.html
		return modelAndView;
	}
//************************************


}
