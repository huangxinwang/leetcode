class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> rnt = new ArrayList<String>();
        for(int i=1; i<=n; i++){
            if(i%3==0 && i%5==0)
                rnt.add("fizz buzz");
            else if(i%3==0)
                rnt.add("fizz");
            else if(i%5==0)
                rnt.add("buzz");
            else rnt.add(i+"");
        }
        
        return rnt;
    }
}
