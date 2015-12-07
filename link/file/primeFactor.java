// prime factor

void primeFactors(int n){
  //make it odd
  while(n%2 ==0){
    System.out.print("2");
    n = n/2;
  }
  
  //divide by any
  for(int i=3; i<=Math.sqrt(n); i+=2){
    while(n%i==0){
      System.out.println(i);
      n = n/i;
    }
  }
  
  //handle the case when n is a prime number
  if(n>2) 
    System.out.println(n);
  
  
}
