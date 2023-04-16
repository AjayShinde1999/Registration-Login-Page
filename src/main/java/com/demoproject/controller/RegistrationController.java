package com.demoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoproject.entities.Registration;
import com.demoproject.repositories.RegistrationRepository;
import com.demoproject.service.DAOService;

@Controller
public class RegistrationController {

	private DAOService daoService;

	@Autowired
	private RegistrationRepository registrationRepo;

	public RegistrationController(DAOService daoService) {
		this.daoService = daoService;
	}

	// http://localhost:8080/viewPage
	@RequestMapping("/viewPage")
	public String viewPage() {
		return "registration_page";
	}

	@RequestMapping("/saveReg")
	public String saveOneReg(@ModelAttribute("registration") Registration registration, Model model) {
		daoService.saveOneReg(registration);
		model.addAttribute("msg", "Registered");
		return "registration_page";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login_page";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLoginCredential(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		Registration registration = registrationRepo.findByEmail(email);

		if (registration != null && registration.getEmail().equals(email)
				&& registration.getPassword().equals(password)) {
			return "homePage";
		} else {
			model.addAttribute("error", "Username/Password incorrect");
			return "login_page";
		}
	}

}
