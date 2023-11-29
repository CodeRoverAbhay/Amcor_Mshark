package com.testng;

import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;

public class EmployeeTest extends BaseClass {

	@Test(groups = "smoke")
	public void deleteEmployee_2_Test() {
		System.out.println("Delete Employee");
	}

	@Test(groups = { "integration", "system" })
	public void addEmployee_1_Test() {
		System.out.println("Add Employee");
	}
}