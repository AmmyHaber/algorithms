package com.ammyhaber.leetcode;

public class Leetcode148 {

    public static void main(String[] args) {
        ListNode head = sortList(ListNodeUtils.create(-1, 5, 0, 1, 1, 7, 6, 6, 6, 6, 6, 3, 4, 0));
        ListNodeUtils.print(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode midHeda = getMidHead(head);
        ListNode newHead = midHeda.next;
        midHeda.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(newHead);
        return merge(head1, head2);
    }

    private static ListNode getMidHead(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
        }
        return n1;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode n1 = head1.val > head2.val ? head1 : head2;
        ListNode n2 = head1.val > head2.val ? head2 : head1;
        ListNode head = n2;
        ListNode n = head;
        n2 = n2.next;
        while (true) {
            if (n1 == null) {
                n.next = n2;
                break;
            }
            if (n2 == null) {
                n.next = n1;
                break;
            }
            if (n1.val < n2.val) {
                n.next = n1;
                n1 = n1.next;
            } else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }

        return head;
    }

}
