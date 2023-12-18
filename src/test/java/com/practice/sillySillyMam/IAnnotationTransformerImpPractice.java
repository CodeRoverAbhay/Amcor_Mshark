package com.practice.sillySillyMam;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class IAnnotationTransformerImpPractice implements IAnnotationTransformer{

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(com.practice.sillySillyMam.RetryAnalyzerImpPractice.class);
	}
}