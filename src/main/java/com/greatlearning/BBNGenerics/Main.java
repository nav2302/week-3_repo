package com.greatlearning.BBNGenerics;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		UserDAOImpl<User> userDao = new UserDAOImpl<>();
		
		
		Customer cust1 = new Customer("Navdeep_cust1", "nav_cust1@gmail.com");
		Customer cust2 = new Customer("Navdeep_cust2", "nav_cust2@gmail.com");
		Employee emp1 = new Employee("Navdeep_emp1", "nav_emp1@gmail.com");
		Employee emp2 = new Employee("Navdeep_emp2", "nav_emp2@gmail.com");
		Visitor vis1 = new Visitor("Navdeep_vis1", "nav_vis1@gmail.com");
		

		userDao.save(cust1);
		userDao.save(cust2);
		userDao.save(emp1);
		userDao.save(emp2);
		userDao.save(vis1);
		User retrieveCustomer1 = userDao.get("nav_cust1@gmail.com");
		System.out.println("GET data for customer 1: " + retrieveCustomer1.getName());
		
		List<User> allUsers = userDao.getAll();
		System.out.println("Printing list of ALL users:::");
		for (User user: allUsers) {
			System.out.println(user.getName() +" , " + user.getEmail());
		}
		
		cust1.setName("Navdeep_cust1_modified");
		userDao.update(cust1);
		User updatedCustomer = userDao.get("nav_cust1@gmail.com");
		System.out.println("UPDATED Name for Customer1 : " + updatedCustomer.getName());

		System.out.println("DELETING user " + emp2.getEmail());
		userDao.delete(emp2);		

	}
}
