// Semaphore 

int[] buffer = new int[n]; //state the buffer size
countSemaphore emptySlot = new countSemaphore(n);
countSemaphore fullSlot = new countSemaphore(0);

public class Producer{
  int in = 0;
  
  public void produce(int item){
    emptySlot.P();
    buffer[in] = item;
    in = (in+1)%n;
    fullSlot.V();
  }
}

public class Consumer{
  int out = 0;
  
  public int consume(){
    fullSlot.P();
    int rnt = buffer[out];
    out = (out+1)%n;
    emptySlot.V();
    return rnt;
  }
}
