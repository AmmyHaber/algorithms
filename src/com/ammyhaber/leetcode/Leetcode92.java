package com.ammyhaber.leetcode;

public class Leetcode92 {

    public static void main(String[] args) {
        ListNodeUtils.print(reverseBetween(ListNodeUtils.create(1, 2, 3, 4, 5), 2, 4));
        ListNodeUtils.print(reverseBetween(ListNodeUtils.create(5), 1, 1));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        head = newHead;


        ListNode pre = head;
        ListNode h = head.next;
        int position = 1;
        while (h.next != null && position < right) {
            if (position < left) {
                pre = pre.next;
                h = h.next;
            } else {
                ListNode tmp = pre.next;
                pre.next = h.next;
                h.next = h.next.next;
                pre.next.next = tmp;
            }
            position++;
        }
        return head.next;
    }
}
