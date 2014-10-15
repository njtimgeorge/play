package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import util.LinkedList;

public class TestDetectCycle {

	@Test
	public void testNoCycle() {
		Integer[] arry = new Integer[] {0,1,2,3,4,5,6,7,8,9};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		Assert.assertEquals(null,l.detectCycle());		
	}


}
