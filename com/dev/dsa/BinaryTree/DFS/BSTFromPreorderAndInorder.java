package com.dev.dsa.BinaryTree.DFS;

import com.dev.dsa.BinaryTree.BSTUtils;
import com.dev.dsa.BinaryTree.TreeNode;

public class BSTFromPreorderAndInorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps==pe && is==ie){
            return new TreeNode(preorder[ps]);
        }
        if (ps < preorder.length && pe >= ps && is < inorder.length && ie >= is) {
            TreeNode root = new TreeNode(preorder[ps]);
            int mid = 0;
            for (int i = is; i <= ie; i++) {
                if (preorder[ps] == inorder[i]) {
                    mid = i;
                }
            }
            root.left = build(preorder, inorder, ps + 1, ps + (mid - is), is, mid - 1);
            root.right = build(preorder, inorder, ps + (mid - is) + 1, pe, mid + 1, ie);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] pre = {1,2};
        int[] in = {2,1};
        BSTUtils.printBSTInAscendingOrder((buildTree(pre, in)));
    }
}
