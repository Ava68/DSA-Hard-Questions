/ Problem Link ->> https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?category[]=Graph&category[]=Graph&page=1&sortBy=submissions&query=category[]Graphpage1sortBysubmissionscategory[]Graph

// Algorithm --> its solved by dfs graph Traversal. the Idea is to traverse in every direction
// and by traversing also take care of edge cases (like if you are traversing left make sure there is a element in left)

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        if(grid == null || grid.length == 0)
            return 0;
            
        int numOfIsland = 0;
        
        for(int i =0; i<grid.length; i++)
        {
            for(int j =0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                    numOfIsland += dfs(grid , i,j);
            }
        }
        return numOfIsland;
    }
    
    public int dfs(char grid[][] ,int i, int j)
    {
       if(i < 0 || i>= grid.length || j<0 || j >= grid[i].length || grid[i][j] == '0')
        return 0;
    
    
    grid[i][j] = '0';
    // up
    dfs(grid,i+1,j);
    // down
    dfs(grid, i-1 ,j);
    // left
    dfs(grid, i, j-1);
    // right 
    dfs(grid ,i, j+1);
    // leftup
    dfs(grid ,i-1, j-1);
    // rightup
    dfs(grid ,i-1, j+1);
     //bottomleft
    dfs(grid ,i+1, j-1);
     // bottomright
    dfs(grid ,i+1, j+1);
    
    return 1;
    }
}
