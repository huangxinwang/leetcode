/**
* turn binary search tree to array
*
*/ 

int fill_array(Node root, int[] array, int pos){
  if(root.left!=null){
    pos = fill_array(root.left, array, pos);
  }
  array[pos] = root.element;
  pos++;
  if(root.right!=null){
    pos = fill_array(root, array, pos);
  }
  return pos;
}
