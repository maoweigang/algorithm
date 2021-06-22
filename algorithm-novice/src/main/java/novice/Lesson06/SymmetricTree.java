package novice.Lesson06;

public class SymmetricTree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return minior(root,root);

    }

    boolean minior(TreeNode left,TreeNode right){
        if(left==null^right==null){
            return false;
        }
        if(left==null&&right==null){
            return true;
        }
        return left.val==right.val&&minior(left.left,right.right)&&minior(left.right,right.left);
    }

}