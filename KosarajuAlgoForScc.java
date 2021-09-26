// problem link -> https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

// Basicall Kosaraju algo is used to find strongly connected component in a directed graph

// there are three steps to involve in this algo
// step 1-> find topo sort of the graph
// step 2-> make a transpose graph(ulta)
// step 3-> make recusursion calls starting from stack top on our new transposed graph

class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        // step 1 find topo sort
        boolean vis [] = new boolean[V];
        Stack<Integer>st = new Stack<Integer>();
        
        for(int i =0; i<V; i++)
        {
            if(vis[i] == false)
                dfs(i,adj,st,vis);
        }
        
        // Step->2 make a transpose graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        
        for(int i =0; i<V; i++)
            transpose.add(new ArrayList<Integer>());
            
        for(int i =0; i<V; i++)
        {
            for(int it : adj.get(i))
            {
                transpose.get(it).add(i);
            }
        }
        // make every thing inside vis array as false
        Arrays.fill(vis,false);
        
        int scc = 0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            
            if(vis[node] == false)
            {   scc++;
                revDfs(node,transpose,vis);
            }
        }
        
        return scc;
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,  Stack<Integer>st , boolean vis[])
    {
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(vis[it] == false)
                dfs(it,adj,st,vis);
        }
        st.push(node);
    }
    
    public void revDfs( int node,ArrayList<ArrayList<Integer>> transpose, boolean vis[])
    { 
        vis[node] = true;
        
        for(int it: transpose.get(node))
        {
            if(vis[it] == false)
                revDfs(it,transpose,vis);
        }
        
    }
}
