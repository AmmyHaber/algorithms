package com.ammyhaber.data.structure.tree;

/**
 * Java implement of red black tree
 * @author ammyhaber
 * @date 2020-08-09
 */
public class RedBlackTree<T> {

    private Node<T> getParent(Node<T> n) {
        return n == null ? null : n.parent;
    }

    private Node<T> getGrandParent(Node<T> n) {
        return getParent(getParent(n));
    }

    private Node<T> getSibling(Node<T> n) {
        Node<T> parent = getParent(n);
        if (parent == null) {
            return null;
        }
        if (parent.right == n) {
            return parent.left;
        }
        return parent.right;
    }

    private Node<T> getUncle(Node<T> n) {
        return getSibling(getParent(n));
    }

    private void rotateLeft(Node<T> n) {

    }

    private static class Node<T> {
        Node<T> parent;
        Node<T> left;
        Node<T> right;
        Color color;
        T obj;
        int value = obj.hashCode();
    }

    private enum Color {
        RED, BLACK;
    }
}
