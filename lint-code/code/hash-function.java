/**
 * a*b%c = (a%c)*(b%c)
 * 
 */

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long val = 1;
        int base = 33;
        long rnt = 0;
        for(int i=0; i<key.length; i++){
            rnt += (val*(int)key[key.length-1-i]%HASH_SIZE);
            val = val * base%HASH_SIZE;
        }
        
        rnt = rnt%HASH_SIZE;
        
        return (int)rnt;
    }
};
