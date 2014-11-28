/**
 * Problem Statement: Max Points on a Line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
import java.util.HashMap; 
import java.util.Map; 


public class Solution {
    
    //hashmap to store points in the same line
    Map<Double, Integer> map = new HashMap<Double,Integer>();
    int global_max = 0;
    
    public int maxPoints(Point[] points) {
        
        if(points.length==0) return 0;
        
        for(int i=0; i<points.length; i++){
            
            int local_max = 0;
            int same_x = 0;
            int same_vertex = 0;
            map.clear();
            
            for(int j=0; j<points.length; j++){
                
                //avoid same points
                if(i==j) continue;
                //case 1: same x-axis, different y
                if(points[i].x==points[j].x && points[i].y!=points[j].y) same_x++;
                else 
                {   
                     //case 2: same vertex
                    if(points[i].x==points[j].x && points[i].y==points[j].y) same_vertex++;
                    else 
                    {
                        //case 3:caculate (y1-y2)/(x1-x2)
                        double k = (double)(points[i].y-points[j].y)/(points[i].x-points[j].x);
                        int count = 0;
                        if(map.get(k)!=null) count = map.get(k);
                        count++;
                        map.put(k,count);
                    }
                }
            }
            
            //update global_max
            for(double key:map.keySet()){
                if(same_vertex + map.get(key) > global_max)
                    global_max = same_vertex + map.get(key);
            }
            
            if(same_vertex + same_x > global_max)
                global_max = same_vertex + same_x;
            
            
        }
        
        return global_max+1;
    }
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Ronud 2: 11/28/2014
//time comlexity O(n^2)


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        
        //keep track of global max number
        int globalMax = 0;
        
        //for each point, enumerate each other points that are in the same line with it
        for(int i=0; i<points.length; i++){
            //use hashmap to maintain each possible line (define by point2.y-point1.y)/(point2.x-point1.x)
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int same_x = 1;
            //keep track of same vertex, since they will not be keep in the map (since we cannot calculate the slope)
            int same_xy = 0;
            
            for(int j=0; j<points.length; j++){
                //skip same point
                if(j==i) continue;
                
                //if slope is not 0, calculate slope, update map
                if (points[j].x != points[i].x){
                    double k = (double)(points[j].y - points[i].y)/(points[j].x - points[i].x);
                    if(map.containsKey(k))
                        map.put(k, map.get(k)+1);
                    else map.put(k, 2);
                }
                //if slop is zero, keep track of same x, and same vertex
                else{
                    same_x ++;
                    if(points[j].y == points[i].y) same_xy++;
                    
                } 

            }
            
            //note that when calculate the number of vertex in the same line, we need to plus the same vertex number
            //as we mentioned, same vertex is not tracked in the map
            for(double key: map.keySet()){
                if(map.get(key) +same_xy > globalMax)
                    globalMax = map.get(key) + same_xy;
            }
            
            if(same_x > globalMax) globalMax = same_x;

        }
        
        return globalMax;
    }
}
