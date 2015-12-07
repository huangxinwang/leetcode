// Readers always have higher priority than Writer
// At most one writer can write at one time

int activeReaders = 0;
int activeWriters = 0;
int waitReader = 0;
int waitWriter = 0;
binarySemaphore mutex = new binarySemaphore(1);
binarySemaphore reader_q = new binarySemaphore(0);
binarySemaphore writer_q = new binarySemaphore(0);

public class Reader{
  
  public void beginRead(){
    mutex.P();
    //wait for to writer 
    if(activeWriters>0){
      waitReader++;
      mutex.V();
      reader_q.P();
    }
    
    //being waked up
    activeReaders++;
    if(waitReader>0){
      waitReader--;
      reader_q.V();
    }
    //it is the last reader
    else
      mutex.V();
  }
  
  public abstract void read();
  
  public void endRead(){
    mutex.P();
    activeReader--;
    if(activeReader == 0 && waitWriter>0)){
        waitWriter--;
        writer_q.V();
    }
    else
      mutex.V();
  }
}


public class Writer{
  
  public void beginWrite(){
    mutex.P();
    if(activeReaders>0 || activeWriters>0){
      waitWriters++;
      mutex.V();
      writer_q.P();
    }
    activeWriters++;
    mutex.V();
  }
  
  public void endWrite(){
    mutex.P();
    activeWriter--;
    //some reader is waiting
    if(waitReaders>0){
      waitReaders--;
      reader_q.V();
    }else if(waitWriters>0){
      waitWriters--;
      writer_q.V();
    }
    else
      mutex.V();
  }
  
}
