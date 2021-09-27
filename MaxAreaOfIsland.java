/* problem Link -> shorturl.at/bptS2

 Algorithm-> Basic Dfs aprroach move on all 8 directions and also increment the area every time 
and update the maxArea every time when dfs call gets over.
*/
class Solution
{
    //Function to find unit area of the largest region of 1s.
    
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int area [] = new int[1];
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i<grid.length; i++)
        {
            for(int j =0; j<grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                  dfs(grid,i,j,area);
                  maxArea = Math.max(maxArea , area[0]);
                  area[0] = 0;
                }
            }
        }
        return maxArea;
    }
    
    public void dfs(int [][] grid,int i ,int j ,int area[])
    {
        if(i < 0 || i >= grid.length || j>= grid[i].length || j<0 || grid[i][j] == 0)
            return ;
            
        area[0]++; 
      // every time  also making it 0 so that you cannot traverse again 
        grid[i][j] = 0;
       
    // up
    dfs(grid,i+1,j,area);
    // down
    dfs(grid, i-1 ,j,area);
    // left
    dfs(grid, i, j-1,area);
    // right 
    dfs(grid ,i, j+1,area);
    // leftup
    dfs(grid ,i-1, j-1,area);
    // rightup
    dfs(grid ,i-1, j+1,area);
     //bottomleft
    dfs(grid ,i+1, j-1,area);
     // bottomright
    dfs(grid ,i+1, j+1,area);
        
        
        
        
    }
}
