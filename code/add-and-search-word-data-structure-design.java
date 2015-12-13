///////////////////////////////////
// 2015/12/12
// Highlight: HashMap + TrieNode + DFS
// Time: exceed time limit
//Ref: http://blog.csdn.net/xudli/article/details/45840001

class TrieNode{
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(char c){
        this.c = c;
    }
    public TrieNode(){};
}

public class WordDictionary {

    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            //for next char
            children = t.children;
            if(i==word.length()-1) t.leaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode root){
       if(root==null) return false;
       if(word.length()==0) return root.leaf;
       char c = word.charAt(0);
       if(c=='.'){
           for(char key: root.children.keySet()){
            if(search(word.substring(1,word.length()), root.children.get(key))) return true;
           }
           return false;
       }else if(root.children.containsKey(c)){
           return search(word.substring(1,word.length()), root.children.get(c));
       }
       return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
