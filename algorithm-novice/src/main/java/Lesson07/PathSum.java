package Lesson07;

public class PathSum {

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        PathSum pathSum=new PathSum();
        pathSum.hasPathSum(node,5);
    }
    private static boolean hasSum=false;

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


    public  boolean hasPathSum(TreeNode root, int targetSum) {

        process(root,0,targetSum);
        return hasSum;
    }

    public  void process(TreeNode node, int preSum,int targetSum){
        if(node==null){
            return  ;
        }
        preSum+=node.val;
        if(node.right==null&&node.left==null) {
            if (preSum == targetSum) {
                hasSum = true;
            }
            return;
        }
        process(node.left,preSum,targetSum);
        process(node.right,preSum,targetSum);

    }
}
