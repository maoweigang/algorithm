package novice.Lesson07;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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

    private List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root,0,targetSum,new ArrayList<>());
        return lists;
    }


    public  void process(TreeNode node, int preSum, int targetSum,List<Integer> path){
        if(node==null){
            return  ;
        }
        path.add(node.val);
        preSum+=node.val;
        if(node.right==null&&node.left==null) {
            if (preSum == targetSum) {
                lists.add(copyArray(path));
            }
            path.remove(path.size()-1);
            return;
        }
        if(node.left!=null) {
            process(node.left, preSum, targetSum, path);
        }
        if(node.right!=null) {
            process(node.right, preSum, targetSum, path);
        }
        path.remove(path.size()-1);

    }


    private List<Integer> copyArray(List<Integer> list){
        List<Integer> copyList=new ArrayList<>(list.size());
        for(int i:list){
            copyList.add(i);
        }
      return copyList;
    }
}
