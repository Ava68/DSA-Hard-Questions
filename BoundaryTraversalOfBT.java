// Problem Link ---> https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#

/* Algorithm
add left boundary without leaf
then leaf
and then add right boundary  in reverse without leaf

*/


class Solution
{
    Boolean isLeaf(Node node)
    {
        if(node.left == null && node.right ==null)
         return true;
    
    return false;
    }
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer>res = new ArrayList<Integer>();
	    if(node == null)
	        return res;
	   if(isLeaf(node) == false) 
	        res.add(node.data);
	    
	    addLeftBoundary(node,res);
	    addLeaves(node,res);
	   
	    addRightBoundary(node,res);
	   
	        
	   return res;
	    
	}
	 public void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur))
                res.add(cur.data);
            if (cur.left != null) 
                cur = cur.left;
            else 
                cur = cur.right;
        }
    }
  public void addLeaves(Node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) 
         addLeaves(root.left, res);
        if (root.right != null) 
         addLeaves(root.right, res);
    }
	public void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
       Stack<Integer>stack = new Stack<Integer>();
        while (cur != null) {
            if (!isLeaf(cur)) 
                stack.push(cur.data);
            if (cur.right != null) 
                cur = cur.right;
            else 
                cur = cur.left;
        }
        while(!stack.isEmpty())
            res.add(stack.pop());
    }
	
}