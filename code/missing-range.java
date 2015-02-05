/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] A = new int[]{0, 1,3, 50, 75};
		int lower = 0;
		int upper = 99;
		findMissingValue(A, lower, upper);
	}
	
	public static String make(int from, int to){
		StringBuffer sb  = new StringBuffer();
		sb.append(from);
		if(from < to){
			sb.append("->");
			sb.append(to);
		}
		
		return sb.toString();
	}
	
	public static void findMissingValue(int[] A, int lower, int upper){
	
		List<String> rnt = new ArrayList<String>();
		
		for(int i=0; i<A.length && (lower <= upper) && (A[i] <= upper); i++){
			if(A[i] > lower){
				rnt.add(make(lower, A[i]-1));
				lower = A[i] + 1;
			}
			else if(A[i] == lower)
				lower ++;
		}
		
		if(lower <= upper){
			rnt.add(make(lower, upper));
		}
		
		for(int i=0; i<rnt.size(); i++){
			System.out.println(rnt.get(i));
		}
	}
	
	
}
