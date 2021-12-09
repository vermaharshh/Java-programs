package com.java.binarysearchtrees;

import java.util.Scanner;

public class binarysearchtrees {
    public static void main(String[] args) {
        //System.out.println("This is a binary search program");
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.root= new Node(100);
        bt.root.left= new Node(90);
        bt.root.right= new Node(110);
        bt.root.left.left= new Node(80);
        bt.root.left.right= new Node(95);

        if (bt.isBST(bt.root)) {
            System.out.println("The given tree is a Binary Search tree");
            bt.preorder(bt.root);
            bt.insert(bt.root, 115);
            System.out.println("");
            bt.preorder(bt.root);
            System.out.print("\nEnter the number you want to search: ");
            int SearchingNumber;
            SearchingNumber = scanner.nextInt();
            int index = bt.searchBt(bt.root, SearchingNumber);
            if (index == -1)
                System.out.println("The element doesnt exist!");
            else
                System.out.println("The element lies in index " + index);
        }
        else
            System.out.println("The tree is not a Binary Search tree");
    }
}

class Node {
    public int data;
    public Node right;
    public Node left;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    boolean isBST(Node node)
    {
        if (node == null)
            return true;

        /* False if left is > than node */
        if (node.left != null && node.left.data > node.data)
            return false;

        /* False if right is < than node */
        if (node.right != null && node.right.data < node.data)
            return false;

        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    int searchBt(Node node, int data) {
        Node pointer = new Node(0);
        int index = 0;

        pointer = node;

        while (pointer.left != null || pointer.right != null) {

            if (data == pointer.data) {
                return index;
            }
            else if (data > pointer.data) {
                pointer = pointer.right;
            }
            else {
                pointer = pointer.left;
            }

            index += 1;
        }

        if (pointer.data == data)
            return index;
        else
            return -1;

    }

    Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Deletion of node from the BST

    Node delete(Node node, int data) {
        if (node == null) {
            return node;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        }
        else if (data > node.data) {
            node.right = delete(node.right, data);
        }

        else {
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }

            node.data = minValue(node);
        }
    }

    int minValue(Node node) {
        Node pointer = new Node(0);
        pointer = node;

        while(pointer.left != null) {
            pointer = pointer.left;
        }
        return pointer.data;
    }
}
