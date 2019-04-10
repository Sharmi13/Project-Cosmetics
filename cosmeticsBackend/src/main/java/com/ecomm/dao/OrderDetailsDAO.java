package com.ecomm.dao;
import com.ecomm.model.OrderDetails;
import java.util.List;

public interface OrderDetailsDAO 
{
	public boolean saveOrder(OrderDetails orderDetails);
	public boolean updateCart(String username, int orderId);
}
