package com.ammyhaber.leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Leetcode19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode n = removeNthFromEnd(head, 5);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        ListNode r = l;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        if (r == null) {
            ListNode rlt = head.next;
            head.next = null;
            return rlt;
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
