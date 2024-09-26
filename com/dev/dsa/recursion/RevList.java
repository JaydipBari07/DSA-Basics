package com.dev.dsa.recursion;

import com.dev.dsa.linkedList.singleLinkedList.ListNode;

public class RevList {

    public static ListNode h = null;
    public static ListNode l = null;

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(2);
        ListNode t = node;
        printList(t);
        ListNode temp = reverseList(node);
        printList(temp);

    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        if(h == null){
            h = head;
        }

        if(head.next == null){
            l = head;
            return head;
        }
        reverseList(head.next).next = head;
        head.next = null;
        if(h == head){
            return l;
        }else{
            return head;
        }
    }

    public static void printList(ListNode head){
        do{
            System.out.print(head.val + " ");
            head = head.next;
        }while(head != null);
    }
}
