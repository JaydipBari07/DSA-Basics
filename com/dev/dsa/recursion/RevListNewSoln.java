package com.dev.dsa.recursion;

import com.dev.dsa.linkedList.singleLinkedList.ListNode;

public class RevListNewSoln {

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
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;        // sometimes you just need to perform operation on current value (head in this case) and return the function response as it is if you want to return the last returned value (last element of linked list in this case. i.e. temp)
    }

    public static void printList(ListNode head){
        do {
            System.out.print(head.val + " ");
            head = head.next;
        } while(head != null);
        System.out.println();
    }
}
