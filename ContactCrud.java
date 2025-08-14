package com.cms;

import java.util.Scanner;

public class ContactCrud {
	long mob;
	String name;
	
    public Contact addContact() {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the mobile number");
    	mob=sc.nextLong();
    	
    	sc.nextLine();
    	System.out.println("Enter the name");
    	name=sc.nextLine();
    	Contact c=new Contact();
    	c.setMob(mob);
    	c.setName(name);
    	return c;
    }
	public Long deleteContact() {
		Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter the mobile number that you want to delete");
	    	
	    	mob=sc.nextLong();
	    	
	    	return mob;
	}
	public void updateContact() {
		
	}
	public void checkAllContact() {
		
	}
}
