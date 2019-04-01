package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Authorities 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int authoritiesId;
private String role;
@OneToOne
private UserDetails user;
public int getAuthoritiesId() {
	return authoritiesId;
}
public void setAuthoritiesId(int authoritiesId) {
	this.authoritiesId = authoritiesId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public UserDetails getUser() {
	return user;
}
public void setUserDetails(UserDetails user) {
	this.user = user;
}

}