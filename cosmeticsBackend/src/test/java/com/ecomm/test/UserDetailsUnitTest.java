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
    @Ignore
	@Test
	public void addusertest() 
	{
		UserDetails user = new UserDetails();
		user.setCustomername("Rikshitha");
		user.setCustomerAddr("Delhi");
		user.setUsername("Rikshi");
		user.setPassword("Rikshi");
		user.setRole("User");
		user.setEnabled(true);
		assertTrue("Problem in adding User Details",userdetailsDAO.registerUser(user));
	}
    @Test
    public void updateusertest()
    {
    	UserDetails user = userdetailsDAO.getUser("Rikshi");
    	user.setCustomerAddr("Delhi NehruPark");
		assertTrue("Problem in updating User Details",userdetailsDAO.updateAddress(user));
	}
    @Test
    public void viewusertest()
    {
    	UserDetails user = userdetailsDAO.getUser("Sahana");

    	System.out.println("Customer name           :"+user.getCustomername());
    	System.out.println("Customer Address        :"+user.getCustomerAddr());
    	System.out.println("Customer Role           :"+user.getRole());
    	System.out.println("Customer Account Status :"+user.isEnabled());

    }
}
