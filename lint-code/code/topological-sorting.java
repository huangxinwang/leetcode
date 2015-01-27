//O(n)

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        
        ArrayList<DirectedGraphNode> rnt = new ArrayList<DirectedGraphNode>();
        
        for(int i=0; i<graph.size(); i++){
            dfs(rnt, set, graph.get(i));
        }
        
        return rnt;
    }
    
    public void dfs(ArrayList<DirectedGraphNode> rnt, HashSet<DirectedGraphNode> set, DirectedGraphNode node){
        if(set.contains(node)) return;
        set.add(node);
        for(int i=0; i<node.neighbors.size(); i++){
            dfs(rnt, set, node.neighbors.get(i));
        }
        rnt.add(0,node);
    }
}
