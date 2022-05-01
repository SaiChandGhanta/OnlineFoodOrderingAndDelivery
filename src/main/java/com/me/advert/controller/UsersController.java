package com.me.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.advert.controller.*;
import com.me.advert.dao.*;
import com.me.advert.pojo.*;
import com.me.advert.exception.*;

@Controller
public class UsersController {
	@GetMapping("/adduser.htm")
	public String addUserGet(ModelMap model, Users user) {
		// command object
		model.addAttribute("user", user);

		// return form view
		return "addUserForm";
	}

	@PostMapping("/adduser.htm")
	public String addUserPost(@ModelAttribute("user") Users user, BindingResult result, SessionStatus status, UsersDAO usersdao) {
		try {
			usersdao.save(user);
		} catch (CustomException e) {
			System.out.println("User cannot be Added: " + e.getMessage());
		}
		
		status.setComplete(); //mark it complete
		return "addedUser";
	}
}
