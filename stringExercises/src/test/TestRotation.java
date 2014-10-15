package test;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import tim.util.StringUtil;


public class TestRotation {

	@Test
	public void test1Char() {
		String s1 = new String("a");
		String s2 = new String("a");
		
		Assert.assertTrue(StringUtil.isRotation(s1, s2));
	}

	@Test
	public void test1CharDiff() {
		String s1 = new String("a");
		String s2 = new String("b");
		Assert.assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testNull() {
		String s1 = null;
		String s2 = new String("b");
		Assert.assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testRotation() {
		String s1 = new String("abcde");
		String s2 = new String("deabc");
		Assert.assertTrue(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testSame() {
		String s1 = new String("abcde");
		String s2 = new String("abcde");
		Assert.assertTrue(StringUtil.isRotation(s1, s2));
	}

	@Test
	public void testNoCommon() {
		String s1 = new String("abcde");
		String s2 = new String("fghij");
		Assert.assertFalse(StringUtil.isRotation(s1, s2));
	}
	
	@Test
	public void testOffByLast() {
		String s1 = new String("abcde");
		String s2 = new String("deabd");
		Assert.assertFalse(StringUtil.isRotation(s1, s2));
	}
	
}
