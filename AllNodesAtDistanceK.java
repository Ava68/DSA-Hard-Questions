/* Problem Link -> https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/

Algorithm - > store parents of every node  in a hashmap,then use bfs to find the nodes at k distance 
add left,right,and parent of node to queue at evey step and also check node is already marked or not
then if at any point currlevel becomes equal to k then break from the while loop and add every elements in a queue to arraylist and return thr arrayList

*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track = new HashMap<TreeNode,TreeNode>();
    
        markParents(root,parent_track);
        
        Map<TreeNode, Boolean> visited = new HashMap<>(); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(target);
        visited.put(target,true);
        int currlvl = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(currlvl == k)
                break;
            
            currlvl++;
            for(int i =0; i<size; i++)
            {
                TreeNode current = queue.poll();
                
            if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                
            if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
            // if parent is not null and also it should not be visited   
            if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        
         List<Integer>res = new ArrayList<Integer>();
        while(!queue.isEmpty())
        {
            res.add(queue.poll().val);
        }
        
        return res;
        
    }
    public void markParents(TreeNode root,  Map<TreeNode,TreeNode> parent_track)
    {
       Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode current = q.poll();
            
            if(current.left != null)
            {
                q.add(current.left);
                parent_track.put(current.left,current );
            }
            if(current.right != null)
            {
                q.add(current.right);
                parent_track.put(current.right,current );
            }
        }
          
    }
   
}
