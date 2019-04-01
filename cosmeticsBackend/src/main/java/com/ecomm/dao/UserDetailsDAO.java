package com.ecomm.dao;

import com.ecomm.model.UserDetails;

public interface UserDetailsDAO 
{
 public boolean registerUser(UserDetails user);
 public boolean updateAddress(UserDetails user);
 public UserDetails getUser(String username);
}