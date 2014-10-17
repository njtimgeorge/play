import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import util.Stack;
import util.StackWithMin;


public class TestStackWithMin {

	@Test
	public void testDefaultEmptyPop() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		Assert.assertTrue(s.pop() == null);
	}

	@Test
	public void testDefaultEmptyMin() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		Assert.assertTrue(s.min() == null);
	}

	@Test
	public void testDefaultPushPop() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		s.push(1);
		Assert.assertEquals(s.pop().intValue(),1);
	}

	@Test
	public void testDefault10Items() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		
		for(int i=0;i< 10;i++) {
			s.push(i);
		}
		
		for(int i=9;i>= 0;i--) {
			Assert.assertEquals(s.min().intValue(), 0);
			Assert.assertEquals(s.pop().intValue(), i);
		}
		
	}	
	@Test
	public void testMin() {
		StackWithMin<Integer> s = new StackWithMin<Integer>();
		Integer[] ints={0,1,5,2,3,7,8,9};

		Assert.assertEquals(s.min(), null);
		Assert.assertEquals(s.pop(), null);

		s.push(9);
		Assert.assertEquals(s.min().intValue(), 9);
		Assert.assertEquals(s.peek().intValue(), 9);
		s.push(8);
		Assert.assertEquals(s.min().intValue(), 8);
		Assert.assertEquals(s.peek().intValue(), 8);
		s.push(7);
		Assert.assertEquals(s.min().intValue(), 7);
		Assert.assertEquals(s.peek().intValue(), 7);
		s.push(3);
		Assert.assertEquals(s.min().intValue(), 3);
		Assert.assertEquals(s.peek().intValue(), 3);
		s.push(2);
		Assert.assertEquals(s.min().intValue(), 2);
		Assert.assertEquals(s.peek().intValue(), 2);
		s.push(5);
		Assert.assertEquals(s.min().intValue(), 2);
		Assert.assertEquals(s.peek().intValue(), 5);
		s.push(1);
		Assert.assertEquals(s.min().intValue(), 1);
		Assert.assertEquals(s.peek().intValue(), 1);
		s.push(0);
		Assert.assertEquals(s.min().intValue(), 0);
		Assert.assertEquals(s.peek().intValue(), 0);

		Assert.assertEquals(s.pop().intValue(), 0);
		Assert.assertEquals(s.min().intValue(), 1);

		Assert.assertEquals(s.pop().intValue(), 1);
		Assert.assertEquals(s.min().intValue(), 2);

		Assert.assertEquals(s.pop().intValue(), 5);
		Assert.assertEquals(s.min().intValue(), 2);

		Assert.assertEquals(s.pop().intValue(), 2);
		Assert.assertEquals(s.min().intValue(), 3);

		Assert.assertEquals(s.pop().intValue(), 3);
		Assert.assertEquals(s.min().intValue(), 7);

		Assert.assertEquals(s.pop().intValue(), 7);
		Assert.assertEquals(s.min().intValue(), 8);

		Assert.assertEquals(s.pop().intValue(), 8);
		Assert.assertEquals(s.min().intValue(), 9);

		Assert.assertEquals(s.pop().intValue(), 9);
		
		Assert.assertEquals(s.min(), null);
		Assert.assertEquals(s.pop(), null);

		
	}	
}
