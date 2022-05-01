package com.me.advert.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.me.advert.exception.*;
import com.me.advert.pojo.*;

@Component
public class OrderDAO extends DAO {
    public void save(Orders order) throws CustomException {
        try {
            begin();
            getSession().save(order);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CustomException("Could not delete advert", e);
        }
    }
    
    public List<Orders> list() {
		Query<Orders> query = getSession().createQuery("FROM Order");
		List<Orders> list = query.list();
		return list;
	}
}