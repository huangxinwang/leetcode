// Bounded-buffer monitor, signal and continue

public class BoundedBuffer extends Monitor{
  int capacity = 0;
  int fullSlots = 0;
  int in = 0;
  int out = 0;
  int[] buffer = null;
  conditionalVariable notEmpty = new conditionalVariable();
  conditionalVariable notFull = new conditionalVarialbe();
  
  public BoundedBuffer(int cap){
    capacity = cap;
    buffer = new int[cap];
  }
  
  public void deposit(int val){
    while(fullSlots == capacity){
      notFull.wait();
    }
    buffer[in] = val;
    in = (in+1)%n;
    fullSlots++;
    //not empty now!
    notEmpty.signal();
  }
  
  public int withdraw(){
    //keep waiting if full is null
    while(fullSlots == 0){
      notEmpty.wait();
    }
    int rnt = buffer[out];
    out = (out+1)%n;
    fullSlots--;
    //not full now!
    notFull.signal();
    return rnt;
  }
}
