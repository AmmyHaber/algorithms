package com.ammyhaber.leetcode;

/**
 * 链表的中间结点
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Leetcode876 {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.create(1, 2, 3, 4, 5, 6);
        ListNode middleNode = middleNode(head);
        ListNodeUtils.print(middleNode);
    }

    /**
     * 快慢指针法
     */
    private static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
