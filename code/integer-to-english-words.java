// Integer to english words


////////////////////////////////////////////
// 2015/12/15
// Highlight: recursive
// Ref: http://www.cnblogs.com/grandyang/p/4772780.html

public class Solution {
    public String numberToWords(int num) {
        //divide 1000 each time
        String res = covertHunderd(num%1000);
        
        String[] v = new String[]{"Thousand", "Million", "Billion"};
        for(int i=0; i<3; i++){
            //divide 1000 each time
            num = num/1000;
            String curr = new String();
            //recursively decide the higher parts, i.e., num/1000
            if(num%1000!=0){
                curr = numberToWords(num%1000) + " "+v[i];
                if(res.isEmpty()) res = curr;
                else res = curr + " "+res;
            } 
        }
        if(res.isEmpty()) return "Zero";
        return res;
    }
    
    public String covertHunderd(int num){
        String[] v1 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] v2 = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int a = num/100;
        int b = num%100;
        int c = num%10;
        String res = new String();
        if(a>0) res = v1[a]+ " "+"Hundred";
        if(b!=0){
            if(b<20){
                if(res.isEmpty()) res = v1[b];
                else res = res + " "+v1[b];
            }
            else{
                if(res.isEmpty()) res = v2[b/10] + (c==0? "": " " +v1[c]);
                else res = res + " "+ v2[b/10] + (c==0? "": " " +v1[c]);
            }
        }
        return res;
    }
}
