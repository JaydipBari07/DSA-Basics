package com.dev.dsa.sorting;

import com.dev.dsa.linkedList.singleLinkedList.LinkedListUtils;
import com.dev.dsa.linkedList.singleLinkedList.ListNode;

import static com.dev.dsa.linkedList.singleLinkedList.ReverseLinkedList.createLinkedListFromArray;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode mergedList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode cur1 = null;
            ListNode cur2 = null;
            if (mergedList != null && lists[i] != null) {
                if(mergedList.val <= lists[i].val){
                    cur1 = mergedList;
                    cur2 = lists[i];
                } else {
                    ListNode temp = mergedList;
                    cur2 = lists[i];
                    mergedList = cur2;
                    cur1 = mergedList;
                    cur2 = temp;
                }
            } else if(mergedList == null){
                mergedList = lists[i];
                continue;
            }
            while (cur1 != null && cur1.next != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    if (cur1.next.val < cur2.val) {
                        cur1 = cur1.next;
                    } else if (cur1.next.val > cur2.val) {
                        // insert element after cur1
                        ListNode temp = cur2.next;
                        cur2.next = cur1.next;
                        cur1.next = cur2;
                        cur2 = temp;
                        cur1 = cur1.next;
                    } else {
                        cur1 = cur1.next;
                    }
                } else if (cur1.val > cur2.val) {
                    ListNode temp = cur2.next;
                    cur2.next = cur2;
                    cur2 = temp;
                } else {
                    // insert element after cur1
                    ListNode temp = cur2.next;
                    cur2.next = cur1.next;
                    cur1.next = cur2;
                    cur2 = temp;
                    cur1 = cur1.next;
                }
            }
            if (cur1 == null) {
                if (cur2 != null) {
                    mergedList = cur2;
                }
            } else if (cur1.next == null) {
                if (cur2 != null) {
                    cur1.next = cur2;
                }
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1};
        int[] array2 = new int[]{0};
        ListNode list1 = createLinkedListFromArray(array1);
        ListNode list2 = createLinkedListFromArray(array2);
        ListNode list = mergeKLists(new ListNode[]{list1, list2});
        LinkedListUtils.printList(list);
    }
}
