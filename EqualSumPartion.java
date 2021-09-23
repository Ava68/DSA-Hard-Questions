// Problem Link ->> https://leetcode.com/problems/partition-equal-subset-sum/
// Dynamic Programming Tabular Approach based in 0-1 Knapsack
class Solution {
    // Tablular approach
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i =0; i<nums.length; i++)
            sum+=nums[i];
        if(sum % 2 != 0)
            return false;
        
        int subsetSum = sum /2;
        
        boolean dp[][] = new boolean[nums.length+1][subsetSum+1];
        
        for(int i =0; i<=nums.length; i++ )
            dp[i][0] = true;
        
        for(int i =1; i<=subsetSum; i++ )
            dp[0][i] = false;
        
        for(int i =1; i<=nums.length; i++)
        {
            for(int j = 1; j<=subsetSum; j++)
            {
                if(j >= nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                   dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[nums.length][subsetSum];
    }
}
