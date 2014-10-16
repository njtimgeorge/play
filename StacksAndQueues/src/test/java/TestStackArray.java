import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import util.Stack;


public class TestStackArray {

	@Test
	public void testDefaultEmptyPop() {
		Stack<Integer> s = new Stack<Integer>();
		Assert.assertTrue(s.pop() == null);
	}

	@Test
	public void testDefaultPushPop() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		Assert.assertEquals(s.pop().intValue(),1);
	}

	@Test (expected = StackOverflowError.class)
	public void testDefaultStackOverflow() {
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<=256;i++) {
			s.push(i);
		}
	
	}
	@Test
	public void testDefault10Items() {
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i< 10;i++) {
			s.push(i);
		}
		
		for(int i=9;i>= 0;i--) {
			Assert.assertEquals(s.pop().intValue(), i);
		}
		
	}

	@Test
	public void test3StackEmptyPop() {
		Integer[] d = new Integer[768];
		
		Stack<Integer> s1 = new Stack<Integer>(d,0,256);
		Stack<Integer> s2 = new Stack<Integer>(d,256,256);
		Stack<Integer> s3 = new Stack<Integer>(d,512,256);
		
		Assert.assertEquals(s1.pop(),null);
		Assert.assertEquals(s2.pop(),null);
		Assert.assertEquals(s3.pop(),null);
	}

	@Test
	public void test3StackPushPop() {
		Integer[] d = new Integer[768];

		Stack<Integer> s1 = new Stack<Integer>(d,0,256);
		Stack<Integer> s2 = new Stack<Integer>(d,256,256);
		Stack<Integer> s3 = new Stack<Integer>(d,512,256);
		
		s1.push(1);
		s2.push(3);
		s3.push(5);
		
		Assert.assertEquals(s1.pop().intValue(),1);
		Assert.assertEquals(s2.pop().intValue(),3);
		Assert.assertEquals(s3.pop().intValue(),5);
	}

	@Test
	public void test3StackStackOverflow() {
		Integer[] d = new Integer[768];

		Stack<Integer> s1 = new Stack<Integer>(d,0,256);
		Stack<Integer> s2 = new Stack<Integer>(d,256,256);
		Stack<Integer> s3 = new Stack<Integer>(d,512,256);
		
		s1.push(1);
		s2.push(3);
		boolean stackOverflow = false;
		
		try {
			for(int i=0;i<=256;i++) {
				s3.push(i);
			}
		} catch(StackOverflowError e) {
			stackOverflow = true;
		}

		
		Assert.assertEquals(s1.pop().intValue(),1);
		Assert.assertEquals(s2.pop().intValue(),3);

		Assert.assertTrue(stackOverflow);
	}

	@Test
	public void test3Stack10Items() {
		Integer[] d = new Integer[768];

		Stack<Integer> s1 = new Stack<Integer>(d,0,256);
		Stack<Integer> s2 = new Stack<Integer>(d,256,256);
		Stack<Integer> s3 = new Stack<Integer>(d,512,256);
		
		for(int i=0;i< 10;i++) {
			s1.push(i);
			s2.push(i+10);
			s3.push(i+20);
		}
		
		for(int i=9;i>= 0;i--) {
			Assert.assertEquals(s1.pop().intValue(), i);
			Assert.assertEquals(s2.pop().intValue(), i+10);
			Assert.assertEquals(s3.pop().intValue(), i+20);
		}

	}
	
}
