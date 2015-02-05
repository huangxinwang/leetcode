public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        String[] item = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=item.length-1; i>=0; i--){
            if(i<item.length-1) sb.append(" ");
            sb.append(item[i]);
        }
        return sb.toString();
    }
}

