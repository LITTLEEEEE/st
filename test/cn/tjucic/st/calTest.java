package cn.tjucic.st;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class calTest{
	private static Calculate cal = new Calculate(); 
	private int inputx;
	private boolean expected;
	//¹¹Ôìº¯Êý
	public calTest(int inputx,Boolean expected){
		this.inputx = inputx;
		this.expected = expected;
	}
	@Parameters
	public static Collection<Object[]> getData(){
	return Arrays.asList(new Object[][]{
	{83,true},
	{-1,true},
	{81,false}
	});
	}
	@Test
	public void testJudge() {
	assertEquals(this.expected,cal.Judge(inputx));
	}

}
