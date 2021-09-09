package com.ammyhaber.leetcode;

class Leetcode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNodeUtils.print(listNode);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int tmp = 0;
        int sum;
        ListNode sumNode;
        ListNode r = null;
        ListNode result = null;
        while (n1 != null || n2 != null) {

            if (n1 == null) {
                n1 = new ListNode(0);
            }
            if (n2 == null) {
                n2 = new ListNode(0);
            }

            sum = n1.val + n2.val + tmp;
            tmp = 0;
            if (sum >= 10) {
                tmp = 1;
                sum = sum - 10;
            }

            sumNode = new ListNode(sum);

            if (r == null) {
                r = sumNode;
                result = sumNode;
            } else {
                r.next = sumNode;
                r = r.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        if (tmp == 1) {
            r.next = new ListNode(1);
        }

        return result;
    }
}