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