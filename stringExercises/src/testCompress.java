import static org.junit.Assert.*;

import org.junit.Test;
import tim.util.StringUtil;

public class testCompress {

	@Test
	public void testNull() {
		String s = null;
		String result = StringUtil.compress(s);
		
		assertTrue(result == null);
	}

	@Test
	public void testEmpty() {
		String s = "";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}

	@Test
	public void test1() {
		String s = "a";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}

	@Test
	public void test2() {
		String s = "ab";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}
	
	@Test
	public void test3() {
		String s = "abc";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}
	@Test
	public void test3withrepeats() {
		String s = "aab";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}
	@Test
	public void testcompress() {
		String s = "aaab";
		String result = StringUtil.compress(s);
		
		assertTrue(result.equals("a3b"));
	}
	
	@Test
	public void testmore() {
		String s = "abcdefgh";
		String result = StringUtil.compress(s);
		
		assertTrue(result == s);
	}
	@Test
	public void testmiddle() {
		String s = "abbbc";
		String result = StringUtil.compress(s);
		
		assertTrue(result.equals("ab3c"));
	}

	@Test
	public void testend() {
		String s = "abcccc";
		String result = StringUtil.compress(s);
		
		assertTrue(result.equals("abc4"));
	}

	@Test
	public void testmulti() {
		String s = "abbccccdde";
		String result = StringUtil.compress(s);
		
		assertTrue(result.equals("ab2c4d2e"));
	}

}
