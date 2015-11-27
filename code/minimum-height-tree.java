/**
* Problem Statement: Minimum Height Trees
* For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
* 
* Format
* The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
* 
* You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
* 
* Example 1:
* 
* Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
* 
*         0
*         |
*         1
*        / \
*       2   3
* return [1]
* 
* Example 2:
* 
* Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
* 
*      0  1  2
*       \ | /
*         3
*         |
*         4
*         |
*         5
* return [3, 4]
*
*/

//////////////////////////////////////////////////
// 2015/11/26
// Highlight: remove leaves at each time
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rnt = new ArrayList<Integer>();
        if(n==1){
            rnt.add(0);
            return rnt;
        }
        if(edges.length==0) return rnt;
       
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        //build a graph, for edge(1,2), create (1,2) and (2,1) in hashmap
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            if(map.containsKey(node1))
                list1 = map.get(node1);
            if(map.containsKey(node2))
                list2 = map.get(node2);
            list1.add(node2);
            list2.add(node1);
            map.put(node1, list1);
            map.put(node2, list2);
        }
        
        //remove node with 1 degree at each time
        while(map.keySet().size()>2){
            ArrayList<Integer> keys = new ArrayList<Integer>();
            for(Integer key: map.keySet()){
                if(map.get(key).size()==1) keys.add(key);
            }
            for(Integer key: keys){
                int neighbour = map.get(key).get(0);
                map.remove(key);
                ArrayList<Integer> list = map.get(neighbour);
                list.remove(new Integer(key));
                map.put(neighbour, list);
            }
        }
        
        //the remaining nodes are the root
        for(Integer key: map.keySet()){
            rnt.add(key);
        }
        
        return rnt;
    }
}
