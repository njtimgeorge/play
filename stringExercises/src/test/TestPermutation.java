package test;
import static org.junit.Assert.*;
import tim.util.*;

import org.junit.Test;


public class TestPermutation {

	@Test
	public void testNull() {
		String s = null;
		String c = null;
		
		assertFalse(StringUtil.isPerm(s, c));
	}
	
	@Test
	public void testEmpty() {
		String s = "";
		String c = "";
		
		assertFalse(StringUtil.isPerm(s, c));
	}

	@Test
	public void test1AndEmpty() {
		String s = "a";
		String c = "";
		
		assertFalse(StringUtil.isPerm(s, c));
	}

	@Test
	public void testSmall() {
		String s = "aa";
		String c = "a";
		
		assertTrue(StringUtil.isPerm(s, c));
	}

	@Test
	public void testSmallNot() {
		String s = "ab";
		String c = "c";
		
		assertFalse(StringUtil.isPerm(s, c));
	}

	@Test
	public void testYes() {
		String s = "aabbcc";
		String c = "abc";
		
		assertTrue(StringUtil.isPerm(s, c));
	}

	@Test
	public void testLarge() {
		String s = "abcdef";
		String c = "dd";
		
		assertFalse(StringUtil.isPerm(s, c));
	}

}
