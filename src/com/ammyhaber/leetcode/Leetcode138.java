package com.ammyhaber.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode138 {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node0 = new Node(13);
        Node node1 = new Node(11);
        Node node2 = new Node(10);
        Node node3 = new Node(1);

        head.next = node0;
        node0.next = node1;
        node0.random = head;
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node2.random = node1;
        node3.random = head;

        System.out.println(head);
        print(head);
        System.out.println("====================");
        System.out.println("                    ");
        System.out.println("====================");
        Node newHead = copyRandomList(head);
        System.out.println(newHead);
        print(newHead);
    }

    final static Map<Node, Node> cachedNode = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    private static void print(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        Node n = head;
        do {
            System.out.println(n.val + "," + (n.random == null ? "null" : n.random.val));
        } while ((n = n.next) != null);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
