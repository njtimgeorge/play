package test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import util.StackSorter;

public class TestStackSorter {

	@Test
	public void testSort10() {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(10);
		s.push(15);
		s.push(11);
		s.push(12);
		s.push(18);
		s.push(19);
		s.push(17);
		s.push(16);
		s.push(14);
		s.push(13);
		
		new StackSorter<Integer>().sort(s);
		
		for(int i=19;i>=10;i--)
			assertEquals(i, s.pop().intValue());
	}

}
