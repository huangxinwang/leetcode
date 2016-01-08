/////////////////////////
// 2016/01/08
// Highlight: corner case

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        String type = time.substring(time.length()-2,time.length());
        String hour = time.substring(0,2);
        String rnt = new String();
       
        int val = Integer.parseInt(hour);
        //decide if PM or AM
        if(type.equals("PM")){
            //for 12:xx:xx PM, it should be 12:xx:xx
            //for the others like 11:xx:xx, convert to 23:xx:xx
            if(val<12) val += 12;
            rnt = val+"";
        }else{
            //for 12:xx:xx AM, it should be 00:xx:xx
            //for the others, remain the same
            if(val>=12) val -= 12;
            if(val<10) rnt = "0";
            rnt += val+"";
        }
        rnt += time.substring(2,time.length()-2);
        System.out.println(rnt);
    }
}
