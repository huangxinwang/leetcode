/**
 * Problem Statement: Word Ladder II 
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */




/**
 * Reference
 * http://www.blogjava.net/menglee/archive/2014/01/02/408381.html
 */


public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        
        ArrayList<ArrayList<String>> rnt = new ArrayList<ArrayList<String>>();
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
        wordQueue.add(start);
        distanceQueue.add(1);
        
        int min_distance = -1;
        
        while(!wordQueue.isEmpty()){
            
            String currWord = wordQueue.pop();
            int distance = distanceQueue.pop();
            
            if(currWord.equals(end))
                min_distance = distance;
                
            else{
                char[] currWordArray = currWord.toCharArray();
                
                for(char c = 'a'; c<='z'; c++){
                    currWordArray[i] = c;
                    
                    String newWord = new String(currWordArray);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(distance+1);
                        dict.remove(newWord);
                        
                    }
                }
                
                
            }
        }
    }
}