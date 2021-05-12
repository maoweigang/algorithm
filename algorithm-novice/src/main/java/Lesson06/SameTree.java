package Lesson06;

public class SameTree {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if(p==null&&q==null){
            return  true;
        }
        return p.value==q.value&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
