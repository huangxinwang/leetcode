/**
*
*
* 
* Ref: http://stackoverflow.com/questions/5682218/data-structure-insert-remove-contains-get-random-element-all-at-o1
* Consider a data structure composed of a hashtable H and an array A. The hashtable keys are the elements in the data structure, and the values are their positions in the array.

insert(value): append the value to array and let i be it's index in A. Set H[value]=i.
remove(value): We are going to replace the cell that contains value in A with the last element in A. let d be the last element in the array A at index m. let i be H[value], the index in the array of the value to be removed. Set A[i]=d, H[d]=i, decrease the size of the array by one, and remove value from H.
contains(value): return H.contains(value)
getRandomElement(): let r=random(current size of A). return A[r].
since the array needs to auto-increase in size, it's going to be amortize O(1) to add an element, but I guess that's OK.
*
*
