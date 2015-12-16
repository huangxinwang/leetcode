// course schedule ii 

/////////////////////////////////////////
// 2015/12/15
// Highlight: dfs, and marks visting, visited nodes
// Time: I think it is O(V+E), since each edge is only traverse once

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> states = new HashMap<Integer, Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //build map, <course, its dependency list>
        for(int i=0; i<prerequisites.length; i++){
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(key))
                list = map.get(key);
            list.add(val);
            map.put(key,list);
        }
        
        //build state map, <course, its state in dfs>
        for(int i=0; i<numCourses; i++){
            states.put(i,1);
        }
        
        //dfs traverse all courses, add course to result during the traverse
        for(int i=0; i<numCourses; i++){
            if(states.get(i)==-1) continue;
            if(states.get(i)==0) return new int[0];
             boolean exit = dfs(states, map,i, result);
            if(!exit) return new int[0];
        }
        
        int[] rnt = new int[numCourses];
        for(int i=0; i<result.size(); i++){
            rnt[i] = result.get(i);
        }
        return rnt;
    }
    
    public boolean dfs(HashMap<Integer, Integer> states, HashMap<Integer, ArrayList<Integer>> map,int val, ArrayList<Integer> result){
        
        //current node has no other depedencieis, add to results directly
        if(!map.containsKey(val)){
            result.add(val);
            states.put(val,-1);
            return true;
        }
        
        //markt the node as being examined,
        //and scan all its dependencies, if meet some nodes that in the state of being examined, then return false
        states.put(val,0);
        ArrayList<Integer> list = map.get(val);
        for(int i=0; i<list.size(); i++){
            int curr = list.get(i);
            if(states.get(curr)==-1) continue;
            if(states.get(curr)==0) return false;
            dfs(states, map,curr, result);
        }
        states.put(val,-1);
        result.add(val);
        return true;
    }
    
}
