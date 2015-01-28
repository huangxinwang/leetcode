public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        //write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        
        for(int i=0; i<numbers.length-3; i++){
            //avoid repeatition
            if(i>0 && numbers[i]==numbers[i-1]) continue;
            
            for(int j=i+1; j<numbers.length-2; j++){
                //avoid repeatition
                if(j>i+1 && numbers[j]==numbers[j-1]) continue;
                
                int remain = target - numbers[i] - numbers[j];
                int left = j+1;
                int right = numbers.length-1;
                //found
                while(left < right){
                    if(numbers[left] + numbers[right] == remain){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        rnt.add(list);
                        left++;
                        right--;
                        while(left<right && numbers[left]==numbers[left-1]) left++;
                        while(left<right && numbers[right]==numbers[right+1]) right--;
                    }
                    if(numbers[left] + numbers[right] < remain && left<numbers.length) left++;
                    if(numbers[left] + numbers[right] > remain && right >0) right--;
                }
            }
        }
        
        return rnt;
    }
}

