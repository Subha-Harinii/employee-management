package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.dao.EmployeeDao;
import com.example.employee.Employee;




@Controller
public class MyController 
{
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping("/")
	public String loginUser()
	{
		return "login.html";
	}
	
	@RequestMapping("/home")
	public String homePage()
	{
		return "home.html";
	}
	
	@RequestMapping("/insertemp")
	public String insertEmployee(Employee e )
	{
		if(dao.existsById(e.getE_id()))
			System.out.println("sorry already employee exixts with:"+e.getE_id());
		else
		    dao.save(e);
		return "";
	}
	
}