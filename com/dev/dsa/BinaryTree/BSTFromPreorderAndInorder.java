package com.dev.dsa.BinaryTree;

public class BSTFromPreorderAndInorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps < preorder.length && pe <= preorder.length && is < inorder.length && ie <= inorder.length) {
            TreeNode root = new TreeNode(preorder[ps]);
            int mid = 0;
            for (int i = is; i < ie; i++) {
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
        int[] pre = {1, 2, 3, 4};
        int[] in = {2, 1, 3, 4};
        BSTUtils.printBSTInAscendingOrder((buildTree(pre, in)));
    }
}
