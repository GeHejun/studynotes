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
//        isExit(root, 22);
        System.out.println(haveEqualRoute(root, 22));
    }


    public static boolean haveEqualRoute(TreeNode<Integer> root, Integer target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val.equals(target)) {
            return true;
        }
        return haveEqualRoute(root.left, target - root.val) || haveEqualRoute(root.right, target - root.val);
    }







}
