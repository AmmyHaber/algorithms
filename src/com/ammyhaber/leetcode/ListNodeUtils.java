package com.ammyhaber.leetcode;

public class ListNodeUtils {

    public static ListNode createSimple() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        ListNode n = head;
        StringBuilder sb = new StringBuilder("[");
        while (n != null) {
            sb.append(n.val).append(", ");
            n = n.next;
        }

        System.out.println(sb.substring(0, sb.length() - 2) + "]");
    }
}
