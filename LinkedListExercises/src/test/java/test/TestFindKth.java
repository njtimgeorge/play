package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import util.LinkedList;

public class TestFindKth {

	@Test
	public void testEmpty() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		Assert.assertTrue(l.findKthElement(0)==null);
	}
	
	@Test
	public void test1Find0() {
		Integer[] arry = new Integer[] {1};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);

		Assert.assertTrue(l.findKthElement(0) == 1);		
	}

	@Test
	public void test1Find10_9() {
		Integer[] arry = new Integer[] {0,1,2,3,4,5,6,7,8,9};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		Assert.assertTrue(l.findKthElement(9) == 0);		
	}

	@Test
	public void test1Find10_5() {
		Integer[] arry = new Integer[] {0,1,2,3,4,5,6,7,8,9};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		Assert.assertTrue(l.findKthElement(5) == 4);		
	}

}
