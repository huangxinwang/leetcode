/**
 * Problem:
 * Link:
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-integer-to-roman.html
 * Hardness: ****
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */


public class Solution {
    public String intToRoman(int num) {
        
        String rnt = new String();
        
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int scale = 1000;
        
        //decide the scale of the number
        //resolve the higher parts each time, and resolve the residual next time
        //deal with case of: 4, 5-8, 9 respectively
        for(int i=6; i>=0; i-=2){
            
            int digit = num/scale;
            
            if(digit <= 3){
                for(int j=0; j<digit; j++){
                    rnt += roman[i];
                }
            }
            else if(digit == 4){
                rnt += roman[i];
                rnt += roman[i+1];
            }
            else if (digit>=5 && digit <=8){
                rnt += roman[i+1];
                for(int j=5; j<digit; j++){
                    rnt += roman[i];
                }
            }
            else if(digit ==9 ){
                rnt += roman[i];
                rnt += roman[i+2];
            }
            
            //remain parts
            num = num%scale;
            scale = scale/10;
        }
        
        return rnt;
    }
}

/////////////////////////////////////////////////////////////////////////
//Round 2: 1/7/2015
public class Solution {
    
    public String intToRoman(int num) {
        
        char[] roman = new char[]{'I', 'V', 'X','L','C','D','M'};
        String rnt = "";
        int scale = 1000;
        
        //divide scale
        //decide result to be the following cases: 0-3; 4; 5-8; 9
        for(int i=6; i>=0; i-=2){
            int digit = num/scale;
            
            if(digit<=3){
                for(int j=0; j<digit; j++)
                    rnt += roman[i];
            }
            
            if(digit==4){
                rnt+= roman[i];
                rnt += roman[i+1];
            }
            
            if(digit>=5 && digit <=8){
                    rnt += roman[i+1];
                for(int j=5; j<digit; j++)
                    rnt += roman[i];
            }
            
            if(digit==9){
                rnt += roman[i];
                rnt += roman[i+2];
            }
            
            num = num%scale;
            scale = scale/10;
            }
            
            return rnt;
        }
        
}
