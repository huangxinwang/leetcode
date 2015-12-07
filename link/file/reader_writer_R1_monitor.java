// reader always has higher priority than writer

public class reader_writer extends Monitor{
  int readCount = 0; //currerent reader
  int signaledReader = 0; //current singaled reader, but haven't enetered monitor
  ConditionalVariable reader_q = new ConditionalVarialbe();
  ConditionalVariable writer_q = new CondtionalVariable();
  boolean isWriting = false;
  
  public void beinRead(){
    if(isWriting){
      reader_q.wait();
      signaledReader--;
    }
    readCount++;
  }
  
  public void endRead(){
    readCount--;
    if(readCount==0 && signaledReader==0){
      writer_q.signal();
    }
  }
  
  public void beginWrite(){
    while(isWriting || readCount>0 ||signaledReader>0 || reader_q.length()>0){
      writer_q.wait();
      isWriting = true;
    }
  }
  
  public void endWrite(){
    isWriting = false;
    if(reader_q.length>0){
      singledReader = reader_q.length();
      reader_q.singalAll();
    }
    else writer_q.signal();
  }
}
