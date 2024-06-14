// Time complexity for BFS:  O(n)
// Space complexity for BFS: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic:Initialization: Start with a queue for level-order traversal.
//Level Traversal: Traverse the tree level by level, checking at each level if both nodes are found and ensuring they do not share the same parent.
//Parent Check: During traversal, if both nodes are children of the same parent, return false.
//Result: After each level, if both nodes are found and have different parents, return true; otherwise, continue traversal.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        boolean x_found = false, y_found = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                // check if have same parent
                if(curr.left!= null && curr.right!= null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false;
                    }
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(x_found == true && y_found == true){
                return true;
            }
            if(x_found== true || y_found == true){
                return false;
            }
        }
        return true;
    }
}

// Time complexity for DFS:  O(n)
// Space complexity for DFS: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic: Traverse the tree, tracking each node's level and parent.
//When you find the target nodes, record their levels and parents.
//Check if the target nodes are at the same level but have different parents.

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int lvl){
        if(root == null){
            return;
        }
        if(lvl == result.size()){
            result.add(root.val);
        }
        dfs(root.right, lvl+1);
        dfs(root.left, lvl+1);
    }
}