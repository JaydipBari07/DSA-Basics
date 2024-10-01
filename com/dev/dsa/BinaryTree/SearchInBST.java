package com.dev.dsa.BinaryTree;

public class SearchInBST {

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.val){
            return root;
        } else if(val < root.val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BSTUtils.createBst(arr);
        BSTUtils.printBSTInAscendingOrder(root);
        System.out.println();
        BSTUtils.printBSTInAscendingOrder(searchBST(root, 5));
        System.out.println();
        BSTUtils.printBSTInAscendingOrder(searchBST(root, 2));
    }
}
