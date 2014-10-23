// you can also use imports, for example:
// import java.util.*;

package iview.iview1;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private static final int MAX_BITS=31;
    
    public int solution(int N) {
    	
    	for(int i=N+1;i< Integer.MAX_VALUE;i++) {
    		if(isSparse(i)) return i;
    	}
        return Integer.MAX_VALUE;
    }
    
    private boolean isSparse(int N) {
    	boolean ret = true;
        int prev_bit=0;
        int cmp;
                
    	for(int i=0; i< MAX_BITS; i++) {
            cmp = 1<<i;

        	if ((N&cmp) !=0) {
        		if(prev_bit == 1) {
        			ret = false;
        			break;
        		}
        		prev_bit = 1;        		
        	}
        	else {
        		prev_bit =0;
        	}
    		
    	}
    	
    	return ret;
    }    

    public int attempt1(int N) {
    	int prev_bit = 0;
    	int cmp;
    	int ret = N+1;
    	
    	for(int i=0;i< MAX_BITS;i++) {
    		cmp = 1 << i;
    		
    		if(((ret&cmp) != 0) && (prev_bit==1)) {
    			ret = addBits(ret, i);
    		}

    		if((ret&cmp) != 0) { prev_bit=1;}
    		else {prev_bit = 0;}
    	}
        return ret;
    }

    
    private int addBits(int N, int place) {
        int ret=N;
        int cmp;
        
        //toBits(N,"addBits from " + new Integer(N).toString() + " to " + new Integer(place).toString());
        
        
        // loop through subsequent '1's and 0 out until you find the next 0
        // when you find 0, flip to 1 and break out of loop
        
        for(int i=place;i < MAX_BITS; i++) {
            cmp = 1 << i;
            
            if((ret & cmp) == 0) {
                // flip only the 0
                ret |= cmp;
                
                // now zero out the previous ones: otherwise you'll have
                // too large a number
                
                for(int j=i-1; j >=0; j--) {
                    cmp = 1 << j;
                    ret &= ~cmp;                	
                }
                
                break;
            } else {
                // flip the current 1
                ret &= ~cmp;
            }
            
        }
        //toBits(ret,"addBits returns " + new Integer(ret).toString() + " to " + new Integer(place).toString());

        return ret;
    }
    
    @SuppressWarnings("unused")
	private void toBits(int N, String line) {
    	String s="";
    	
    	for(int i=31;i>=0;i--) {
    		if((i+1)%4 == 0) {s=s+' ';}
    		
    		if((N& (1<<i)) >0) {s=s+"1";}
    		else {s=s+"0";}
    	}
    	
    	System.out.println(s + " " + line);
    }
    
    public static void main(String args[]) {
    	
    	System.out.println(new Integer(new Solution().solution(38)).toString()); // 38 expect 40
    	System.out.println(new Integer(new Solution().attempt1(2)).toString()); // 38 expect 40
    	
    }
}
