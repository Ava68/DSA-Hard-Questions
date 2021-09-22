// Algorithm ---> Easy problem just track the horizontal distance from root node 
// only add to the map for the first time seeing a horizontal distance else do not update it.
class Pair{
    int hd;
    Node node;
    
    Pair(int hd,Node node)
    {
        this.hd = hd;
        this.node = node;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        Queue<Pair>q = new LinkedList<Pair>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
    
        q.add(new Pair(0,root));
        
        
        while(!q.isEmpty())
            {
                Pair curr = q.poll();
            
                 int hd = curr.hd;
                Node node = curr.node;
                
                if(!map.containsKey(hd))
                {
                    map.put(hd , node.data );
                }
             
                if(node.left != null)
                    q.add(new Pair(hd -1 , node.left));
                    
                 if(node.right != null)
                    q.add(new Pair(hd + 1 , node.right));
            
        }
        
        
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            res.add(entry.getValue()); 
        }
        
        return res;
        
    }
}
