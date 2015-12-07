// R2: reader has higher priority, when it is not lead reader; lead reader will wait for all earlier writer to finish

int activeReader = 0;
binarySemaphore mutex = new binarySemaphore(1);
binarySemaphore writer_reader_q = new binarySemaphore(1); //initially, it can be use

public class Reader(){
  
  public void beginRead(){
    mutex.P();
    activeReader++;
    if(activeReader==1){
      writer_reader_q.P();
    }
    mutex.V();
  }
  
  public abstract void read();
  
  public void endRead(){
    mutex.P();
    activeReader--;
    if(activeReader==0){
      writer_reader_q.V();
    }
    mutex.V();
  }
}

public class Writer(){
  public void beginWrite(){
    writer_reader_q.P();
  }
  
  public void abstract write();
  
  public void endWrite(){
    writer_reader_q.V();
  }
}
