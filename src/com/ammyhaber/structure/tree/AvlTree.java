package com.ammyhaber.structure.tree;

/**
 * avl tree implementation
 *
 * @author ammyhaber
 */
public class AvlTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        Node<T> n = new Node<>(value);
        recursiveInsert(root, n);
        repairAfterInsert(n);
    }

    private void repairAfterInsert(Node<T> n) {

    }

    private void recursiveInsert(Node<T> p, Node<T> n) {
        if (root == null) {
            root = n;
            return;
        }
        if (n.compareTo(p) > 0) {
            if (p.right != null) {
                recursiveInsert(p.right, n);
                return;
            }
            p.right = n;
        } else {
            if (p.left != null) {
                recursiveInsert(p.left, n);
            }
            p.left = n;
        }
        n.parent = p;
    }

    private int height(Node<T> n) {
        return n == null ? -1 : n.height;
    }

    private void rotateRight(Node<T> n) {
        Node<T> left = n.left;
        n.left = left.right;
        left.parent = n.parent;
        n.parent = left;
        left.right = n;

        // swap height between n and n's left
        int leftHeight = left.height;
        left.height = n.height;
        n.height = leftHeight;

        updateRoot(left);
    }

    private void rotateLeft(Node<T> n) {
        Node<T> right = n.right;
        n.right = right.left;
        right.parent = n.parent;
        n.parent = right;
        right.left = n;

        // swap height between n and n's right
        int rightHeight = right.height;
        right.height = n.height;
        n.height = rightHeight;

        updateRoot(right);
    }

    private void updateRoot(Node<T> n) {
        Node<T> temp = n;
        while (getParent(temp) != null) {
            temp = getParent(temp);
        }
        root = temp;
    }

    private Node<T> getParent(Node<T> n) {
        return n.parent;
    }

    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T value;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        int height;

        public Node() {
            this.height = 1;
        }

        public Node(T value) {
            this.value = value;
            this.height = 1;
        }

        public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.height = 1;
        }

        @Override
        public int compareTo(Node<T> o) {
            return value.compareTo(o.value);
        }
    }

    public static void main(String[] args) {
        int a = 73 % 99;
        System.out.println(a);
    }
}
