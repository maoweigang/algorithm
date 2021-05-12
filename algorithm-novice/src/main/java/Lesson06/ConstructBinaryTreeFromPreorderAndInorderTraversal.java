package Lesson06;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }

    }

    public static void main(String[] args) {
     int[] a=new int[]{3,9,20,15,7};
     int[] b=new int[]{9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal c=new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        c.buildTree(a,b);
    }
//    前序遍历 preorder = [3,9,1,20,15,7]
//    中序遍历 inorder = [9,1,3,15,20,7]

    //20,15,7
    //15,20,7
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
       return  buildTree(preorder,0, preorder.length-1,inorder,0,inorder.length-1,map);
    }

//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]
//     2,3,4
    //20,15,7
    //15,20,7
    //15
    public TreeNode buildTree(int[] preorder,int l1,int r1, int[] inorder,int l2,int r2,Map<Integer,Integer> map) {
            if(l1>r1){
                return  null;
            }

            TreeNode treeNode=new TreeNode(preorder[l1]);
           if(l1==r1){
               return treeNode;
           }
            int middle=map.get(preorder[l1]);

       //3,3
           treeNode.left=buildTree(preorder,l1+1,l1+middle-l2,inorder,l2,middle-1,map);
           treeNode.right=buildTree(preorder,l1+middle-l2+1,r1,inorder,middle+1,r2,map);

        return treeNode;
    }
}
