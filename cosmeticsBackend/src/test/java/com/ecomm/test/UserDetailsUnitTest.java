package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.UserDetailsDAO;
import com.ecomm.model.UserDetails;

public class UserDetailsUnitTest 
{
	static UserDetailsDAO userdetailsDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 context.scan("com.ecomm");
	     context.refresh();
	     userdetailsDAO=(UserDetailsDAO)context.getBean("userdetailsDAO");
	}    
    
	@Test
	public  void registerUser() 
	{
		UserDetails user=new UserDetails();
		
		user.setMobileNo("9087558324");
		user.setPassword("123");
		user.setRole("Admin");
		user.setEnabled(true);
		user.setUsername("Amirtha");
		
		
		assertTrue("Problem in User Insertion",userdetailsDAO.registerUser(user));
	
	}
	@Ignore
	@Test
	public  void deleteUser() 
	{
		//UserDetail user=userDAO.getUser("1256");
		//assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public  void updateUser() 
	{

		//UserDetail user=userDAO.getUser("ravi");
	  //  user.setAddr("Anna Nagar");
		//assertTrue("Problem in Updation",userDAO.updateUser(user));
}
}
