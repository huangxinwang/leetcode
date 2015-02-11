### Question:
You are given an n*n array filled with '0' s, and you have to set randomly x number of '1' in that array.

### Requirement:
All positions must have the same probability to get selected, and the array might be huge.


### Code
```
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
		int[][] matrix = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		setRandomNumber1s(matrix, 2);
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public static void setRandomNumber1s(int[][] matrix, int count){
		int numPos = matrix[0].length * matrix.length;
		int[] pos = new int[numPos];
		for(int i=0; i<pos.length; i++){
			pos[i]=  1;
		}
		
		Random r = new Random();
		
		//find the idx to set as 1
		while(count>0){
			int idx = r.nextInt(numPos);
			if(pos[idx]!=0){
				pos[idx] = 0;
				//set the corresponding position in 2D matrix as 1
				setCell(matrix, idx);
				count--;
			}
			
		}
	}
	
	public static void setCell(int[][] matrix, int idx){
		int row = matrix.length;
		int col = matrix[0].length;
		matrix[idx%row][idx/row] = 1;
	}
}
```
