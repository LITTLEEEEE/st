import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortTest {
	BubbleSort b = new BubbleSort();
	@Test
	public void test() {
		int arr[] = new int[]{1,6,2,2,5};
		int acarr[] = new int[]{1,2,2,5,6};
		assertEquals(Arrays.toString(b.BubbleSort(arr)),Arrays.toString(acarr));
	}

}
