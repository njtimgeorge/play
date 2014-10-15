package tim.util;

import java.util.HashMap;
import java.util.HashSet;

public class StringUtil {
	public static int replaceSpaces(char[] str, int len) {
		int spaces=0;
		int cur=0;
		int ret;
		
		for(cur=0;cur < len;cur++) {
			if(str[cur] == ' ') spaces++;
		}
		
		ret = len+2*spaces;
				
		for(cur--;spaces > 0 && cur>=0;cur--) {
			if(str[cur] == ' ') {
				str[cur + (2*spaces) - 2] = '%';
				str[cur + (2*spaces) - 1] = '2';
				str[cur + (2*spaces)] = '0';
				spaces--;
			} else {
				str[cur + (2*spaces)] = str[cur];
			}
		}
		
		return ret;
	}
	
	public static String compress(String s) {
		if(s == null || s.length() < 4)
			return s;
		
		StringBuilder ret = new StringBuilder();
		
		int count=1;
		int i=1;
		char prev=s.charAt(0);
		
		for(; i < s.length(); i++) {
			if(s.charAt(i) == prev) {
				count++;
			} else {
				ret.append(prev);
				
				if(count > 1) {
					ret.append(Integer.toString(count));
				}
				
				prev = s.charAt(i);
				count=1;
			}
		}

		// catch the final character
		
		ret.append(prev);
		
		if(count > 1) {
			ret.append(Integer.toString(count));
		}
		
		if(ret.length() < s.length())
			return ret.toString();
		else
			return s;
	}
	
	private static class element {
		public int row;
		public int col;
		
		public element(int r,int c) {
			row=r;
			col=c;
		}
		
		boolean equals(element other) {
			return other.row == row && other.col == col;
		}
	}
	
	public static void rotate90InPlace(int[][] arr) throws Exception {
		if(arr.length != arr[0].length) {
			throw new Exception("Array dimensions don't match");
		}
		
		int dim = arr.length;
		
		for(int col=0;col<dim;col++) {
			for(int row=col;row < dim-col-1;row++) {
				rotate(arr,row,col,dim);
			}
		}
		
	}
	
	private static void rotate(int[][] arr, int row, int col, int dim) {
		element el1 = new element(row,col);
		element el2 = new element(dim-el1.col-1, el1.row);
		element el3 = new element(dim-el2.col-1, el2.row);
		element el4 = new element(dim-el3.col-1, el3.row);
		
		assert(row == dim-el4.col-1);
		assert(col == el4.row);
		
		int tmp = arr[el1.row][el1.col];
		
		arr[el1.row][el1.col] = arr[el4.row][el4.col];
		arr[el4.row][el4.col] = arr[el3.row][el3.col];
		arr[el3.row][el3.col] = arr[el2.row][el2.col];
		arr[el2.row][el2.col] = tmp;
	}
	
	public static int[][] rotate90(int[][] arr) throws Exception {
		if(arr.length != arr[0].length) {
			throw new Exception("Array dimensions don't match");
		}
		
		int dim = arr.length;
		
		int[][] ret = new int[dim][dim];
		
		for(int row=0; row<dim;row++) {
			for(int col=0;col<dim;col++){
				ret[dim-col-1][row] = arr[row][col];
			}
		}
		
		
		return ret;
	}
	
	public static int[][] getTestArray(int dim) {
		int[][] ret = new int[dim][dim];
		
		int i=1;
		for(int row=0; row<dim;row++) {
			for(int col=0;col<dim;col++) {
				ret[row][col] = i++;
			}
		}
		
		return ret;
	}

	public static void zeroRows(int[][] arr) {
		HashSet<Integer> zeroRows = new HashSet<Integer>();
		HashSet<Integer> zeroCols = new HashSet<Integer>();
		
		for(int row=0;row<arr.length; row++) {
			for(int col=0;col<arr[row].length;col++) {
				if(arr[row][col] == 0) {
					zeroRows.add(new Integer(row));
					zeroCols.add(new Integer(col));
				}
			}
		}
		
		for(int row: zeroRows) {
			for(int col=0; col < arr[row].length; col++) {
				arr[row][col]=0;
			}
		}

		for(int col: zeroCols) {
			for(int row=0; row < arr.length; row++) {
				arr[row][col]=0;
			}
		}
	}
	
	public static boolean NoRepeatedChars(String s) {
		HashSet<Character> hs = new HashSet<Character>();
		
		for(int i=0;s !=null && i<s.length();i++) {
			Character c = new Character(s.charAt(i));
			
			if(hs.contains(c)) {
				return false;
			}
			
			hs.add(c);
		}
		
		return true;
	}
	
	public static boolean isPerm(String s, String candidate) {
		
		// sanity check for null, empty string
		if(s == null || candidate == null || s.length() == 0 || candidate.length() == 0) {
			return false;
		}
		
		// candidate can't be longer than s
		
		if(s.length() < candidate.length()) {
			return false;
		}
		
		boolean ret = true;
		HashMap<Character,Integer>  s_map = getFrequency(s);
		HashMap<Character,Integer>  c_map = getFrequency(candidate);
		
		for(Character c: c_map.keySet()) {
			if(!s_map.containsKey(c)) {
				ret = false; 
				break;
			} else {
				if(c_map.get(c) > s_map.get(c)) {
					ret=false;
					break;
				}
			}
		}
		
		return ret;
	}

	private static HashMap<Character,Integer> getFrequency(String s) {
		HashMap<Character,Integer> ret = new HashMap<Character, Integer> ();
		
		for (int i=0; i<s.length();i++) {
			Character c = new Character(s.charAt(i));
			
			if(!ret.containsKey(c)) {
				ret.put(c,new Integer(1));
			} else {
				ret.put(c, ret.get(c) + 1);
			}
		}
		
		return ret;
	}
	
	public static boolean isRotation(String s1, String s2) {
		
		if(s1 == null || s2 == null) return false;
		
		if(s1.length() != s2.length()) return false; // a rotation is the same length
		
		if(s1.equals(s2)) return true; // rotated by 0
		
		char first = s1.charAt(0);
		
		for(int i=1;i < s2.length(); i++) {
			if(s2.charAt(i) == first) {
				
				// does s2[i] map to s1[0]?
				
				boolean found = true;
				
				for(int j=1; j<s1.length() && i+j < s2.length();j++) {
					if(s1.charAt(j) != s2.charAt(i+j) ) {
						// s2[i] does not map to s1[0]
						found = false;
						break; 
					}
				}
				
				if(found == true) {
					 return isSubstring(s1.substring(i+1), s2.substring(0,s2.length() - i - 1 )); 
				}
			}
		}
		
		return false;
	}

	public static boolean isRotation1(String s1, String s2) {
		
		if(s1 == null || s2 == null) return false;
		
		if(s1.length() != s2.length()) return false; // a rotation is the same length
		
		if(s1.equals(s2)) return true; // rotated by 0
		
		char first = s1.charAt(0);
		int where = 0;
		boolean found = false;
		int length = s1.length();
		
		// s1[0] maps s2[i]
		// s2[0] matches s1[i] for length - i chars
		
		for(int i=1;i < length; i++) {
			if(s2.charAt(i) == first) {
				
				// does s2[i] map to s1[0]?
				
				found = true;
				
				for(int j=1; j<length && i+j < length;j++) {
					if(s1.charAt(j) != s2.charAt(i+j) ) {
						// s2[i] does not map to s1[0]
						found = false;
						break; 
					}
				}
				
				if(found == true) {
					where = i;
					break;
				}
			}
		}
		
		if(found != true) return false;
		
		System.out.println("found");
		
		for(int i=0;i<length - where - 1;i++) {
			System.out.printf("compare %c %c\n",s1.charAt(where+i+1),s2.charAt(i));
			
			if(s1.charAt(where+i+1) != s2.charAt(i) ) {
				return false;
			}
			
		}
		
		return true;
	}
	
	private static boolean isSubstring(String s1, String s2) {
		if(s1.contains(s2)) return true;
		
		return false;
	}

}
