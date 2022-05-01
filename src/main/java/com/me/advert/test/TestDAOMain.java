package com.me.advert.test;

import java.util.List;

import com.me.advert.dao.PizzaDAO;
import com.me.advert.pojo.Pizza;

public class TestDAOMain {

	public static void main(String[] args) {
		PizzaDAO cdao = new PizzaDAO();
		List<Pizza> list = cdao.list();
		
		for (var categ : list)
			System.out.println(categ.getName());
		
		System.out.println("DONE");
	}
}
