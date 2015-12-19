// rotate string

//Given a string and an offset, rotate string by offset. (rotate from left to right)


// Example
// Given "abcdefg".

// offset=0 => "abcdefg"
// offset=1 => "gabcdef"
// offset=2 => "fgabcde"
// offset=3 => "efgabcd"
// Challenge
// Rotate in-place with O(1) extra memory.





////////////////////////////////////
// 2015/12/18
// Highlight: logic

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str==null || str.length==0) return;
        
        int len = str.length;
        offset = offset%len;
        
        //reverse first parts (to be shifted right)
        reverse(str, 0, len-1-offset);
        //reverse second parts (to be shifted left)
        reverse(str,len-offset, len-1);
        //reverse all
        reverse(Str,0,len-1);
    }
    
    public void reverse(char[] c, int i, int j){
        while(i<j){
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
    }
}
