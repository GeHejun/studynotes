package tree;

/**
 * @author gehj
 * @date 2019/7/17 15:01
 */
public class RBTree<T extends Comparable<T>, D> {

    private RBNode<T, D> root;
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;

    public class RBNode<T extends Comparable<T>, D> {

        private Boolean color;
        private T key;
        private D   data;
        private RBNode<T, D> parent;
        private RBNode<T, D> leftChild;
        private RBNode<T, D> rightChild;

        public RBNode(Boolean color, T key, D data, RBNode parent, RBNode leftChild, RBNode rightChild) {
            this.color = color;
            this.key = key;
            this.data = data;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    /**
     * 获取父亲
     * @param node
     * @return
     */
    public RBNode parentOf(RBNode<T, D> node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    /**
     * 获取颜色
     * @param node
     * @return
     */
    public Boolean colorOf(RBNode<T, D> node) {
        if (node != null) {
            return node.color;
        }
        return BLACK;
    }

    /**
     * 设置父节点
     * @param node
     * @param parent
     */
    public void setParent(RBNode<T, D> node, RBNode<T, D> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    /**
     * 设置颜色
     * @param node
     * @param color
     */
    public void setColor(RBNode<T, D> node, Boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    /**
     * 是否是红色节点
     * @param node
     * @return
     */
    public Boolean isRed(RBNode<T, D> node) {
        return (node != null && node.color.equals(RED)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 是否是黑色节点
     * @param node
     * @return
     */
    public Boolean isBlack(RBNode<T, D> node) {
        return !isRed(node);
    }

    /**
     * 设置节点成红色
     * @param node
     */
    public void setRed(RBNode<T, D> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    /**
     * 设置节点成黑色
     * @param node
     */
    public void setBlack(RBNode<T, D> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    /**
     * 通过key获取值
     * @param key
     * @return
     */
    public D get(T key) {
        RBNode node = search(key, root);
        return node == null ? null : (D)node.data;
    }

    /**
     * 递归查找
     * @param key
     * @param node
     * @return
     */
    public RBNode search(T key, RBNode node) {
        if (node != null) {
            int compare = key.compareTo((T) node.key);
            if (compare < 0) {
                return search(key, node.leftChild);
            } else if (compare > 0) {
                return search(key, node.rightChild);
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 左旋
     * @param node
     */
    public void leftRonate(RBNode<T, D> node) {
        RBNode<T, D> r = node.rightChild;
        if (r.leftChild != null) {
            r.leftChild.parent = node;
        }
        node.rightChild = r.rightChild;
        r.leftChild = node;
        r.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.leftChild == node) {
                node.parent.leftChild = r;
            } else {
                node.parent.rightChild = r;
            }
        } else {
            this.root = r;
        }
        node.parent = r;
    }

    /**
     * 右旋
     * @param node
     */
    public void rightRonate(RBNode<T, D> node) {
        RBNode<T, D> l = node.leftChild;
        if (l.rightChild != null) {
            l.rightChild.parent = node;
        }
        node.leftChild = l.leftChild;
        l.rightChild = node;
        l.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.rightChild == node) {
                node.parent.rightChild = l;
            } else {
                node.parent.leftChild = l;
            }
        } else {
            this.root = l;
        }
        node.parent = l;
    }

    public void balanceInsertion(RBNode<T, D> node) {
        RBNode<T, D> parent, gparent;
        while ((parent = parentOf(node)) != null && isRed(node)) {
            gparent = parentOf(parent);
            if (gparent.leftChild == parent) {
                RBNode<T, D> uncle = gparent.rightChild;
            }
        }
    }

}
