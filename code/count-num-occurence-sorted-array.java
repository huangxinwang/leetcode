// count number of occurence of an element in a sorted array

// 2015/12/05
// Time complexity: O(log n)

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
		int[] arr = new int[]{2,3,4,6,6,6,6,7};
		System.out.println(searchNum(arr,6));
	}
	
	public static int searchNum(int[] arr, int num){
		
		int low = 0;
		int high = arr.length-1;
		
		while(low < high){
			int mid = low + (high-low)/2;
			
			//advance low when <
			if(arr[mid] < num){
				low = mid+1;
			}
			else{
				high = mid;
			}
		}
		
		//get the index of first occurence	
		int first = low;
		
		//get the index of last occurence + 1
		high = arr.length;
		while(low<high){
			
			int mid = low + (high-low)/2;
			//try to advance lower when <=
			if(arr[mid]>num){
				high = mid;
			}
			else{
				low = mid+1;
			}
		}
		
		return (low-first);
		
	}
}
