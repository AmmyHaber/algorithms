package com.ammyhaber.leetcode;

import java.util.Stack;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class Leetcode160 {

    public static void main(String[] args) {
        ListNode n8 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode a = new ListNode(4, new ListNode(1, n8));
        ListNode b = new ListNode(5, new ListNode(6, new ListNode(1, n8)));
        ListNode listNode = getIntersectionNode(a, b);
        System.out.println(listNode == null ? null : listNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode na = headA;
        while (na != null) {
            stackA.push(na);
            na = na.next;
        }
        ListNode nb = headB;
        while (nb != null) {
            stackB.push(nb);
            nb = nb.next;
        }
        ListNode pa;
        ListNode pb;
        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && (pa = stackA.pop()) != null && (pb = stackB.pop()) != null && pa == pb) {
            result = pa;
        }
        return result;
    }
}
