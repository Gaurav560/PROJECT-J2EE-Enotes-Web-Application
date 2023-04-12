package com.User;

public class UserDetails {

private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String firstNameString;
private String lastNameString;
private String emailString;
private String phoneString;
private String passwordString;
public UserDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public UserDetails(String firstNameString, String lastNameString, String emailString, String phoneString,
		String passwordString) {
	super();
	this.firstNameString = firstNameString;
	this.lastNameString = lastNameString;
	this.emailString = emailString;
	this.phoneString = phoneString;
	this.passwordString = passwordString;
}
public String getFirstNameString() {
	return firstNameString;
}
public void setFirstNameString(String firstNameString) {
	this.firstNameString = firstNameString;
}
public String getLastNameString() {
	return lastNameString;
}
public void setLastNameString(String lastNameString) {
	this.lastNameString = lastNameString;
}
public String getEmailString() {
	return emailString;
}
public void setEmailString(String emailString) {
	this.emailString = emailString;
}
public String getPhoneString() {
	return phoneString;
}
public void setPhoneString(String phoneString) {
	this.phoneString = phoneString;
}
public String getPasswordString() {
	return passwordString;
}
public void setPasswordString(String passwordString) {
	this.passwordString = passwordString;
} 

}
