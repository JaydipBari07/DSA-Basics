package com.dev.dsa.linkedList.queue;

public class StackUsingQueue {

    private ListNode top;

    public StackUsingQueue() {
    }

    public void push(int x) {
        if(this.top == null){
            this.top = new ListNode(x);
        } else {
            ListNode temp = new ListNode(x);
            this.top.next = temp;
            temp.prev = this.top;
            this.top = this.top.next;
        }
    }

    public int pop() {
        if(this.top != null){
            int val = this.top.val;
            this.top = this.top.prev;
            return val;
        } else {
            return -1;
        }
    }

    public int top() {
        return this.top.val;
    }

    public boolean empty() {
        return this.top == null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        System.out.println(stackUsingQueue.top());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());
    }
}
