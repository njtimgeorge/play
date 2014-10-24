package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class TowersOfHanoi {

	private ArrayList<Stack<Integer>> towers;

	@Test
	public void test() {		
		System.out.println("1 disc");
		doTowers(1);
		System.out.println("2 discs");
		doTowers(2);
		System.out.println("3 discs");
		doTowers(3);
		System.out.println("4 discs");
		doTowers(4);
	}
	
	private void doTowers(int nTowers) {
		towers = new ArrayList<Stack<Integer>>();

		for(int i=0; i<3; i++)
			towers.add(new Stack<Integer>());
		
		for(int i=nTowers; i> 0; i--)  towers.get(0).push(i);
		
		moveTower(nTowers, 0,2,1);
		
		assertTrue(towers.get(0).empty());
		assertTrue(towers.get(1).empty());
		assertFalse(towers.get(2).empty());
	}
	
	private void moveTower(int n, int from, int to, int spare ) {
		if(n==1) {
			doMove(from, to);
		} else {
			if(n > 1) moveTower(n-1,from, spare, to);
			doMove(from,to);
			if(n > 1) moveTower(n-1,spare, to, from);
		}
	}
	
	private void doMove(int from, int to) {
		Integer i = towers.get(from).pop();
		
		System.out.println("Moving " + i.toString() + " from " + String.valueOf(from + 1) + " to " + 
				String.valueOf(to+1));
		
		if(!towers.get(to).isEmpty()) 
			assertTrue(i < towers.get(to).peek());
		
		towers.get(to).push(i);		
	}

}
