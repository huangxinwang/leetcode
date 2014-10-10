
/**
 * Problem Statement: Candy
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

/**
 * Reference
 * http://blog.csdn.net/zhanghaodx082/article/details/23470257
 */
 
/**
 * TODO
 * Discuss with Hua for the tricks
 */
 
public class Solution {
    public int candy(int[] ratings) {
        
        int sum = 0;
        if(ratings.length==0) return sum;
        
        //store the number of candies assign to each child
        int[] candy = new int[ratings.length];
        
        //travesing from left to right
        //ensure that right child has more candies if he has higher rate
        candy[0] = 1;
        for(int i=0; i<ratings.length-1; i++){
            if(ratings[i+1]>ratings[i])
                candy[i+1] = candy[i]+1;
            else
                candy[i+1] = 1;
        }
        
        
        //traversing from right to left
        //change the candies assigned to left child only when he has less candies and higher rate
        int m = 0;
        for(int i=ratings.length-1; i>=1; i--){
            
            if(ratings[i-1]>ratings[i]){
                m = candy[i]+1;
                if(m > candy[i-1])
                    candy[i-1] = m;
            }
        }
        
        //sum up the number of candies assigned
        for(int i=0; i<ratings.length; i++){
            sum = sum + candy[i];
        }
        
        return sum;
        
        
    }
}