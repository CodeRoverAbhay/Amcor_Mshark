package com.testng;

import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;

public class AdminTest extends BaseClass{
	@Test(groups = "smoke")
	public void addAdmin_1_Test() {
		System.out.println("Add Admin");
	}

	@Test(groups = "smoke")
	public void deleteAdmin_2_Test() {
		System.out.println("Delete Admin");
	}
}