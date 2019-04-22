package com.ecomm.test;

import junit.framework.TestCase;


import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;

public class UserDAOUnitTest {

	static UserDetailDAO userdetailDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	

	@Test
	public  void registerUser() 
	{
		UserDetail user=new UserDetail();
		
		user.setMobileNo("9087558324");
		user.setPassword("1302");
		user.setCustomerName("Rikshitha");
		user.setAddr("Annanagar");
		user.setRole("Admin");
		user.setEnabled(true);
		user.setCustomerName("Leelavathy ");
		
		assertTrue("Problem in User Insertion",userdetailDAO.registerUser(user));
	
	}
	
	
	@Test
	public  void deleteUser() 
	{
		UserDetail user=userdetailDAO.getUser("Amritha");
		assertTrue("Problem in Deletion:",userdetailDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public  void updateUser() 
	{

		//UserDetail user=userdetailDAO.getUser("Janani");
	       // user.setAddr("Annanagar");
		//assertTrue("Problem in Updation",userdetailDAO.updateUser(user));
	}
	
	}
