package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import util.LinkedList;

public class TestRemoveDuplicatesNoBuffer {

	@Test
	public void testEmptyList() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		l.removeDuplicatesNoBuffer();
		
		Assert.assertTrue(l.getHead() == null);
	}

	@Test
	public void testListOfOne() {
		Integer[] arry = new Integer[] {1};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.removeDuplicatesNoBuffer();
		
		Assert.assertTrue(l.getHead().getNext() == null);
	}

	@Test
	public void testNoDups() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.removeDuplicatesNoBuffer();
		
		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry.length;i++) {
			Assert.assertEquals(arry[i], n.getElement());
			n=n.getNext();
		}		
	}

	@Test
	public void testDups() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,7,9,13,15,18};
		Integer[] arry1 = new Integer[] {1,3,5,7,9,11,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.removeDuplicatesNoBuffer();
		
		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}

	@Test
	public void testLastDup() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,13,15,18,3};
		Integer[] arry1 = new Integer[] {1,3,5,7,9,11,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.removeDuplicatesNoBuffer();
		
		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}
}
