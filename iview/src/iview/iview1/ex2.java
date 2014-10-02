package iview.iview1;

public class ex2 {
    /* int solution(int[] A, int X) {
    	
        int N = A.length;
        
        if (N == 0) {
            return -1;
        }
        
        // l  
        int l = 0;
        int r = N - 1;
        
        
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    } */
    int solution(int[] A, int X) {
    	
        int N = A.length;
        
        if (N == 0) {
            return -1;
        }
        
        // l  
        int l = 0;
        int r = N - 1;
        
        
        while (l < r) {
            int m = (l + r) / 2;
            
            //System.out.println(l + " " + r + " " + m);
            if (A[m] >= X) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        //System.out.println(l + " " + r);
        if (l == r && A[l] == X) {
            return l;
        }
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] a = new int[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 5;
		a[3] = 9;
		a[4] = 9;
		
		System.out.println(new Integer(new ex2().solution(a, 1)).toString());
		System.out.println(new Integer(new ex2().solution(a, 2)).toString());
		System.out.println(new Integer(new ex2().solution(a, 5)).toString());
		System.out.println(new Integer(new ex2().solution(a, 9)).toString());
		
	}

}
