import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Collections;
import java.util.Hashtable;
import java.lang.System;

import tim.util.BasicHashTable;
import tim.util.BasicHashTableGeneric;

public class TestHash {

	@Test
	public void TestHash() {
		Hashtable<String,Character> tbl = new Hashtable<String,Character>();
		
		char[] chrs = new char[2];
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				tbl.put(str, chrs[0]);
				
				//System.out.println(str + " " + Integer.toString(str.hashCode()) + " " +  new Character(chrs[0]).hashCode());
			}
		}
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				Character c = tbl.get(str);
				
				assertEquals(new Character(chrs[0]), c);
				//assertEquals(new Character(chrs[1]), c);
				//System.out.println(str + " " + c.toString());
			}
		}

	}
	
	@Test
	public void TestBasicHash() {
		BasicHashTable tbl = new BasicHashTable();
		
		char[] chrs = new char[2];
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				tbl.put(str, chrs[0]);
				
				//System.out.println(str + " " + Integer.toString(str.hashCode()) + " " +  new Character(chrs[0]).hashCode());
			}
		}
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				Object c = tbl.get(str);
				
				assertEquals(new Character(chrs[0]), c);
				//assertEquals(new Character(chrs[1]), c);
				//System.out.println(str + " " + c.toString());
			}
		}

	}
	@Test
	public void TestBasicHashGeneric() {
		BasicHashTableGeneric<String, Character> tbl = new BasicHashTableGeneric<String, Character>();
		
		char[] chrs = new char[2];
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				tbl.put(str, chrs[0]);
				
				//System.out.println(str + " " + Integer.toString(str.hashCode()) + " " +  new Character(chrs[0]).hashCode());
			}
		}
		
		for(char i='a';i<='z';i++)
		{
			chrs[0] = i;
			for(char j='a';j<='z';j++)
			{
				chrs[1] = j;
				String str = new String(chrs);
				
				Character c = tbl.get(str);
				
				assertEquals(new Character(chrs[0]), c);
				//assertEquals(new Character(chrs[1]), c);
				//System.out.println(str + " " + c.toString());
			}
		}

	}

}
