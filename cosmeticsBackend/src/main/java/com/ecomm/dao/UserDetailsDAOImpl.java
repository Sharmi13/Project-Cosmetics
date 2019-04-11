package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetails;

@Repository("userdetailsDAO")
@Transactional

public class UserDetailsDAOImpl implements UserDetailsDAO
{

	 @Autowired
	  SessionFactory sessionFactory;
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
	public boolean deleteUser(UserDetails user) {
		try 
		{
			sessionFactory.getCurrentSession().delete(user); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	

		}

	@Override
	public boolean updateUser(UserDetails user) 
	{
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
	
public List<UserDetails> listUserDetails() {
		
		Session session=sessionFactory.openSession();
		List<UserDetails> listUserDetails=(List<UserDetails>)session.createQuery("from UserDetails").list();
		session.close();
		return  listUserDetails;
	}

	@Override
	public UserDetails getUser(String username)
	
	{
		Session session=sessionFactory.openSession();
		UserDetails user=(UserDetails)session.get(UserDetails.class,username);
		session.close();
		return user;		
	}

	
	}
