import static org.junit.Assert.*;

import org.junit.Test;

public class BackPackTest {

	BackPack b = new BackPack();
	@Test
	public void test() {
		 int m = 10;
	     int n = 3;
	     int w[] = {3, 4, 5};
	     int p[] = {4, 5, 6};
	     int c[][] = b.BackPack_Solution(m, n, w, p);
	     int actural[][] = {{0,0,4,4,4,4,4,4,4,4},
		 			{0,0,4,5,5,5,9,9,9,9},
		 			{0,0,4,5,6,6,9,10,11,11}};
	     String ccString = "";
	     String acString = "";
	     for (int i = 1; i <= n; i++) {
	         for (int j = 1; j <= m; j++) {
	                ccString+=c[i][j];
	                acString+=actural[i][j];
	             if (j == m) {

	             }
	         }
	     }
	     assertEquals(ccString, acString);
	     }
	

}
