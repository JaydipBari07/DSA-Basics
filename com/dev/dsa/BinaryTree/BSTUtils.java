package com.dev.dsa.BinaryTree;

public class BSTUtils {

    public static TreeNode createBst(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insertElement(root, arr[i]);
        }
        return root;
    }

    public static void insertElement(TreeNode root, int val) {
        if (root.val > val) {
             if (root.left != null) {
                insertElement(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else if (root.val < val) {
            if (root.right != null) {
                insertElement(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }

    public static void printBSTInAscendingOrder(TreeNode root) {
        if (root != null) {
            printBSTInAscendingOrder(root.left);
            System.out.print(root.val + " ");
            printBSTInAscendingOrder(root.right);
        }
    }
}
