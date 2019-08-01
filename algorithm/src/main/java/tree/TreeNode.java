package tree;

/**
 * @author gehj
 * @version 1.0
 * @description 公共类(为该包下的所有类提供节点)
 * @date 2019/8/1 14:38
 */
public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T t) {
        this.val = t;
    }
}
