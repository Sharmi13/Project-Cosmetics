package com.ecomm.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.UserDetails;
@Repository("userdetailsDAO")
@Transactional

public class UserDetailsDAOImpl implements UserDetailsDAO
{
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetails user) {
		try 
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean updateAddress(UserDetails user) {
		try 
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public UserDetails getUser(String username) {
		Session session = sessionFactory.openSession();
		UserDetails user = (UserDetails) session.get(UserDetails.class,username);
		return user;
	}

	}

