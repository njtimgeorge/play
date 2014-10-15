package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import util.Adder;
import util.LinkedList;

public class TestAdder {

	@Test
	public void testExample() {
		Integer[] a1 = {7,1,6};
		Integer[] a2 = {5,9,2};
		
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		LinkedList<Integer> l2 = new LinkedList<Integer> ();
		
		l1.insertArray(a1);
		l2.insertArray(a2);
		
		LinkedList<Integer> res = Adder.add(l1, l2);
		
		Assert.assertEquals(2, res.getHead().getElement().intValue());
		Assert.assertEquals(1, res.getHead().getNext().getElement().intValue());
		Assert.assertEquals(9, res.getHead().getNext().getNext().getElement().intValue());
	}

	@Test
	public void testAnother() {
		Integer[] a1 = {0,0,6};
		Integer[] a2 = {5,9,2,1,5};
		
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		LinkedList<Integer> l2 = new LinkedList<Integer> ();
		
		l1.insertArray(a1);
		l2.insertArray(a2);
		
		LinkedList<Integer> res = Adder.add(l1, l2);
		
		Assert.assertEquals(5, res.getHead().getElement().intValue());
		Assert.assertEquals(9, res.getHead().getNext().getElement().intValue());
		Assert.assertEquals(8, res.getHead().getNext().getNext().getElement().intValue());
		Assert.assertEquals(1, res.getHead().getNext().getNext().getNext().getElement().intValue());
		Assert.assertEquals(5, res.getHead().getNext().getNext().getNext().getNext().getElement().intValue());
	}

	@Test
	public void testExampleReverse() {
		Integer[] a1 = {6,1,7};
		Integer[] a2 = {2,9,5};
		
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		LinkedList<Integer> l2 = new LinkedList<Integer> ();
		
		l1.insertArray(a1);
		l2.insertArray(a2);
		
		LinkedList<Integer> res = Adder.addReverse(l1, l2);
		
		Assert.assertEquals(9, res.getHead().getElement().intValue());
		Assert.assertEquals(1, res.getHead().getNext().getElement().intValue());
		Assert.assertEquals(2, res.getHead().getNext().getNext().getElement().intValue());
	}

	@Test
	public void testAnotherReverse() {
		Integer[] a1 = {6,0,0};
		Integer[] a2 = {5,1,2,9,5};
		
		LinkedList<Integer> l1 = new LinkedList<Integer> ();
		LinkedList<Integer> l2 = new LinkedList<Integer> ();
		
		l1.insertArray(a1);
		l2.insertArray(a2);
		
		LinkedList<Integer> res = Adder.addReverse(l1, l2);
		
		Assert.assertEquals(5, res.getHead().getElement().intValue());
		Assert.assertEquals(1, res.getHead().getNext().getElement().intValue());
		Assert.assertEquals(8, res.getHead().getNext().getNext().getElement().intValue());
		Assert.assertEquals(9, res.getHead().getNext().getNext().getNext().getElement().intValue());
		Assert.assertEquals(5, res.getHead().getNext().getNext().getNext().getNext().getElement().intValue());
	}

}
