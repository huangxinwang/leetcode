// Single number iii

///////////////////////////////////////
// 2015/12/16
// Highlight: bit operation
// XOR of two same number will get 0


public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        //for all other numbers that appear twince, the xor will be 0
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
        }
        
        //find low-bit where xor is 1
        int lowbit = 1;
        for (int i = 0; i < 32; i++) {
            lowbit = 1 << i;
        	if ((xor & lowbit) != 0) {
        		lowbit = i;
        		break;
        	} 
        }
        
        //find numbers where low-bit is 0 or 1    
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<nums.length; i++){
            if( (nums[i]>>lowbit & 1)==0){
                num1 ^= nums[i];
            }else num2 ^= nums[i];
        }
        
        int[] rnt = new int[2];
        rnt[0] = num1;
        rnt[1] = num2;
        return rnt;
    }
}
