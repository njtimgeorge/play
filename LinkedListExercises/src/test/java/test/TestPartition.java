package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import util.LinkedList;

public class TestPartition {

	@Test
	public void testEmptyList() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.insert(1);
		
		l.partition(l1.getHead().getElement());
		
		Assert.assertTrue(l.getHead() == null);	
	}

	@Test
	public void testNull() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insert(1);
		
		l.partition(null);
		
		Assert.assertTrue(l.getHead().getElement().intValue() == 1);	
	}

	@Test
	public void testXNotExist() {
		Integer[] arry = new Integer[]  {0,2,4,8,9,7,5,3,1};
		Integer[] arry1 = new Integer[] {0,2,4,5,3,1,8,9,7};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.partition(6);

		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}

	@Test
	public void testMultiX() {
		Integer[] arry = new Integer[]  {6,0,2,4,6,8,9,7,5,3,6,1};
		Integer[] arry1 = new Integer[] {0,2,4,5,3,1,6,6,6,8,9,7};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.partition(6);

		LinkedList<Integer>.Node n = l.getHead();
		
		//System.out.println("Input    " + arry. toString());
		//System.out.println("Expected " + arry1.toString());
		//System.out.println("Received " + l.toString());
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}
	
	@Test
	public void testNoneLT() {
		Integer[] arry = new Integer[]  {2,4,6,8,9,7,5,3,6};
		Integer[] arry1 = new Integer[] {2,4,6,8,9,7,5,3,6};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.partition(2);

		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}

	@Test
	public void testNoneGT() {
		Integer[] arry = new Integer[]  {2,4,6,8,9,7,5,3,6};
		Integer[] arry1 = new Integer[] {2,4,6,8,7,5,3,6,9};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		l.partition(9);

		LinkedList<Integer>.Node n = l.getHead();
		
		for(int i=0;i<arry1.length;i++) {
			Assert.assertEquals(arry1[i], n.getElement());
			n=n.getNext();
		}		
	}
}
