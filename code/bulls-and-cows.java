// bulls and cows 

////////////////////////////////////////////
// 2015/12/14
// Highlight: hashmap

public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> bullmap = new HashMap<Character,Integer>();
        int bull = 0;
        int cow = 0;
        
        //put character of secret into map
        for(char c: secret.toCharArray()){
            if(bullmap.containsKey(c)){
                bullmap.put(c, bullmap.get(c)+1);
            }else bullmap.put(c,1);
        }
        
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            //Case 1: if match, bull+1, deducted value
            if(c1 == c2){
                bull++;
                bullmap.put(c1, bullmap.get(c1)-1);
                //over-deducted, update cow
                if(bullmap.get(c1)<0) cow--;
            }else{
                //case 2: not match, but contains in other position
                if(bullmap.containsKey(c2) && bullmap.get(c2)>0){
                    cow++;
                    bullmap.put(c2, bullmap.get(c2)-1);
                } 
            }
        }
        
        return bull+"A"+cow+"B";
    }
}
