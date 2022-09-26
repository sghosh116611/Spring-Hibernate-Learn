package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {

		System.out.println("\n" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public boolean doWork() {

		System.out.println("\n" + getClass() + ": DOING MY WORK");
		return true;
		
	}

	public String getName() {
		System.out.println("In getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("In setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("In getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("In setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
