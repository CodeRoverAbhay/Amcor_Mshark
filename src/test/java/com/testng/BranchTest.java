package com.testng;

import org.testng.annotations.Test;

public class BranchTest {
	@Test(groups = "smoke")
	public void addBranch_1_Test() {
		System.out.println("Add Branch");
	}

	@Test(groups = "regression")
	public void deleteBranch_2_Test() {
		System.out.println("Delete Branch");
	}
}