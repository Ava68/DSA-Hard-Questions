// Problem Link -> shorturl.at/mwQT0
// Time complexity -> O(N+E) logn
// Prims algorithm
// So Idea is to use Priority queue and every time priority queue will return node with less no of weight in logn time 
//  assign key array to INF and mst array to false compare  with the weight of adjcent node to key array and also check it shall not be present already inside our 
// mst array update and each time update key array and mst array.
// at last minimum cost will be the summation of every node inside the key array.



class Pair implements Comparator<Pair>{
    int v;
    int weight;
    
    Pair(int v, int weight)
    {
        this.v = v;
        this.weight = weight;
    }
    Pair() {} 
    @Override  
    public int compare(Pair a, Pair b) {  
        return a.weight - b.weight;
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    // prims algo to solve minimum spanning tree
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        boolean mst[] = new boolean [V];
        int key[] = new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
       
         PriorityQueue<Pair>pq = new PriorityQueue<Pair>(V, new Pair());
        
        pq.add(new Pair(0 , 0));
        key[0] = 0;
        int minCost = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            mst[curr.v] = true;
            for(ArrayList<Integer> node : adj.get(curr.v))
            {
                if(mst[node.get(0)] == false && node.get(1) < key[node.get(0)])
                {
                     key[node.get(0)] = node.get(1);
                     pq.add(new Pair(node.get(0) , key[node.get(0)] ));
                }
                   
            }
        }
        for(int i =0; i<V; i++)
            minCost+= key[i];
     return cost;
    }
}
