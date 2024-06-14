// Time complexity for BFS:  O(n)
// Space complexity for BFS: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic:Use a queue to perform level-order traversal (breadth-first search).
//At each level, add the last node's value to the result list (since it's the rightmost node visible).
//Continue until all levels are processed, returning the list of visible nodes.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size ;i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    result.add(curr.val);
                }
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

        return result;
    }
}

// Time complexity for DFS:  O(n)
// Space complexity for DFS: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Logic:Traverse the tree starting from the root, prioritizing the right subtree before the left subtree.
//At each level, add the first node encountered (the rightmost node) to the result list.
//Continue the traversal until all nodes are processed, returning the list of visible nodes.

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