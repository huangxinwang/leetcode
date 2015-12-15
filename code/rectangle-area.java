// rectangle area

/////////////////////////////////////////////////////
// 2015/12/15
// Highlight: logic

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // if(A>E){
        //     return computeArea(E,F,G,H,A,B,C,D);
        // }
        //calculate overlay x
        long lowY = Math.max(B,F);
        long highY = Math.min(D,H);
        long y = (highY-lowY<0) ? 0: highY-lowY;
        
        //calculate overlay y
        long lowX = Math.max(A,E);
        long highX = Math.min(C,G);
        long x = (highX - lowX<0) ? 0: highX-lowX;
        
        //cover = area1 + area2 - overlap
        long overlap = x*y;
        long area1 = (C-A)*(D-B);
        long area2 = (G-E)*(H-F);
        return (int)(area1 + area2 - overlap);
        
    }
}
