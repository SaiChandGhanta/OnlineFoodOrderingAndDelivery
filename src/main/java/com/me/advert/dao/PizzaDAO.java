package com.me.advert.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.me.advert.exception.*;
import com.me.advert.pojo.*;

@Component
public class PizzaDAO extends DAO {
	public PizzaDAO() {
		System.out.println("*** Pizza DAO");
		//default constructor
	}
	
	public List<Pizza> list() {
		Query<Pizza> query = getSession().createQuery("FROM Pizza");
		List<Pizza> list = query.list();
		return list;
	}

    public void save(Pizza pizza) throws CustomException {
        try {
            begin();
            getSession().save(pizza);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CustomException("Could not add the pizza", e);
        }
    }
    
    public Pizza getPizza(long id) {
    	return getSession().get(Pizza.class, id);
    }
    
    public void deletepizza(Pizza c) throws CustomException {
        try {
            begin();
            getSession().delete(c);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CustomException("Could not delete the pizza", e);
        }
    }
    
    public void updatePizza(Pizza c) throws CustomException {
        try {
            begin();
            getSession().update(c);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CustomException("Could not update the pizza", e);
        }
    }
}