// Shortest word distance iii

public class Solution{
  public int getMin(String[] words, String word1, String word2){
    int min = Integer.MAX_VALUE;
    int idx1 = -1;
    int idx2 = -1;
    for(int i=0; i<words.length; i++){
      if(words[i].equals(word1) && words[i].equals(word2)){
        if(idx1<idx2) idx1 = i;
        else idx2 = i;
      }
      //give the indix to the smaller one
      else if(words[i].equals(word1)) idx1 = i;
      else if(words[i].equals(word2)) idx2 = i;
      if(idx1>=0 && idx2>=0)
        min = Math.min(min, Math.abs(idx1 - idx2));
    }
    
    return min;
  }
}
