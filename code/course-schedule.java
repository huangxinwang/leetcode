/**
* Problem Statement: Course Schedule
*
*here are a total of n courses you have to take, labeled from 0 to n - 1.
*
*Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
**
*Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*
*For example:
*
*2, [[1,0]]
*There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
*
*2, [[1,0],[0,1]]
*There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*
*
*/


/////////////////////////////////////////
//　2015/11/21
// Highlight: dfs, use label to indicate if a node is visited
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
        
        //put nodes and edges in hashmap
        for(int i=0; i<prerequisites.length; i++){
            int key = prerequisites[i][0];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(key)){
                list = map.get(key);
            }
            list.add(prerequisites[i][1]);
            map.put(key, list);
            state.put(prerequisites[i][0],0);
        }
        
        //dfs to see if ring existed start from each node
        for(int i=0; i<prerequisites.length; i++){
            int curr = prerequisites[i][0];
            if(!dfs(map, state, curr)) return false;
        }
        
        return true;
    }
    
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> map, HashMap<Integer, Integer> state, int curr){
        //the node contains ring
        if(state.get(curr)==1) return false;
        //the node is being visited, and does not contain ring
        if(state.get(curr)==-1) return true;
        
        state.put(curr,1);
        
        ArrayList<Integer> list = map.get(curr);
        for(int key: list){
            if(map.containsKey(key)){
                if(!dfs(map, state, key)) return false;
            }
        }
        //mark current node as being visited, and does not contain ring
        state.put(curr,-1);
        return true;
    }
}
