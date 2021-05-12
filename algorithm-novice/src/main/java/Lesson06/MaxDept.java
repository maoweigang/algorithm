package Lesson06;

public class MaxDept {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        return Math.max(maxDepth((root.left)),maxDepth((root.right)))+1;
    }
}
