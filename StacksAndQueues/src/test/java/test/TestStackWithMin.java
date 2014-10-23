package test;
import static org.junit.Assert.*;

import org.junit.Test;

import util.StackWithMin;


public class TestStackWithMin {

	@Test
	public void testDefaultEmptyPop() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		assertTrue(s.pop() == null);
	}

	@Test
	public void testDefaultEmptyMin() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		assertTrue(s.min() == null);
	}

	@Test
	public void testDefaultPushPop() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		s.push(1);
		assertEquals(s.pop().intValue(),1);
	}

	@Test
	public void testDefault10Items() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		
		for(int i=0;i< 10;i++) {
			s.push(i);
		}
		
		for(int i=9;i>= 0;i--) {
			assertEquals(s.min().intValue(), 0);
			assertEquals(s.pop().intValue(), i);
		}
		
	}	
	@Test
	public void testMin() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();

		assertEquals(s.min(), null);
		assertEquals(s.pop(), null);

		s.push(9);
		assertEquals(s.min().intValue(), 9);
		assertEquals(s.peek().intValue(), 9);
		s.push(8);
		assertEquals(s.min().intValue(), 8);
		assertEquals(s.peek().intValue(), 8);
		s.push(7);
		assertEquals(s.min().intValue(), 7);
		assertEquals(s.peek().intValue(), 7);
		s.push(3);
		assertEquals(s.min().intValue(), 3);
		assertEquals(s.peek().intValue(), 3);
		s.push(2);
		assertEquals(s.min().intValue(), 2);
		assertEquals(s.peek().intValue(), 2);
		s.push(5);
		assertEquals(s.min().intValue(), 2);
		assertEquals(s.peek().intValue(), 5);
		s.push(1);
		assertEquals(s.min().intValue(), 1);
		assertEquals(s.peek().intValue(), 1);
		s.push(0);
		assertEquals(s.min().intValue(), 0);
		assertEquals(s.peek().intValue(), 0);

		assertEquals(s.pop().intValue(), 0);
		assertEquals(s.min().intValue(), 1);

		assertEquals(s.pop().intValue(), 1);
		assertEquals(s.min().intValue(), 2);

		assertEquals(s.pop().intValue(), 5);
		assertEquals(s.min().intValue(), 2);

		assertEquals(s.pop().intValue(), 2);
		assertEquals(s.min().intValue(), 3);

		assertEquals(s.pop().intValue(), 3);
		assertEquals(s.min().intValue(), 7);

		assertEquals(s.pop().intValue(), 7);
		assertEquals(s.min().intValue(), 8);

		assertEquals(s.pop().intValue(), 8);
		assertEquals(s.min().intValue(), 9);

		assertEquals(s.pop().intValue(), 9);
		
		assertEquals(s.min(), null);
		assertEquals(s.pop(), null);

		
	}	
}
