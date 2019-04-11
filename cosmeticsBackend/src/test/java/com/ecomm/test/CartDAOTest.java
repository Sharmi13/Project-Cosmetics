package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;
import com.ecomm.dao.CartDAOImpl;

public class CartDAOTest {

		static CartDAO cartDAO;

		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.ecomm");
			context.refresh();
			
			
			cartDAO=(CartDAO)context.getBean("cartDAO");
		}

		
		@Test
		
		public void addCartTest()
		{
			Cart cart=new Cart();
			cart.setProductName("Revlon");
			cart.setCartId(185);
			cart.setPrice(1650);
			cart.setProductId(7003);
			cart.setQuantity(6);
			cart.setUsername("Ram");
			assertTrue("Problem in adding the Cart ",cartDAO.addCart(cart));	
			}
		
		
		@Test
		public void getCartTest()
		{
			assertNotNull("Problem in get Cart",cartDAO.getCart(1));
		}
		
		
		@Test
		public void deleteCartTest()
		{
			Cart cart=cartDAO.getCart(2);
			assertTrue("Problem in Deletion:",cartDAO.deleteCart(cart));
		}
		
		@Test
		public void updateCartTest()
		{
			Cart cart=cartDAO.getCart(1);
			cart.setCartId(8);
			assertTrue("Problem in Updation",cartDAO.updateCart(cart));
		}

		
		@Test
		public void listCartTest()
		{
			List<Cart> listCart=cartDAO.listCart("Ram");
			assertNotNull("No Cart",listCart);
			
			for(Cart cart:listCart)
			{
				System.out.print(cart.getCartId()+":::");
				System.out.print(cart.getProductid()+":::");
				System.out.println(cart.getPaymentStatuse()+":::");
				System.out.println(cart.getPrice()+":::");
				System.out.println(cart.getProductName()+":::");
				System.out.println(cart.getQuantity()+":::");
				System.out.println(cart.getUsername()+":::");
			}
		}

	}
