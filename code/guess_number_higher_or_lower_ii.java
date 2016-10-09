//We are playing the Guess Game. The game is as follows:

//I pick a number from 1 to n. You have to guess which number I picked.

//Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

//However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

public class Solution {
    public int getMoneyAmount(int n) {
        //minl[i][j] indicates the min loss when the uncertain range is [i,j]
        int[][] minl = new int[n][n];
        for(int step=1; step<=n-1; step++){
            for(int i=0; i<n; i++){
                if(i+step>=n) continue;
                //compute the loss when the uncertain range is [i,i+step]
                //case 1: guess i, or guess i+step
                int curr_min = Math.min(minl[i+1][i+step]+i+1, minl[i][i+step-1]+i+step+1);
                //case 2: guess any value j, i<j<i+step
                for(int j=i+1; j<i+step; j++){
                    int curr_worse = Math.max(minl[i][j-1],minl[j+1][i+step])+j+1;
                    if(curr_min > curr_worse )
                        curr_min = curr_worse;
                }
                minl[i][i+step] = curr_min;
            }
        }
        
        return minl[0][n-1];
    }
}
