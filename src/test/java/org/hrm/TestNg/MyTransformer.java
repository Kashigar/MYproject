package org.hrm.TestNg;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstruct, Method testmethod) {
		
		annotation.setRetryAnalyzer(org.sdet40.GenericUtility.RetryAnalyzerImplement.class);
	}

}
