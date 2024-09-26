package com.dev.dsa.linkedList.doubleLinkedList;

class MyLinkedList {

    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        head = new ListNode();
        tail = head;
        head.prev = null;
        head.next = null;
    }

    static class ListNode{
        int val;
        ListNode prev;
        ListNode next;
    }

    public int get(int index) {
        if(index < 0 || head == null){
            return -1;
        } else {
            ListNode cur = head;
            for(int i=0; i < index; i++) {
                if(cur == null){
                    return -1;
                }
                cur = cur.next;
            }
            if(cur == null){
                return -1;
            }
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        if(head == tail && head.val == 0){
            head.val = val;
        } else {
            ListNode temp = new ListNode();
            temp.val = val;
            temp.prev = null;
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void addAtTail(int val) {
        if(tail == head && tail.val == 0){
            tail.val = val;
        } else {
            ListNode temp = new ListNode();
            temp.val = val;
            tail.next = temp;
            temp.prev = tail;
            temp.next = null;
            tail = temp;
        }
    }

    public void addAtIndex(int index, int val) {
        ListNode temp = new ListNode();
        temp.val = val;
        if(head == null){
            head = temp;
            tail = temp;
        } else {
            ListNode cur = head;
            for(int i = 0; i < index-1; i++){
                if(cur == null){
                    return;
                } else {
                    cur = cur.next;
                }
            }
            if(cur.next == null){
                cur.next = temp;
                temp.prev = cur;
                tail = cur.next;
            } else {
                cur = cur.next;
                temp.next = cur;
                temp.prev = cur.prev;
                cur.prev.next = temp;
                cur.prev = temp;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if(head == null){
            return;
        } else if(index == 0){
            if(head == tail){
                head.val = 0;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            ListNode cur = head;
            for(int i = 0; i < index-1; i++){
                if(cur == null){
                    return;
                } else {
                    cur = cur.next;
                }
            }
            if(cur.next == null){
                return;
            } else {
                cur = cur.next;
                if(cur == tail){
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    ListNode prevCur = cur.prev;
                    prevCur.next = cur.next;
                    cur.next.prev = prevCur;
                }
            }
        }
    }
}
