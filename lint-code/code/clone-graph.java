/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node==null) return null;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        dfs(node, map);
        return map.get(node.label);
    }
    
    public void  dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        ArrayList<UndirectedGraphNode> copyNeighbors = new ArrayList<UndirectedGraphNode>();
        
        ArrayList<UndirectedGraphNode> neighbors = node.neighbors;
        
        for(int i=0; i<neighbors.size(); i++){
            
            UndirectedGraphNode neighborNode = neighbors.get(i);
            int label = neighborNode.label;
            if(!map.containsKey(label)){
               dfs(neighborNode, map); 
            }
            
            copyNeighbors.add(map.get(label));
        }
        
        newnode.neighbors = copyNeighbors;
        map.put(newnode.label, newnode);
    }
}
