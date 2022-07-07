Link -> https://leetcode.com/problems/maximum-width-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node; int index;
    
    Pair(TreeNode node,int index)
    {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q = new LinkedList<Pair>();
        
        q.add(new Pair(root,0));
        int max = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int start = 0;
            int end = 0;
            
            for(int i=0; i<size; i++)
            {
                Pair currpair = q.poll();
                int currindx = currpair.index;
                
                if(i ==0)
                    start = currindx;
                if(i == size-1)
                    end = currindx;
                
                if(currpair.node.left != null)
                    q.add(new Pair(currpair.node.left, 2 * currindx +1));
                
                if(currpair.node.right != null)
                    q.add(new Pair(currpair.node.right , 2 * currindx +2) );
                
            }
            max = Math.max(max , end-start+1);
        }
        return max;
    }
}
