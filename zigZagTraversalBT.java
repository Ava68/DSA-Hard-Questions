class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> mainList = new LinkedList<List<Integer>>();
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        
        if(root == null)
           return mainList;
        q.offer(root);
        boolean direction = true;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer>subList = new ArrayList<Integer>();
            
            for(int i =0; i<size; i++)
            {
                TreeNode pop = q.poll();
                
                
                    if(pop.left != null)
                        q.add(pop.left);
                
                    if(pop.right != null)
                        q.add(pop.right);
                
                if(direction == true)
                    subList.add(pop.val);
                else
                    subList.add(0 ,pop.val);
                
                    
            }
            
            direction = !direction;
            mainList.add(subList);
        }   
        
        return mainList;
        
    }
}
