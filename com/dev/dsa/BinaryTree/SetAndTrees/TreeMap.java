package com.dev.dsa.BinaryTree.SetAndTrees;

import com.dev.dsa.BinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeMap {

    int key;
    int val;
    TreeMap left;
    TreeMap right;

    public TreeMap() {
    }

    public TreeMap(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public void insert(int key, int val) {
        if (this.key == 0 && this.val == 0) {
            this.key = key;
            this.val = val;
        } else if (key < this.key) {
            if (this.left != null) {
                this.left.insert(key, val);
            } else {
                this.left = new TreeMap(key, val);
            }
        } else {
            if (this.right != null) {
                this.right.insert(key, val);
            } else {
                this.right = new TreeMap(key, val);
            }
        }
    }

    public int get(int key) {
        if (this.key == 0 && this.val == 0) {
            return -1;
        }
        if (key == this.key) {
            return this.val;
        } else if (key < this.key) {
            if (this.left != null)
                return this.left.get(key);
            else
                return -1;
        } else {
            if (this.right != null)
                return this.right.get(key);
            else
                return -1;
        }
    }

    public int getMin() {
        if (this.key == 0 && this.val == 0) {
            return -1;
        }
        if (this.left != null) {
            return this.left.getMin();
        } else {
            return this.val;
        }
    }

    public TreeMap getMinNode() {
        if (this.key == 0 && this.val == 0 && this.left == null && this.right == null) {
            return this;
        }
        if (this.left != null) {
            return this.left.getMinNode();
        } else {
            return this;
        }
    }

    public int getMax() {
        if (this.key == 0 && this.val == 0) {
            return -1;
        }
        if (this.right != null) {
            return this.right.getMax();
        } else {
            return this.val;
        }
    }

    public TreeMap search(int key) {
        if (this.key == 0 && this.val == 0 && this.key != key && this.left == null && this.right == null) {
            return null;
        }
        if (key == this.key) {
            return this;
        } else if (key < this.key) {
            if (this.left != null)
                return this.left.search(key);
            else
                return null;
        } else {
            if (this.right != null)
                return this.right.search(key);
            else
                return null;
        }
    }

    public void remove(int key) {
        TreeMap node = this.removeNode(this, key);
        if(node != null) {
            this.key = node.key;
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
        } else {
            this.key = 0;
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }

    public TreeMap removeNode(TreeMap node, int key){
        if (node == null) {
            return null;
        }
        if (node.left != null && key < node.key) {
            node.left = this.removeNode(node.left, key);
        } else if (node.right != null && key > node.key) {
            node.right = this.removeNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeMap minNode = node.right.getMinNode();
                node.val = minNode.val;
                node.key = minNode.key;
                node.right = this.removeNode(node.right, node.key);
            }
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        this.inorderTraversal(list);
        return list;
    }

    public void inorderTraversal(List<Integer> list) {
        if (this.left != null)
            this.left.inorderTraversal(list);
        list.add(this.key);
        if (this.right != null)
            this.right.inorderTraversal(list);
    }

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.insert(1, 2);
        treeMap.insert(4, 0);
        treeMap.remove(1);
        System.out.println(treeMap.getInorderKeys());
        treeMap.remove(4);
        System.out.println(treeMap.getInorderKeys());
    }
}

