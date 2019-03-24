package cn.tjucic.st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PPtest {

private PrintPrimes pri;
	
	@Before
	public void setup(){
		pri=new PrintPrimes();
	}
	
	@Test
	public void tests(){
		pri.printPrimes(20);
	}

}
