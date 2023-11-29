package com.testng;

import org.testng.annotations.Test;

import com.hrm.genericutils.BaseClass;

public class CorporateTest extends BaseClass {
	@Test
	public void addCorporate_1_Test() {
		System.out.println("Add Corporate");
	}

	@Test(groups = "integration")
	public void deleteCorporate_2_Test() {
		System.out.println("Delete Corporate");
	}
}