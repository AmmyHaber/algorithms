package com.ammyhaber.leetcode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class Leetcode21 {

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.create(1, 3, 5, 7, 9);
        ListNode l2 = ListNodeUtils.create(2, 4, 6, 8, 10);
        ListNode head = mergeTwoLists(l1, l2);
        ListNodeUtils.print(head);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeByIterator(l1, l2);
    }

    private static ListNode mergeByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeByRecursion(l1, l2.next);
            return l2;
        }
    }

    private static ListNode mergeByIterator(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
