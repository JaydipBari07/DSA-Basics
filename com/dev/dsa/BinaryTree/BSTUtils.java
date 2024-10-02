package com.dev.dsa.BinaryTree;

import sun.reflect.generics.tree.Tree;

import static com.dev.dsa.BinaryTree.SearchInBST.searchBST;

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

    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    public static TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BSTUtils.createBst(arr);
        System.out.println(findMin(root).val);
        deleteNode(root, 2);                // Delete node with both children.
        printBSTInAscendingOrder(root);
    }
}
