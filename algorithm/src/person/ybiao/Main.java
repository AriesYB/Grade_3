package person.ybiao;

import person.ybiao.base.BinarySearchTree;

/**
 * @ClassName Main
 * @Package person.ybiao
 * @Description 主函数
 * @Date 2020/5/22 19:11
 * @Author HetFrame
 */

public class Main {
//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }

//    public static TreeNode t(int s,int t){
//
//    }
//
//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//
//    }

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
//        buildTree(preorder,inorder);
        final BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);


    }
}
