/**
 * Problem Statement: Maximum Gap 
 * 
 * 
 */

public class Solution {
    public int maximumGap(int[] num) {
        
        if(num.length<2) return 0;
        int min = num[0];
        int max = num[0];
        for(int i=0; i<num.length; i++){
            if(num[i]<min) min = num[i];
            if(num[i]>max) max = num[i];
        }
        
        //the max diff between two successive numbers in the sorted array should at least be:
        int step = (int)(Math.ceil((double)(max-min)/(num.length-1)));
        //the bucket should be:
        int bucket = (max-min)/step+1;
        
        //put each number in each bucket
        int[] bucketmin = new int[bucket];
        int[] bucketmax = new int[bucket];
        boolean[] notEmpty = new boolean[bucket];
        
        for(int i=0; i<num.length; i++){
            //get index of bucket
            int idx = (num[i]-min)/step;
            if(notEmpty[idx]==false){
                notEmpty[idx] = true;
                bucketmin[idx] = num[i];
                bucketmax[idx] = num[i];
            }
            //only keep max and min value in the bucket
            else{
                if(num[i]<bucketmin[idx]) bucketmin[idx] = num[i];
                if(num[i] > bucketmax[idx]) bucketmax[idx] = num[i];
            }
        }
        
        //calculate the maximum gap
        int pre = 0;
        int rnt = 0;
        for(int i=1; i<bucket; i++){
            if(notEmpty[i]==false) continue;
            int diff = bucketmin[i] - bucketmax[pre];
            if(diff>rnt) rnt = diff;
            pre = i;
        }
        
        
        return rnt;
    }
}
