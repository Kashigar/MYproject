package org.sdet40.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplement implements IRetryAnalyzer {
	 
	  int Count = 0;
	  int retryLimit=4;
	 
	  @Override
	  public boolean retry(ITestResult result) {
	    if (Count < retryLimit) {
	      Count++;
	      return true;
	    }
	    return false;
	  }
	}