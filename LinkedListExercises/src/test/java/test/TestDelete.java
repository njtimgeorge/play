package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.LinkedList;

public class TestDelete {
	
	@Test
	public void testEmpty() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		LinkedList<Integer> l1 = new LinkedList<Integer>();

		l1.insert(1);
		
		LinkedList<Integer>.Node n = l1.getHead();
		
		l.delete(n);
		
	}

	@Test
	public void testDeleteSole() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insert(1);
				
		l.delete(l.getHead());
		
		assertNull(l.getHead());
	}

	@Test
	public void testDeleteHead() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,7,9,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);

		l.delete(l.getHead());

		assertEquals(l.getHead().getElement().intValue(),3);		
	}
	
	@Test
	public void testDeleteTail() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,7,9,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		LinkedList<Integer>.Node prev=l.getHead();
		for(LinkedList<Integer>.Node n=l.getHead();n!=null;n=n.getNext()) prev=n;

		l.delete(prev);

		for(LinkedList<Integer>.Node n=l.getHead();n!=null;n=n.getNext()) prev=n;

		assertEquals(prev.getElement().intValue(),15);		
	}

	@Test
	public void testDeleteMiddle() {
		Integer[] arry = new Integer[] {1,3,5,7,9,11,7,9,13,15,18};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		LinkedList<Integer>.Node n;
		
		for(n=l.getHead();n!=null;n=n.getNext()) {
			if(n.getElement().intValue() == 7) break;
		}

		l.delete(n);

		for(n=l.getHead();n!=null;n=n.getNext()) {
			if(n.getElement().intValue() == 11) {
				assertEquals(n.getNext().getElement().intValue(), 7);
				return;
			}
		}

		
		fail("Should return in for loop");		
	}

}
