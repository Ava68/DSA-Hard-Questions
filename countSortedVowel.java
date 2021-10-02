class Solution {
  // problem Link-> https://leetcode.com/problems/count-sorted-vowel-strings/submissions/
    /* Dynamic Programming solution
    
    The idea here is at each and every position we have 2 choices, we can either take the character or we can omit the character.

Lets assume length of the string as 'n' and max number of characters as 'm'.

The function is defined as "recur(n, m)", where n is length of the string and m will range from 0 to m.

If we take the character, then length will reduce by 1 and since we can take the same character again, we will retain "m" as is.
If we do not take the character, then length will remain as is and we will increase "m" since we do not want to take this character.

So the recurrence relation becomes --> recur(n,m) = recur(n-1, m) + recur(n, m+1)
    
    */
    
     public int countVowelStrings(int n) {
         int dp[][] = new int[n+1][6];
         
         for(int i =0; i<=n; i++)
         {
             for(int j=0; j<6; j++)
             {
                 dp[i][j] = -1;
             }
         }
        return recur(n, 0,dp);
  }

    public int recur(int n, int m,int dp[][]) {
         if(n == 0)
            return 1;
         if(m == 5)
            return 0;
        if(dp[n][m] != -1)
            return dp[n][m];
        
         return recur(n-1, m,dp) + recur(n, m+1,dp);
    }
     
}
