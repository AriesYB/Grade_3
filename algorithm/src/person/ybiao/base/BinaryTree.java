package person.ybiao.base;

/**
 * @ClassName BinaryTree
 * @Package person.ybiao.base.base
 * @Description 二叉树
 * @Date 2020/5/22 17:48
 * @Author HetFrame
 */

class Node<T> {
    private T element;
    private Node<T> left;
    private Node<T> right;

    public Node(T element) {
        this.element = element;
        left = null;
        right = null;
    }

    public Node(T element, Node<T> left, Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public person.ybiao.base.Node<T> getLeft() {
        return left;
    }

    public void setLeft(person.ybiao.base.Node<T> left) {
        this.left = left;
    }

    public person.ybiao.base.Node<T> getRight() {
        return right;
    }

    public void setRight(person.ybiao.base.Node<T> right) {
        this.right = right;
    }
}

public class BinaryTree<T> {
    person.ybiao.base.Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void setRoot(T element) {
        if (root == null) {
            root = new person.ybiao.base.Node<>(element);
        } else {
            root.setElement(element);
        }
    }
}
