package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailsDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetails;

public class CartController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	@Autowired
	UserDetailsDAO userdetailsDAO;
	
	@RequestMapping("/updateAddress")
	public String updateAddress(@RequestParam("address") String address,String usernane ,Model m, HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		
		List<Cart>listCart=cartDAO.listCart(username);
		UserDetails user=userdetailsDAO.getUser(username);
		user.setCustomerAddr(address);
		userdetailsDAO.updateUser(user);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		m.addAttribute("addr",user.getCustomerAddr());
		
		return "OrderConfirm";
	}
	
	
	
	@RequestMapping("/addToCart/{productId}")
	public String addCart(@RequestParam("quantity")int quantity,@PathVariable("productId")int productId,Model m, HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		Cart cart=new Cart();
		cart.setProductId(product.getProductID());
		cart.setProductName(product.getProductName());
		cart.setPrice(product.getPrice());
		cart.setPaymentStatuse(username);
		cart.setQuantity(quantity);
		cart.setUsername(username);
		
		cartDAO.addCart(cart);
		List<Cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal",this.calGrandTotalPrice(listCart));
		
		return "Cart";
	}
	
	@RequestMapping("/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId")int cartId,Model m, HttpSession session)
	{
		Cart cart=cartDAO.getCart(cartId);
		cartDAO.deleteCart(cart);
		String username=(String)session.getAttribute("username");
		List<Cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		
		return "Cart";
	}
	

	@RequestMapping("/orderConfirm")
	public String orderConfirm(Model m, HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		System.out.println("from order confirm"+username);
		List<Cart>listCart=cartDAO.listCart(username);
		UserDetails user=userdetailsDAO.getUser(username);
		
		System.out.println("from cart contoller "+user);
		m.addAttribute("listCartItem",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		m.addAttribute("addr",user.getCustomerAddr());
				
		
		return "OrderConfirm";
	}


	
	@RequestMapping("/updateCart/{cartId}")
	public String updateCart(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m, HttpSession session)
	{
		quantity++;
		Cart cart=cartDAO.getCart(cartId);
		cart.setQuantity(quantity);
		cartDAO.updateCart(cart);
		String username=(String)session.getAttribute("username");
		List<Cart>listCart=cartDAO.listCart(username);
		
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		
		return "Cart";
	}
	
	
	

	
	public int calGrandTotalPrice(List<Cart> listCart)
	{
		int grandTotal=0;
		int count=0;
		while(count<listCart.size())
		{
			Cart cart=listCart.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count=count+1;
			
		}
		return grandTotal;
	}
}
