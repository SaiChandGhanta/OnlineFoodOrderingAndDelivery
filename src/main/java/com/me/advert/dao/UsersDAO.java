package com.me.advert.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import com.me.advert.exception.*;
import com.me.advert.pojo.Users;
import com.me.advert.dao.*;

@Component
public class UsersDAO extends DAO {

    public UsersDAO() {
    }

    public void save(Users user) throws CustomException {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CustomException("Could not delete user " + user.getName(), e);
        }
    }
    
    public void delete(Users u) throws CustomException {
    	begin();
    	getSession().delete(u);
    	commit();
    }
}