// problem Link -> https://leetcode.com/problems/is-graph-bipartite/

//Algorithm ->> Try to color every node with 2 color if 2 adjcent node color is same then return false
//and if the full graph colored with 2 color and no two adjacent node's color are not same then return true at end
    

class Solution {
    public boolean isBipartite(int[][] graph) { 
        int color [] = new int [graph.length];
        for(int i=0; i<graph.length; i++)
            color[i] = -1;
        
        for(int i =0; i<graph.length; i++)
        {
            if(color[i] == -1)
            {
                if(!dfsVisit(graph,i,color))
                  return false;
            }
                
        }     
        return true;
}
    public boolean dfsVisit(int graph[][] , int node, int color[])
    {
        if(color[node] == -1)
            color[node] = 1;
        
        for(int it: graph[node] )
        {
            if(color[it] == -1)
            {
                color[it] = 1 - color[node];
                if(dfsVisit(graph,it,color) == false)
                    return false;
                
            }
            else if(color[it] == color[node])
                return false;
        }
        return true;
    }
    
}
