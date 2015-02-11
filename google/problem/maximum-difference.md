### Problem
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].

### Example
Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)

### Analysis
- keep track of current max difference
- keep track of current min value
- update these two values when traverse the array

### Code
```java
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
		int[] arr = new int[]{2, 3, 10, 6, 4, 8, 1};
		findMaxDiff(arr);
	}
	
	public static void findMaxDiff(int[] num){
		int max = Integer.MIN_VALUE;
		int currMin = num[0];
		int currMinIdex = 0;
		int currMaxIdex = 0;
		
		for(int i=1; i<num.length; i++){
			int diff = num[i] - currMin;
			//update diff
			if(diff > max){
				max = diff;
				currMaxIdex = i;
			}
			//update currMin
			if(currMin>num[i]){ 
				currMin = num[i];
				currMinIdex = i;
			}
		}
		
		System.out.println("index1 "+currMinIdex);
		System.out.println("idex2 " + currMaxIdex);
		System.out.println("diff "+ max);
	}
}
```
