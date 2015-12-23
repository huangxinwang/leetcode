//Peeking iterator


///////////////////////////////
// 2015/12/23
// Higlight: logic

//Since iterator has no peek() function, we can acheive it by using next() to get next element
//and store it in cache
//If the cache is empty, then next() and hasNext() performs as like before
//Otherwise, it gets from the cache
    
    
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {


   
    Iterator<Integer> iterator;
    boolean cached;
    Integer last;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	  
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(cached) return last;
        else{
            if(iterator.hasNext()){
                cached = true;
                last = iterator.next();
                return last;
            }else return null;
        }
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(cached){
	        cached = false;
	        return last;
	    }
	    else return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    if(cached) return true;
	    else return iterator.hasNext();
	}
}
