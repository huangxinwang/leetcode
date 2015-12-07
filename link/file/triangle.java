// Count the number of possible triangles

public int count(int[] arr){
  int sum = 0;
  //keep the first and second point, search the possible third points
  for(int i=0; i<arr.length-2; i++){
    int k = i+2;
    for(int j=i+1; j<arr.length; j++){
      while(k<n && arr[i]+arr[j]>arr[k])
        k++;
      
      sum += (k-j-1);
    }
  }
  
  return sum;
}
