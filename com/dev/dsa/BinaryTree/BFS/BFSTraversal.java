package com.dev.dsa.BinaryTree.BFS;

import com.dev.dsa.BinaryTree.BSTUtils;
import com.dev.dsa.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BFSTraversal {

    static class ListNode {
        TreeNode nodeVal;
        ListNode next;

        public ListNode() {
        }

        public ListNode(TreeNode val) {
            this.nodeVal = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int cur = 0;
        while (cur < queue.size()) {
            int i = cur;
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (; i < size; i++) {
                l.add(queue.get(i).val);
                if (queue.get(i).left != null) {
                    queue.add(queue.get(i).left);
                }
                if (queue.get(i).right != null) {
                    queue.add(queue.get(i).right);
                }
            }
            res.add(l);
            cur = i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 7, 6, 9};
        TreeNode root = BSTUtils.createBst(arr);
        System.out.println(levelOrder(root));
    }
}
