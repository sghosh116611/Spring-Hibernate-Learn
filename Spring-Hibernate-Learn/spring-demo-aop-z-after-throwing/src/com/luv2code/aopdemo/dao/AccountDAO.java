package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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

	public List<Account> findAccounts(boolean flag) throws Exception {

		if(flag) {
			throw new Exception("No soup for you");
		}
		List<Account> myAccounts = new ArrayList<>();

		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Jitu", "Test");
		Account temp3 = new Account("Madhu", "Plat");

		// add to the accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;

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
