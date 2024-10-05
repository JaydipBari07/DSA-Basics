package com.dev.dsa.Backtracking;

import com.dev.dsa.BinaryTree.BSTUtils;
import com.dev.dsa.BinaryTree.TreeNode;

import static com.dev.dsa.BinaryTree.BSTUtils.printBSTInAscendingOrder;

public class PathSum {


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    public static boolean pathSum(TreeNode root, int targetSum, int curSum) {
        if (root == null) {
            return false;
        }
//        if ((root.left != null || root.right != null) && curSum != targetSum) {
//            return false;
//        }
        curSum += root.val;
        if(root.left == null && root.right == null && curSum == targetSum){
            return true;
        }
        if(pathSum(root.left, targetSum, curSum)){
            return true;
        } else if(pathSum(root.right, targetSum, curSum)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3};
        TreeNode root = BSTUtils.createBst(arr);
//        System.out.println(findMin(root).val);
//        deleteNode(root, 2);                // Delete node with both children.
        printBSTInAscendingOrder(root);
        System.out.println(hasPathSum(root, -5));
    }
}
