// Having integers in a nested list, multiply the integer by it's nested level and then add all the integers. 

// dfs

private int getListSum(List<NestedInteger> list, int depth){
  int sum = 0;
  NestedInteger ni = null;
  while(list.hasNext()){
    ni = list.next;
    if(ni.isInteger()) sum += ni.getInteger()*depth;
    else sum += getListSum(ni.getList(), depth+1);
  }
}

public int getSum(NestedInteger ni){
  if(ni.isInteger()) return ni.getInteger();
  else return getListSum(ni.getList(), 1);
}
