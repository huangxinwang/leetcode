public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        
        Arrays.sort(numbers);
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<numbers.length; i++){
            //avoid repeatition
            if(i>0 && numbers[i-1]==numbers[i]){
                continue;
            }
            int remain = -numbers[i];
            int left = i+1;
            int right = numbers.length-1;
            while(left < right){
                //match
                if(numbers[left] + numbers[right] == remain){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    rnt.add(list);
                    //skip repeat numbers
                    int leftVal = numbers[left];
                    int rightVal = numbers[right];
                    while(numbers[left] == leftVal && left<right) left++;
                    while(numbers[right] == rightVal && left<right) right--;

                }
                //advance left
                while(left < numbers.length-1 && numbers[left]+numbers[right]<remain)
                    left++;
                //advance right
                while(right > 0 && numbers[left] + numbers[right] > remain)
                    right--;
            }
        }
        
        return rnt;
    }
}
