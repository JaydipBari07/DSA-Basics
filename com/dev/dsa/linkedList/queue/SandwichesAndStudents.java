package com.dev.dsa.linkedList.queue;

import com.dev.dsa.linkedList.singleLinkedList.ListNode;

public class SandwichesAndStudents {
    public static LinkedList sands = new LinkedList();
    public static LinkedList studs = new LinkedList();

    public static void main(String[] args) {
        int[] stud = {1, 1, 1, 0, 0, 1};
        int[] sand = {1, 0, 0, 0, 1, 1};
        sands.createLinkedListFromArray(sand);
        studs.createLinkedListFromArray(stud);
        int count = studs.countElements();
        int c = 0;
        while (c != count) {
            if (studs.head != null) {
                if (studs.head.val == sands.head.val) {
                    dequeue(studs);
                    dequeue(sands);
                    count -= 1;
                    c = 0;
                } else {
                    ListNode node = dequeue(studs);
                    enqueue(studs, node);
                    c += 1;
                }
            }
        }
        System.out.println(studs.countElements());
    }

    public static void enqueue(LinkedList list, ListNode node) {
        if (list.tail == null) {
            list.head = node;
            list.tail = list.head;
        } else {
            list.tail.next = node;
            list.tail = list.tail.next;
        }
    }

    public static ListNode dequeue(LinkedList list) {
        if (list.head == null) {
            return null;
        } else {
            ListNode node = new ListNode(list.head.val);
            if (list.head == list.tail) {
                list.head = null;
                list.tail = null;
            } else {
                list.head = list.head.next;
            }
            return node;
        }
    }

    public static class LinkedList {
        public ListNode head;
        public ListNode tail;

        public LinkedList() {
        }

        public void createLinkedListFromArray(int[] arr) {
            this.head = new ListNode(arr[0]);
            this.tail = head;
            for (int i = 1; i < arr.length; i++) {
                this.tail.next = new ListNode(arr[i]);
                this.tail = this.tail.next;
            }
        }

        public int countElements() {
            int count = 0;
            ListNode temp = head;
            if (temp == null) {
                return 0;
            }
            while (temp != tail) {
                count += 1;
                temp = temp.next;
            }
            return count + 1;
        }
    }
}
