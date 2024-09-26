package com.dev.dsa.linkedList.singleLinkedList;

import java.util.Objects;

import static com.dev.dsa.linkedList.singleLinkedList.ReverseLinkedList.createLinkedListFromArray;

public class MergeSortedLinkedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }else if(list2 == null) {
            return list1;
        }
        ListNode newHead = new ListNode();
        ListNode newCur = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        do {
            if (cur1.val == cur2.val) {
                newCur.val = cur1.val;
                newCur.next = new ListNode(cur2.val);
                newCur = newCur.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1.val > cur2.val) {
                newCur.val = cur2.val;
                cur2 = cur2.next;
            } else {
                newCur.val = cur1.val;
                cur1 = cur1.next;
            }
            newCur.next = new ListNode();
            newCur = newCur.next;
        }while (cur1 != null && cur2 != null);
        if (cur1 != null) {
            newCur.val = cur1.val;
            newCur.next = cur1.next;
        } else if (cur2 != null) {
            newCur.val = cur2.val;
            newCur.next = cur2.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{3, 5, 8, 9};
        ListNode list1 = createLinkedListFromArray(array1);
        ListNode list2 = createLinkedListFromArray(array2);
        ListNode list = mergeTwoLists(list1, list2);
        LinkedListUtils.printList(list);
    }
}
