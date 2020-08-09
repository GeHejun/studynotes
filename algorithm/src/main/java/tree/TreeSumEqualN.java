package tree;

public class TreeSumEqualN {

    public static boolean isExit(TreeNode<Integer> root, int sum){
     if (root ==  null) {
         return false;
     }
     if (root.left == null && root.right == null && root.val == sum) {
         return true;
     } else {
         return isExit(root.left, sum - root.val) || isExit(root.right, sum - root.val);
     }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        isExit(root, 22);
    }







}
