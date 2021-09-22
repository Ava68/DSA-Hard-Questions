// problem Link ---> https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// Algorithm -> Idea is to use concept of horizontal distance add every pair(hd,node) to TreeMap
// each time add into the treemap treemap will automaticaly sort this according to  horizontal distance
// and also keep only  last added value into map.

class Pair{
    int hd;
    Node node;
    
    Pair(int hd, Node node)
    {
        this.hd = hd;
        this.node = node;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair>q = new LinkedList<Pair>();
        
        ArrayList<Integer>res = new ArrayList<Integer>();
        
        if(root == null)
            return res;
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int hd = curr.hd;
            Node node = curr.node;
            
            map.put(hd ,node.data);
            
            if(node.left != null)
                q.add(new Pair(hd -1 , node.left));
                
            if(node.right != null)
                q.add(new Pair(hd +1 , node.right));
            
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet() )
        {
            res.add(entry.getValue());
        }
        
        return res;
        
    }
}
