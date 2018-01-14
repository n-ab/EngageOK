package com.engageok.prototype_1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.engageok.prototype_1.services.UserService;
import com.engageok.prototype_1.validator.UserValidator;
import com.engageok.prototype_1.models.User;

// com.engageok.prototype_1.
@Controller
public class Main {
	private UserService userService;
	private UserValidator userValidator;
	
	public Main(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/login")
	public String registerForm(@Valid @ModelAttribute("user")User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		System.out.println("---login.jsp---");
		if(error != null) {
			System.out.println("Unsuccessful LOGIN");
			model.addAttribute("errorMessage", "Your credentials are bad!");
		}
		if(logout != null) {
			System.out.println("Successful LOGOUT");
			model.addAttribute("logoutMessage", "You have logged out.");
		}
		return "login.jsp";
	}
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes ) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			System.out.println("1");
			if(userService.findAllUsers()==null) {
				System.out.println("saving as ADMIN");
				userService.saveUserWithAdminRole(user);
				return "redirect:/login";
			}else {
				System.out.println("saving as USER");
				userService.saveWithUserRole(user);
				redirectAttributes.addFlashAttribute("regSuc", "Thank you for registering");
				return "redirect:/login";
			}
		}
	}
}
