import static org.junit.Assert.*;

import org.junit.Test;
import tim.util.StringUtil;

public class TestStrings {

	@Test
	public void testNullString() {
		String s=null;
		assertTrue(StringUtil.NoRepeatedChars(s));
	}

	@Test
	public void testEmptyString() {
		String s="";
		assertTrue(StringUtil.NoRepeatedChars(s));
	}

	@Test
	public void testNoRepeats() {
		String s = "abcdefghijk 1234567!@#$%^&";
		assertTrue(StringUtil.NoRepeatedChars(s));
	}

	@Test
	public void testSingleChar() {
		String s = "a";
		assertTrue(StringUtil.NoRepeatedChars(s));
	}

	@Test
	public void testTwoDiff() {
		String s ="ab";
		assertTrue(StringUtil.NoRepeatedChars(s));
	}

	@Test
	public void testTwoSame() {
		String s ="aa";
		assertFalse(StringUtil.NoRepeatedChars(s));
	}
	@Test
	public void testRepeat() {
		String s ="abcadef";
		assertFalse(StringUtil.NoRepeatedChars(s));
	}
	@Test

	public void testFinalRepeat() {
		String s ="abcdefghijka";
		assertFalse(StringUtil.NoRepeatedChars(s));
	}
}
