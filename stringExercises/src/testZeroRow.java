import static org.junit.Assert.*;

import org.junit.Test;
import tim.util.StringUtil;

public class testZeroRow {

	@Test
	public void testZeroRows() {
		int[][] arr1 = StringUtil.getTestArray(6);
		
		arr1[1][5] = 0;
		
		StringUtil.zeroRows(arr1);

		int[][] arr2 = StringUtil.getTestArray(6);
		
		arr2[1][5] = 0;
		arr2[3][4] = 0;

		StringUtil.zeroRows(arr2);
		
		assertTrue(arr1[1][4] == 0);
		assertTrue(arr2[3][3] == 0);
		assertTrue(arr2[4][4] == 0);

	}

}
