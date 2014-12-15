/**
 * Problem Statement: Symmetric Tree 
 */




/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        
        //use to store left and right sub-tree
        LinkedList<TreeNode> leftStack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightStack = new LinkedList<TreeNode>();
        
        //initialize
        leftStack.add(root.left);
        rightStack.add(root.right);
        
        //iteratively check symmetric
        while(!leftStack.isEmpty()){
            
            //pop value for check
            TreeNode l = leftStack.pop();
            TreeNode r = rightStack.pop();
            
            if((l==null && r!=null) || (r==null && l!=null))
                return false;
            if(l!=null){
                if(l.val!=r.val) return false;
                
                //iteratively add value
                leftStack.add(l.left);
                leftStack.add(l.right);
                rightStack.add(r.right);
                rightStack.add(r.left);
            }
            
        }
        
        return true;
    }
}


////////////////////////////////////////////////////////////////////
//Round 2: 12/15/2014
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        //BFS travserse the tree layer by layer
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        if(root==null) return true;
        curr.add(root);
        
        //use current layer to construct next layer
        while(curr.size()>0){
            if(!isSym(curr)) return false;
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
        
        return true;
    }
    
    
    //check whether the node in a layer is symmetric
    public boolean isSym(ArrayList<TreeNode> list){
        for(int i=0; i<=list.size()/2; i++){
            TreeNode first = list.get(i);
            TreeNode second = list.get(list.size()-1-i);
            if(first.left==null){
                if(second.right!=null) 
                    return false;
            }
            else{
                if(second.right==null) return false;
                if(second.right.val != first.left.val)
                    return false;
            }
            
            if(first.right==null){
                if(second.left!=null)
                    return false;
            }else{
                if(second.left==null) return false;
                if(second.left.val!=first.right.val)
                    return false;
            }
            
           
        }
        
         return true;
    }
    
}
