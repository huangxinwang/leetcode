
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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/30/2014
//time complexity: O(n)
public class Solution {
    public int candy(int[] ratings) {
        
        int[] assign = new int[ratings.length];
        
        //scan from left to right, assign candies, 
        //note in this round, we only ensure increasing order, 
        //but may exist the case rate(a) > rate(b), assign(a)<assign(b)
        assign[0] = 1;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                assign[i] = assign[i-1] + 1;
            else 
                assign[i] = 1;
        }
        
        //scan from right to left, deal with case rate(a) > rate(b), assign(a)<assign(b)
        for(int i=ratings.length-1; i>0; i--){
            if(ratings[i-1] > ratings[i] && assign[i-1] <= assign[i]){
                assign[i-1] = assign[i]+1;
            }
        }
        
        //sum up assigned candies
        int sum = 0;
        for(int i=0; i<assign.length; i++)
            sum += assign[i];
        
        return sum;
    }
}
