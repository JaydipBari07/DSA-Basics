package com.dev.dsa.BinaryTree.BFS;

import com.dev.dsa.BinaryTree.BSTUtils;
import com.dev.dsa.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if(root == null){
            return res;
        }
        queue.add(root);
        int cur = 0;
        int size = queue.size();
        res.add(queue.get(0).val);
        while(cur < size){
            int i = cur;
            for(; i < size; i++){
                if(queue.get(i).left != null) {
                    queue.add(queue.get(i).left);
                }
                if(queue.get(i).right != null) {
                    queue.add(queue.get(i).right);
                }
            }
            cur = i;
            if(size == queue.size()){
                break;
            }
            size = queue.size();
            res.add(queue.get(size-1).val);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 7, 6, 9};
        TreeNode root = BSTUtils.createBst(arr);
        System.out.println(rightSideView(root));
    }
}
