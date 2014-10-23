package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.LinkedList;

public class TestPalindrome {

	@Test
	public void testPalindrome() {
		Integer[] arry = new Integer[]  {1,0,2,0,1};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		assertTrue(l.isPalindrome());
	}

	@Test
	public void testNotPalindrome() {
		Integer[] arry = new Integer[]  {1,0,2,1,1};
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insertArray(arry);
		
		assertFalse(l.isPalindrome());
	}
}
