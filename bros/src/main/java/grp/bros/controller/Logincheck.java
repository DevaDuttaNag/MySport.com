package grp.bros.controller;
import java.sql.*;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import grp.bros.model.Login;
import grp.bros.service.Productservice;
import grp.bros.service.ProductserviceC;


public class Logincheck  {
	private String log,pas;

	private Productservice  loginservice=new ProductserviceC();


	
	public String emid,pwrd;


	public void setEmid(String emid) {
		this.emid = emid;
	}


	public void setPwrd(String pwrd) {
		this.pwrd = pwrd;
	}
	public boolean check()
	{
		System.out.println("ok amma");
	/*	List<Login> lst=loginservice.getProducts();
		
		for(Login l:lst)
		{
			log=l.getLoginid();
			pas=l.getPassword();
			System.out.println(log+" am awesome man "+pas);
		}*/
		
		if(emid.equals(log) && pwrd.equals(pas))
		    return true;
	else  
			return false;
	}
	}
