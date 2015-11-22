/**
 * Problem Statement: Largest Number 
 * 
 */
 
public class Solution {
    public String largestNumber(int[] num) {
        
        //convert to Integer
        Integer[] newnum = new Integer[num.length];
        boolean validNum = false;
        for(int i=0; i<num.length; i++)
            newnum[i] = (Integer)num[i];
            
        //sort
        Arrays.sort(newnum, new myComparor());
        
        String rnt = new String();
        for(int i=0; i<newnum.length; i++){
            if(newnum[i]==0 && !validNum) continue;
            validNum = true;
            rnt += (newnum[i]+"");
        }
        if(rnt.length()==0) return "0";
        return rnt;
    }
    
     class myComparor implements Comparator<Integer>{
         
         public int compare(Integer num1, Integer num2){
             char[] char1 = (num1+"").toCharArray();
             char[] char2 = (num2+"").toCharArray();
             
             //when finish earlier, repeat last char if last char is larger than first char
             //else return first char
             for(int i=0; i<Math.max(char1.length, char2.length); i++){
                 char c1 = '0';
                 char c2 = '0';
                 if(i<char1.length) c1= char1[i];
                 else{ 
                     c1 = char1[char1.length-1] > char1[0] ? char1[char1.length-1] :char1[0];
                 }
                 if(i<char2.length) c2 = char2[i];
                 else c2 = char2[char2.length-1] > char2[0] ? char2[char2.length-1] :char2[0];
                 if(c1 - c2 !=0) return c2-c1;
             }
             return 0;
         }
     }
}


/////////////////////////////////////////////////
// 2015/11/21
// Highlight: implement comparator, compare two numbers, deal with the case when one number is longger than the other
public class Solution {
    public String largestNumber(int[] nums) {
        
        Integer[] newnum = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            newnum[i] = (Integer)nums[i];
        }
        Arrays.sort(newnum, new NumberComparator());
        String rnt = new String();
        for(int i=0; i<newnum.length; i++){
            if(rnt.length()==0 && newnum[i]==0 && i!=newnum.length-1) continue;
            rnt += newnum[i];
        }
        return rnt;
    }
    
    public class NumberComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            String str1 = String.valueOf(i1);
            String str2 = String.valueOf(i2);
            int i = 0;
            while(i<Math.max(str1.length(), str2.length())){
                char c1 = '0';
                char c2 = '0';
                
                if(i<str1.length()) c1 = str1.charAt(i);
                else{
                    char lastchar = str1.charAt(str1.length()-1) ;
                    char firstchar = str1.charAt(0);
                    c1 = lastchar<firstchar? firstchar: lastchar;
                }
                
                if(i<str2.length()) c2 = str2.charAt(i);
                else{
                    //for the shortter string, we use the max one of the first char or last char for further comparisons
                    char lastchar = str2.charAt(str2.length()-1) ;
                    char firstchar = str2.charAt(0);
                    c2= lastchar<firstchar? firstchar: lastchar;
                }
                
                if(c1-c2!=0) return c2-c1;
                i++;
            }
            
           
            return 0;
        }
    }
}
