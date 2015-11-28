/**
* Problem Statement: Grey Code
* Ref: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*/

public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(0);
        
        for(int j=0; j<n; j++){
            int mask = 1<<j;
            ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
            for(int i=tmp.size()-1; i>=0; i--){
                curr.add(tmp.get(i)|mask);
            }
        }
        return curr;
    }
}
