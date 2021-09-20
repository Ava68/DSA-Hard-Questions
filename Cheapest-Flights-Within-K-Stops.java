// Problem Link ->https://leetcode.com/problems/cheapest-flights-within-k-stops/ 

/*
Algorithm: -->. Dijstras Algo with some variation
Initially push the src into the heap
for every step:

check if the current top element in heap is dst. If so return its costFromSrc;
Push every adjacent edge into the heap if the distance is less than k;
If it is larger than k, no more neighbors get pushed into the heap;
If until the end, we cannot find dst, return -1;

*/

class Pair{
    int v;
    int cost;
    
    Pair(int v,int cost)
    {
        this.v = v;
        this.cost = cost;
    }
}

class Solution {
    //
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i =0; i<n; i++)
            adj.add(new ArrayList<Pair>());
        // Build adj list
        for(int [] flight : flights)
            adj.get(flight[0]).add(new Pair(flight[1] , flight[2]));
        
        // shortest distance array
        int dist [] = new int[n];
        
        //shortest steps array
        int currentStops [] = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
         Arrays.fill(currentStops, Integer.MAX_VALUE);
        
        dist[src] = 0;
        currentStops[src] = 0;
        
        // The priority queue would contain (node, cost, stops) --> so this is actually a priority queue array containing (node, cost , stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});
        
        while(!minHeap.isEmpty())
        {
           
            int [] curr = minHeap.poll();
            
            int node = curr[0], stops = curr[2], currcost = curr[1];
            
            // if dist is reached return cost to get there
            if(node == dst)
                return currcost;
            // If there are no more steps left, continue 
            
            if(stops == K + 1) {
                continue;
            }
            
            for(Pair it : adj.get(node))
            {
                if( currcost + it.cost < dist[it.v] )
                {
                    dist[it.v] = currcost + it.cost;
                    minHeap.offer(new int[]{it.v, dist[it.v], stops + 1});     
                }
                
                else if (stops < currentStops[it.v]) {
                        minHeap.offer(new int[]{it.v, currcost + it.cost, stops + 1});          
                    }
                
                currentStops[it.v] = stops;
            }
                
        }
        
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
  }
}

