import static org.junit.Assert.*;

import org.junit.Test;
import tim.util.StringUtil;

public class testReplaceSpaces {

	private char[] strToArray(String s) {
		char[] buffer = new char[256];
		
		s.getChars(0, s.length(), buffer, 0);
		
		return buffer;
	}
	
	@Test
	public void testNULL() {
		String source = null;
		char[] c =  new char[1];

		StringUtil.replaceSpaces(c, 0);	// test for exceptions	
	}
	
	@Test
	public void test1Char() {
		String source = "a";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c,0, len);
		
		assertTrue(source.equals(result));
	}

	@Test
	public void test3Char() {
		String source = "abc";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c, 0, len);
		
		assertTrue(source.equals(result));
	}

	@Test
	public void test1Space() {
		String source = "abc def";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c, 0, len);
		
		assertTrue(result.equals("abc%20def"));
	}

	@Test
	public void testLeadingSpace() {
		String source = " abc def";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c, 0, len);
		
		assertTrue(result.equals("%20abc%20def"));
	}

	@Test
	public void testTrailingSpace() {
		String source = " abc def ";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c,0,len);
		
		assertTrue(result.equals("%20abc%20def%20"));
	}
	@Test
	public void testDoubleTrailingSpace() {
		String source = "abc  ";

		char[] c = strToArray(source);

		int len = StringUtil.replaceSpaces(c, source.length());
		
		String result = new String(c, 0, len);
		String expected = new String("abc%20%20");
		
		assertTrue(result.equals(expected));
	}
}
