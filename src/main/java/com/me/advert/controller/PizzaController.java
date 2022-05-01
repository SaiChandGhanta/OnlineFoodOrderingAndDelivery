package com.me.advert.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.advert.dao.*;
import com.me.advert.pojo.*;
import com.me.advert.exception.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PizzaController {
	@GetMapping("/listpizzas.htm")
	public String listPizzasGet(HttpServletRequest request, OrderDAO pizzadao) {
		request.setAttribute("pizzas", pizzadao.list());
		
		return "viewPizzas";
	}

	@GetMapping("/addpizza.htm")
	public String addPizzaGet(ModelMap model, Pizza pizza) {
		model.addAttribute("pizza", pizza);
		// return form view
		return "abc";
	}
	
	
	@PostMapping("/addpizza.htm")
	public String addPizzaPost(@ModelAttribute("pizza") Pizza pizza, BindingResult result, SessionStatus status, PizzaDAO pizzadao) {
		
		try {
			pizzadao.save(pizza);
		} catch (CustomException e) {
			System.out.println("Pizza cannot be Added: " + e.getMessage());
		}
		
		status.setComplete(); //mark it complete
		return "addedPizza";
	}
}