package vtiger.Practice;
import java.util.*;

public class program {


	 public int solution(int[] A) 
	    {
			
			
			
	    	int N = A.length;
	        HashSet<Integer> set = new HashSet<Integer>();

	        // Add all positive integers from the array to the set
	        for (int i = 0; i < N; i++) {
	            if (A[i] > 0) {
	                set.add(A[i]);
	            }
	        }

	        // Find the smallest positive integer that does not occur in the array
	        for (int i = 1; i <= N + 1; i++) {
	            if (!set.contains(i)) {
	                return i;
	            }
	        }

	        return -1;
	    }  
 



	public static void main(String[] args) 
	{
		
		  program p=new program(); int A[]={1,5,-6,-9,14};
		  System.out.println(p.solution(A));
		 
		
	}

}
