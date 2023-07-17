package com.ammyhaber.leetcode;

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        int i = 0;
        ListNode preTail = null;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr;
            if (preTail != null) {
                preTail.next = temp;
            }
            preTail = curr;
            curr = curr.next;
            if (i == 0) {
                head = temp;
            }
            i++;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
