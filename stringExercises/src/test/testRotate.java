package test;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import tim.util.StringUtil;

public class testRotate {

	@Test
	public void test() {
		try {
			
		int[][] arr3 = StringUtil.getTestArray(3);
		int[][] arr4 = StringUtil.getTestArray(4);
		int[][] arr5 = StringUtil.getTestArray(5);
		int[][] arr6 = StringUtil.getTestArray(6);
		
		int[][] res3 = StringUtil.rotate90(arr3);
		int[][] res4 = StringUtil.rotate90(arr4);
		int[][] res5 = StringUtil.rotate90(arr5);
		int[][] res6 = StringUtil.rotate90(arr6);
		
		StringUtil.rotate90InPlace(arr3);
		StringUtil.rotate90InPlace(arr4);
		StringUtil.rotate90InPlace(arr5);
		StringUtil.rotate90InPlace(arr6);
		
		assertTrue(arrayEquals(arr3, res3));
		assertTrue(arrayEquals(arr4, res4));
		assertTrue(arrayEquals(arr5, res5));
		assertTrue(arrayEquals(arr6, res6));
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			fail("caught exception " + ex.getMessage());
		}
	}
	
	private boolean arrayEquals(int[][] arr1,int[][] arr2) {
		boolean ret=true;
		
		if(arr1.length != arr2.length) return false;
		
		for(int row=0; row<arr1.length;row++) {
			if(arr1[row].length != arr2[row].length) {
				ret=false;
				break;
			}
			for(int col=0;col<arr1[row].length;col++) {
				if(arr1[row][col] != arr2[row][col]) {
					ret = false;
					break;
				}
			}
		}
		
		return ret;
	}
	
}
