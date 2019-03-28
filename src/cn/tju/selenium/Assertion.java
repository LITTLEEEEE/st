package cn.tju.selenium;

import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;

public class Assertion {
	public static boolean flag = true;
    
    public static List<Error> errors = new ArrayList<Error>();
     static int f = 0;
    @SuppressWarnings("deprecation")
	public static void verifyEquals(Object actual, Object expected){
        try { 
        	AssertJUnit.assertEquals(actual, expected);
        }catch(Error e){
        	f++;
            errors.add(e);
            flag = false;
            System.out.print("´íÎóÊı£º "+f);
            System.out.println("         ´íÎóÎ»ÖÃ£º"+expected);
        }
    }
    public static void printerror() {
    	System.out.print(errors);
    }
}
