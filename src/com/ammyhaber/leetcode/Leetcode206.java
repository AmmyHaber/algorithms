package com.ammyhaber.leetcode;

/**
 * 反转链表
 */
public class Leetcode206 {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createSimple();
        ListNode rltHead = reverseListByRecursion(head);
        ListNodeUtils.print(rltHead);
        ListNodeUtils.print(reverseListByIterator(rltHead));
    }

    public static ListNode reverseListByRecursion(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 先将除头节点之外的部分反转了
        ListNode newHead = reverseListByRecursion(head.next);
        // 再将头节点放到最后去,注意此时头节点还是指向的反转部分的最后一个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListByIterator(ListNode head) {
        ListNode h = head;
        ListNode l = null;
        ListNode tmp;
        while (h != null) {
            tmp = h;
            h = h.next;
            tmp.next = l;
            l = tmp;
        }
        return l;
    }
}
