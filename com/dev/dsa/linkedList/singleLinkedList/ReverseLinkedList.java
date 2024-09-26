package com.dev.dsa.linkedList.singleLinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = getLastElement(head);
        reverse(head);
        return newHead;
    }

    public static ListNode reverse(ListNode head){
        if(head.next != null) {
            ListNode temp = reverse(head.next);
            temp.next = head;
            head.next = null;
        }
        return head;
    }

    public static ListNode getLastElement(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        ListNode head = createLinkedListFromArray(array);
        ListNode temp = reverseList(head);
        LinkedListUtils.printList(temp);
    }

    public static ListNode createLinkedListFromArray(int[] array){
        ListNode head = new ListNode();
        ListNode cur;
        head.val = array[0];
        cur = head;
        for(int i=1; i<array.length; i++){
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }
}
