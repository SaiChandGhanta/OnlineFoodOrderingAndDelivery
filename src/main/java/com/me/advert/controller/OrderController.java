package com.me.advert.controller;

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

@Controller
public class OrderController {
	@GetMapping("/addcategory.htm")
	public String addOrderGet(ModelMap model, Orders order) {
		// command object
		model.addAttribute("order", order);

		// return form view
		return "addOrderForm";
	}

	@PostMapping("/addorder.htm")
	public String addOrderPost(@ModelAttribute("order") Pizza order, BindingResult result,
			SessionStatus status, PizzaDAO orderdao) {
		
		try {
			orderdao.save(order);
		} catch (CustomException e) {
			System.out.println("Order cannot be Added: " + e.getMessage());
		}
		status.setComplete(); // mark it complete
		return "addedOrder";
	}
}
