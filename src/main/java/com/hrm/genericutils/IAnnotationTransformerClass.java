package com.hrm.genericutils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransformerClass implements org.testng.internal.annotations.IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(com.hrm.genericutils.RetryImplementationClass.class);
	}

}