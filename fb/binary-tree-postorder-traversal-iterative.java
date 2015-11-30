/**
* Problem: Binary tree post order traversal
*
*/

nonRecursivePostorder(rootNode)
  nodeStack.push(rootNode)
  while (! nodeStack.empty())
    currNode = nodeStack.peek()
    if ((currNode.left != null) and (currNode.left.visited == false))
      nodeStack.push(currNode.left)
    else 
      if ((currNode.right != null) and (currNode.right.visited == false))
        nodeStack.push(currNode.right)
      else
        print currNode.value
        currNode.visited := true
        nodeStack.pop()
