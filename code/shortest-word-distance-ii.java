// 
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it? 

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. 

For example, 
Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 

Given word1 = “coding”, word2 = “practice”, return 3. 
Given word1 = "makes", word2 = "coding", return 1. 

Note: 
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

public class Solution{
  HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
  
  //put words and their index in hashmap
  public void getWords(String[] words){
    for(int i=0; i<words.length; i++){
      List<Integer> list = new ArrayList<Integer>();
      if(map.containsKey(words[i])){
        list = map.get(words[i]);
      }
      list.add(i);
      map.put(words[i], list);
    }
  }
  
  //count the distance
  public int getMinDist(String word1, String word2){
    int min = Integer.MAX_VALUE;
    List<Integer> list1 = map.get(word1);
    List<Integer> list2 = map.get(word2);
    int i = 0;
    int j = 0;
    while(i<list1.size() && j<list2.size()){
      min = Math.min(min, Math.abs(list1.get(i)-list2.get(j)));
      if(list1.get(i)<list2.get(j)){
        i++;
      }else{
        j++;
      }
    }
    
    return min;
  }
}
