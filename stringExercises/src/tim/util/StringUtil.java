package tim.util;

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
}
