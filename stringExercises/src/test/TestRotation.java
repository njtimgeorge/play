package test;
import static org.junit.Assert.*;

import org.junit.Test;

import tim.util.StringUtil;


public class TestRotation {

	@Test
	public void test1Char() {
		String s1 = new String("a");
		String s2 = new String("a");
		
		assertTrue(StringUtil.isRotation(s1, s2));
	}

	@Test
	public void test1CharDiff() {
		String s1 = new String("a");
		String s2 = new String("b");
		assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testNull() {
		String s1 = null;
		String s2 = new String("b");
		assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testRotation() {
		String s1 = new String("abcde");
		String s2 = new String("deabc");
		assertTrue(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testSame() {
		String s1 = new String("abcde");
		String s2 = new String("abcde");
		assertTrue(StringUtil.isRotation(s1, s2));
	}

	@Test
	public void testNoCommon() {
		String s1 = new String("abcde");
		String s2 = new String("fghij");
		assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testOffByLast() {
		String s1 = new String("abcde");
		String s2 = new String("deabd");
		assertFalse(StringUtil.isRotation(s1, s2));
	}
	
}
