package com.dev.dsa.linkedList.singleLinkedList;

public class LinkedListUtils {

    public static void printList(ListNode temp){
        do{
            System.out.print(temp.val);
            System.out.print(" ");
            temp = temp.next;
        }while(temp != null);
        System.out.println();
    }
}
