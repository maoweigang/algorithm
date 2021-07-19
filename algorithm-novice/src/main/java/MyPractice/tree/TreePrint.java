package MyPractice.tree;

public class TreePrint {
    public static void main(String[] args) {

    }


    public static void middleOrderTraversal(TreeNode node){
           if(node==null){
               return;
           }
           System.out.println(node.value);
           middleOrderTraversal(node.left);
           middleOrderTraversal(node.right);

    }

}
