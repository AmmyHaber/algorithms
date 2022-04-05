package com.ammyhaber.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode pre;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val, ListNode pre, ListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
