package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTest {

	static SupplierDAO supplierDAO;
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 context.scan("com.ecomm");
     context.refresh();
     supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
}
    @Ignore
	@Test
	public void addSupplierTest() 
	{
		
			Supplier supplier = new Supplier();
			supplier.setSupplierName("Revlon");
			supplier.setSupplierAddr("New York");
		    assertTrue("Problem in adding Supplier",supplierDAO.addSupplier(supplier));
	}	
    @Ignore
	@Test
	public void deleteCategoryTest()
    {
    	Supplier supplier=supplierDAO.getSupplier(5);
    	assertTrue("Problem in deleting Supplier",supplierDAO.deleteSupplier(supplier));
    }
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		assertTrue("Problem in Listing Suppliers",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println("Category ID : " +supplier.getSupplierId());
			System.out.println("Category Name : " +supplier.getSupplierName());
			System.out.println("Category Description : " +supplier.getSupplierAddr());
		}
	}
	@Ignore
    @Test
    public void updateSupplierTest()
    {
    	Supplier supplier = supplierDAO.getSupplier(6);
    	supplier.setSupplierAddr("Ne York");
    	assertTrue("Problem in Updating Suppliers",supplierDAO.updatesupplier(supplier));
    }
}
