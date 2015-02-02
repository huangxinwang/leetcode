public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        String news = new String(c1);
        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        String newt = new String(c2);
        if(news.equals(newt)) return true;
        return false;
    }
};
