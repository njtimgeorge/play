package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.SetOfStacks;

public class TestSetOfStacks {

	@Test
	public void TestPopEmptyStack() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		assertEquals(0, s.getStackCount());
		assertNull(s.pop());
	}

	@Test
	public void TestPop1Item() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		Integer i = 42;
		Integer j = 42;
		
		s.push(i);

		assertEquals(1, s.getStackCount());
		
		assertEquals(j,s.pop());
		
		assertEquals(0, s.getStackCount());
	}

	@Test
	public void Test1FullStack() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		for(int i=1; i<=10; i++)
			s.push(i);

		assertEquals(1, s.getStackCount());

		for(int i=10; i>0; i--)
			assertEquals(i,s.pop().intValue());
		
	}

	@Test
	public void Test2FullStacks() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		for(int i=1; i<=11; i++)
			s.push(i);

		assertEquals(2, s.getStackCount());
		assertEquals(11, s.pop().intValue());
		assertEquals(1, s.getStackCount());

		for(int i=10; i>0; i--)
			assertEquals(i,s.pop().intValue());
		
	}

	@Test
	public void TestBigStack() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		for(int i=1; i<=256; i++)
			s.push(i);

		for(int i=256; i>0; i--)
			assertEquals(i,s.pop().intValue());

		assertEquals(0, s.getStackCount());
	}

	@Test
	public void TestPopAt() {
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		
		for(int i=1; i<=45; i++)
			s.push(i);

		assertEquals(5, s.getStackCount());
		assertEquals(30, s.popAt(2).intValue());

		for(int i=44; i>0; i--) {
			int cmp = i>=30?i+1:i;
			assertEquals(cmp,s.pop().intValue());			
		}
		
	}

}
