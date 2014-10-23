package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.StackOfStacks;

public class TestStackOfStacks {

	@Test
	public void TestPopEmptyStack() {
		StackOfStacks<Integer> s = new StackOfStacks<Integer>();
		
		assertNull(s.pop());
	}

	@Test
	public void TestPop1Item() {
		StackOfStacks<Integer> s = new StackOfStacks<Integer>();
		
		Integer i = 42;
		Integer j = 42;
		
		s.push(i);

		assertEquals(j,s.pop());
	}

	@Test
	public void Test1FullStack() {
		StackOfStacks<Integer> s = new StackOfStacks<Integer>();
		
		for(int i=1; i<=10; i++)
			s.push(i);

		for(int i=10; i>0; i--)
			assertEquals(i,s.pop().intValue());
		
	}

	@Test
	public void Test2FullStacks() {
		StackOfStacks<Integer> s = new StackOfStacks<Integer>();
		
		for(int i=1; i<=11; i++)
			s.push(i);

		assertEquals(11, s.pop().intValue());

		for(int i=10; i>0; i--)
			assertEquals(i,s.pop().intValue());
		
	}

	@Test
	public void TestBigStack() {
		StackOfStacks<Integer> s = new StackOfStacks<Integer>();
		
		for(int i=1; i<=256; i++)
			s.push(i);

		for(int i=256; i>0; i--)
			assertEquals(i,s.pop().intValue());
	}

}
