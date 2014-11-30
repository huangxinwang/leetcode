/**
 * Problem Statement: Clone Graph 
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 */

/**
 * reference 
 * http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node==null) return node;
        
        //1 to 1 hashmap for the original node and copied node, HashMap<original,copy>
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hs = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
        //queue, BFS traveral node
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        //initialize
        //put node into queue
        //put node and its copy to hashmap
        queue.add(node);
        hs.put(node,new UndirectedGraphNode(node.label));
        
        while(!queue.isEmpty()){
            //BFS add unvisited new node to queue
            UndirectedGraphNode curr = queue.pop();
            List<UndirectedGraphNode> neighborsList = curr.neighbors;
            for(UndirectedGraphNode aNeighbor : neighborsList){
                 //copy node
                 UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                 //Case 1: if node is unvisited, add the node to both queue, and hashmap
                 //        add the neighbor of correponding copied node of curr
                if(!hs.containsKey(aNeighbor)){
                    queue.add(aNeighbor);
                    hs.put(aNeighbor,copy);
                    hs.get(curr).neighbors.add(copy);
                }
                //Case 2: if node is visited, just need to update the neighbor of correpsonding copied node of curr
                else
                    hs.get(curr).neighbors.add(hs.get(aNeighbor));
            }
        }
        
        return hs.get(node);
        
        }
    }


//////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/30/2014

//time complexity: O(E), when E is the total number of edges
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node==null) return node;
        
        //use hashmap to maintain the corresponding node of originlist and copylist
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
        //use BFS to traverse node
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        //init
        queue.push(node);
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pop();
            List<UndirectedGraphNode> currneighbor = curr.neighbors;;
            
            //traverse the neighbor of a node
            for(int i=0; i<currneighbor.size(); i++){
                UndirectedGraphNode ori = currneighbor.get(i);
                //if current neighbor is not in map, put it in map and in queue
                if(!map.containsKey(ori)){
                    UndirectedGraphNode cpy = new UndirectedGraphNode(ori.label);
                    map.put(ori, cpy);
                    queue.push(ori);
                    
                }
                
                //copy the neighbor
                map.get(curr).neighbors.add(map.get(ori));
                
            }
        }
        
        return map.get(node);
    }
}
