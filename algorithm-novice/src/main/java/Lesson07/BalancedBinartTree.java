package Lesson07;

public class BalancedBinartTree {

    static class TreeNode {
        int val;
         TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Info{
        private int height;
        boolean isBalance;

        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }

    }


    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

    public static Info process(TreeNode node){
        if(node==null){
            return new Info(0,true);
        }
        Info left=process(node.left);
        Info right=process(node.right);
        int height=Math.max(left.height,right.height)+1;
        boolean isBalance=Math.abs(left.height-right.height)<2&&left.isBalance&&right.isBalance;
        return new Info(height,isBalance);
    }
}
