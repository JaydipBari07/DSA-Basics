package com.dev.dsa.linkedList.doubleLinkedList;

class BrowserHistory {

    ListNode head;
    ListNode tail;
    ListNode cur;

    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        tail = head;
        cur = head;
    }

    static class ListNode {
        String val;
        ListNode prev;
        ListNode next;

        ListNode(String val) {
            this.val = val;
        }
    }

    public void visit(String url) {
        if (head == tail && head.val == null) {
            head.val = url;
        } else {
            ListNode temp = new ListNode(url);
            cur.next = temp;
            temp.prev = cur;
            temp.next = null;
            cur = cur.next;
            tail = cur;
        }
    }

    public String back(int steps) {
        if (tail == head) {
            return head.val;
        } else {
            while(cur != head && steps > 0){
                cur = cur.prev;
                steps -= 1;
            }
            return cur.val;
        }
    }

    public String forward(int steps) {
        if(tail == head){
            return cur.val;
        } else {
            while(cur != tail && steps > 0){
                cur = cur.next;
                steps -= 1;
            }
            return cur.val;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
