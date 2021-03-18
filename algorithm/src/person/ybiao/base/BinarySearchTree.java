package person.ybiao.base;

/**
 * @ClassName BinarySearchTree
 * @Package person.ybiao.base.base
 * @Description 二叉搜索树
 * @Date 2020/5/22 19:18
 * @Author HetFrame
 */

public class BinarySearchTree<T extends Comparable<? super T>> {
    TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("二叉搜索树为空");
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("二叉搜索树为空");
        }
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        System.out.println(UtilConstants.BinarySearchTree.TEMPLATE);
    }

    private boolean contains(T t, TreeNode<T> node) {
        //当前节点为null，说明未找到该节点
        if (node == null) {
            return false;
        }
        //与当前节点比较
        int compareResult = t.compareTo(node.element);
        //比当前节点小则与左节点比较，比当前节点大与右节点比较，相等则返回true
        if (compareResult < 0) {
            return contains(t, node.left);
        } else if (compareResult > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        if (node.left != null) {
            findMin(node.left);
        }
        return node;
    }

    private TreeNode<T> findMax(TreeNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode<T> insert(T t, TreeNode<T> node) {
        if (node == null) {
            return new TreeNode<>(t);
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {
            node.right = insert(t, node.right);
        } else {
            //相等。
        }
        return node;
    }

    private TreeNode<T> remove(T t, TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            //该节点拥有左右节点。
            return null;//FIXME
        } else {
            return node;
        }
        return null;//FIXME
    }


}

/**
 * 树节点类
 */
class TreeNode<T> {
    T element;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T element) {
        this(element, null, null);
    }

    public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

}
