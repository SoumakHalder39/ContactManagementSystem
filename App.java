package com.cms;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        cfg.configure("/hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();  
        Transaction tx=session.beginTransaction();
        Scanner sc=new Scanner(System.in);
        ContactCrud cc=new ContactCrud();
        int choice;
        boolean flag=true;
        while(flag) {
        	System.out.println("Welcome Soumak!\nChoose your option");
        	System.out.println("1.Add a new Contact \n2.Delete an existing contact \n3.Update an existing contact \n4.Check all saved contacts \n5.logout");
        	choice=sc.nextInt();
        	sc.nextLine();
        	switch(choice) {
        		case 1:session.save(cc.addContact());
        			tx.commit();
        			break;
        		case 2:try{
        			Contact c=session.get(Contact.class, cc.deleteContact());
        			session.delete(c);
        			tx.commit();
        			System.out.println("number deleted successfully");
        			}catch(Exception e) {
        				e.printStackTrace();
        				System.out.println("this contact does not exist");
        			}
        			break;
        		case 3:
    	    	       System.out.println("Enter the mobile number that you want to edit");
    	    	       Long  con=sc.nextLong();
    	    	       sc.nextLine();
    	    	       Contact c1=session.get(Contact.class, con);
    	    	       if(c1==null) {
    	    	    	   System.out.println(con+"does not exist in database");
    	    	       }
    	    	       else {
    	    	    	   System.out.println("What do you want to update\n 1:Name \n2:Contact number");
    	    	    	   int c= sc.nextInt();
    	    	    	   sc.nextLine();
    	    	    	   if(c==1) {
    	    	    		   System.out.println("Enter the new name");
    	    	    		   String n=sc.nextLine();
    	    	    		   c1.setName(n);
    	    	    		   session.update(c1);
    	    	    		   tx.commit();
    	    	    	   }else if(c==2) {
    	    	    		   System.out.println("Enter the new number");
    	    	    		   long m2=sc.nextLong();
    	    	    		   Contact c2=new Contact();
    	    	    		   c2.setName(c1.getName());
    	    	    		   c2.setMob(m2);
    	    	    		   session.save(c2);
    	    	    		   session.delete(c1);
    	    	    		   
    	    	    		   tx.commit();
    	    	    	   }
    	    	       }

        			break;
        		case 4:
        			String hql="from Contact where mob>7070707070";
        			Query q=session.createQuery(hql);
        			List<Contact> l=q.list();     
        			for(Contact c:l) {
        				System.out.println(c.toString());
        			}
        			break;
        		case 5:System.out.println("Thanks ");
        			flag=false;
        			break;
        		default:System.out.println("Wrong input");
        	
        	
        	
        	
        	
        	
        	}
        }
        
        
        }
}
