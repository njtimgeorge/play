package iview.iview1;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestSparseNumbers {

	@Test
	public void test() {
		Solution s = new Solution();
		
		for(int i=0; i<99;i++) {
		//for(int i=2; i<3;i++) {
			Integer correct = new Integer(s.solution(i));
			Integer try1 = new Integer(s.attempt1(i));
			
			//System.out.println("i    " + Integer.toBinaryString(ii));
			//System.out.println("corr " + Integer.toBinaryString(correct));
			//System.out.println("try1 " + Integer.toBinaryString(try1));
			
			System.out.println(i+ " " + correct + " " + try1);
			
			assertTrue(i < correct);
			assertTrue(correct.equals(try1));			
		}
	}

}
