package com.ammyhaber.data.structure.tree;

/**
 * Java implement of red black tree
 *
 * @author ammyhaber
 * @date 2020-08-09
 */
public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T obj) {
        Node<T> n = new Node<>(obj);
        insertRecurse(root, n);
        insertRepairTree(n);
    }

    public void printTree() {

    }

    private void insertRepairTree(Node<T> n) {
        if (getParent(n) == null) {
            insertCase1(n);
        } else if (getParent(n).color == Color.BLACK) {
            insertCase2(n);
        } else if (getUncle(n) != null && getUncle(n).color == Color.RED) {
            insertCase3(n);
        } else {
            insertCase4(n);
        }
    }

    private void insertCase4(Node<T> n) {
        Node<T> parent = getParent(n);
        Node<T> grandParent = getGrandParent(n);

        Node<T> temp = n;
        if (n == parent.right && parent == grandParent.left) {
            rotateLeft(parent);
            temp = parent;
        } else if (n == parent.left && parent == grandParent.right) {
            rotateRight(parent);
            temp = parent;
        }
        insertCase4Step2(temp);
    }

    private void insertCase4Step2(Node<T> n) {
        Node<T> parent = getParent(n);
        Node<T> grandParent = getGrandParent(n);
        if (n == parent.left) {
            rotateRight(grandParent);
        } else {
            rotateLeft(grandParent);
        }
        parent.color = Color.BLACK;
        grandParent.color = Color.RED;
    }

    private void insertCase3(Node<T> n) {
        getParent(n).color = Color.BLACK;
        getUncle(n).color = Color.BLACK;
        getGrandParent(n).color = Color.RED;
        insertRepairTree(getGrandParent(n));
    }

    private void insertCase2(Node<T> n) {
        // do nothing since tree is still valid
    }

    private void insertCase1(Node<T> n) {
        n.color = Color.BLACK;
    }

    private void insertRecurse(Node<T> p, Node<T> n) {
        // 处理根节点的插入问题
        if (root == null) {
            root = n;
            return;
        }
        if (n.compareTo(p) < 0) {
            if (p.left != null) {
                insertRecurse(p.left, n);
                return;
            }
            p.left = n;
        } else {
            if (p.right != null) {
                insertRecurse(p.right, n);
                return;
            }
            p.right = n;
        }
        n.parent = p;
    }

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
        Node<T> r = n.right;
        if (r == null) {
            throw new NullPointerException("node's right node is null, can not rotate left");
        }
        Node<T> parent = n.parent;

        n.parent = r;
        n.right = r.left;
        r.left = n;
        if (n.right != null) {
            n.right.parent = n;
        }
        if (parent != null) {
            if (n == parent.left) {
                parent.left = r;
            } else if (n == parent.right) {
                parent.right = r;
            }
        }
        r.parent = parent;
        updateRoot(n);
    }

    private void rotateRight(Node<T> n) {
        Node<T> l = n.left;
        if (l == null) {
            throw new NullPointerException("node's left node is null, can not rotate right");
        }
        Node<T> parent = n.parent;

        n.parent = l;
        n.left = l.right;
        l.right = n;
        if (n.left != null) {
            n.left.parent = n;
        }
        if (parent != null) {
            if (n == parent.left) {
                parent.left = l;
            } else if (n == parent.right) {
                parent.right = l;
            }
        }
        l.parent = parent;
        updateRoot(n);
    }

    private void updateRoot(Node<T> n) {
        Node<T> temp = n;
        while (getParent(temp) != null) {
            temp = getParent(temp);
        }
        root = temp;
    }

    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        Node<T> parent;
        Node<T> left;
        Node<T> right;
        // all new node is red
        Color color = Color.RED;
        T obj;

        public Node(T obj) {
            if (obj == null) {
                throw new NullPointerException("object must not be null");
            }
            this.obj = obj;
        }

        @Override
        public int compareTo(Node<T> o) {
            return obj.compareTo(o.obj);
        }
    }

    private enum Color {
        RED, BLACK
    }

    public static void main(String[] args) {
        int[] arr = new int[]{43, 65, 87, 34, 11, 43, 266, 758, 53645, 1, 5, 78, 94, 55};
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for (int i : arr) {
            redBlackTree.insert(i);
        }
        redBlackTree.printTree();
    }
}
