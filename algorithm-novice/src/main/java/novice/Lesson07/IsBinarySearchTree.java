package novice.Lesson07;

public class IsBinarySearchTree {

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



    public boolean isBalanced(TreeNode root) {
          return   process1(root).isSearch;
    }

    static class Info{
        boolean isSearch;
        int max;
        int min;

        public Info(boolean isSearch, int max, int min) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
        }
    }

    public Info process1(TreeNode node){
        if(node==null){
            return null;
        }
        Info left= process1(node.left);
        Info right= process1(node.right);
        if(left==null&&right==null){
            return new Info(true,node.val,node.val);
        }
        int max=node.val;
        int min=node.val;
        if(left!=null){
            max=Math.max(left.max,max);
            min=Math.min(left.min,min);
        }
        if(right!=null){
            min=Math.min(right.min,min);
            min=Math.min(right.min,min);

        }
        Boolean lessLeft=left==null?true:node.val>left.max;
        Boolean moreRight=right==null?true:node.val<right.min;
        Boolean leftSearch=left==null?true:left.isSearch;
        Boolean rightSearch=right==null?true:right.isSearch;

        return new Info(leftSearch&&rightSearch&&lessLeft&&moreRight,max,min);
    }
}
