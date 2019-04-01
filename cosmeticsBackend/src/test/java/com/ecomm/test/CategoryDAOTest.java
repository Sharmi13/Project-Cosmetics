package com.ecomm.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.configuration.DBConfiguration;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest {

	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	     context.scan("com.ecomm");
	     context.refresh();
	     categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	     
	}
	@Ignore
	@Test
	public void addCategoryTest() 
	{
		Category category = new Category();
		category.setCategoryName("Lipstick");
		category.setCategoryDesc("Glossy");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}
	@Ignore
    @Test
    public void deleteCategoryTest()
    {
    	Category category=categoryDAO.getCategory(1);
    	assertTrue("Problem in deleting Category",categoryDAO.deleteCategory(category));
    }
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories = categoryDAO.listCategories();
		assertTrue("Problem in Listing Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category ID : " +category.getCategoryId());
			System.out.println("Category Name : " +category.getCategoryName());
			System.out.println("Category Description : " +category.getCategoryDesc());
		}
		
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(2);
		category.setCategoryName("Lipcolor");
		category.setCategoryDesc("Liquid lipstick");
    	assertTrue("Problem in updating Category",categoryDAO.updateCategory(category));

	}
}

