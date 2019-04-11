package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;


public class ProductDAOTest 
{

  	static ProductDAO productDAO;
  	@BeforeClass
  	public static void executeFirst()
  	{
  		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
  		 context.scan("com.ecomm");
  	     context.refresh();
  	     productDAO =(ProductDAO)context.getBean("productDAO");
  	} 
    
  	@Test
  	public void addProductTest() 
	{
		Product product = new Product();
		product.setProductName("Revlon");	
		product.setProductDesc("Liquid lipcolor");
		product.setStock(20);
		product.setPrice(650);
		product.setCategoryID(2);
		product.setSupplierID(4);
		assertTrue("Problem in adding Product",productDAO.addProduct(product));
	}
  	
  	@Test
  	public void deleteProductTest()
  	{
  		Product product = productDAO.getProduct(9);
  		assertTrue("Problem in deleting Product",productDAO.deleteProduct(product));
  	}
  	
  	@Test
  	public void updateProductTest()
  	{
  		Product product = productDAO.getProduct(10);
  		product.setStock(10);
  		assertTrue("Problem in updating Product",productDAO.updateProduct(product));
  	}
  	
  	@Test
  	public void listProductsTest()
	{
		List<Product> listProducts = productDAO.listProducts();
		assertTrue("Problem in Listing Suppliers",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID : " +product.getProductID());
			System.out.println("Product Name : " +product.getProductName());
			System.out.println("Product Description : " +product.getProductDesc());
			System.out.println("Product Stock : " +product.getStock());
			System.out.println("Product Price : " +product.getPrice());
			System.out.println("Product's CategoryID : " +product.getCategoryID());
			System.out.println("Product's SupplierID : " +product.getSupplierID());
		}

		}
  	
}
