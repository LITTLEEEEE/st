package cn.tju.selenium;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AssertionListener extends TestListenerAdapter {
	 
    @Override
    public void onTestStart(ITestResult result) {
        Assertion.flag = true;       
        Assertion.errors.clear();
    }
     

    private int index = 0;
     

}