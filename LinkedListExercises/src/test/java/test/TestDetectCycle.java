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

	@Test
	public void testCycle() {
		Integer[] arry = new Integer[] {0,1,2,3,4,5,6,7,8,9};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.corrupt(l.getHead().getNext().getNext(), l.getHead().getNext().getNext().getNext().getNext());
		
		Assert.assertEquals(l.getHead().getNext().getNext(),l.detectCycle());		
	}
}
