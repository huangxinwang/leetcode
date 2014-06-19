/**
 * Problem Statement: Gas Station 
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 */


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        //enumerate each possible starting point
        for(int i=0; i<gas.length; i++){
            
            int sum = 0;
            boolean flag = true;
            
            //check from i to gas.length
            for(int j=i; j<gas.length; j++){
                sum = sum + gas[j];
                sum = sum - cost[j];
                if(sum<0){
                    flag = false;
                    break;
                }
            }
            
            //failed to reach gas.length
            if(flag==false) continue;
           
            //check from 0 to i-1
            for(int j=0; j<i; j++){
                sum = sum + gas[j];
                sum = sum - cost[j];
                if(sum<0){
                    flag = false;
                    break;
                }
            }
            
            
            if(flag) return i;
        }
        
        return -1;
    }
}