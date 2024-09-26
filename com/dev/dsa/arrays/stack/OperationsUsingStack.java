package com.dev.dsa.arrays.stack;

public class OperationsUsingStack {

    public static void main(String[] args) {
        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int top = 0;
        int sum = 0;
        for(int i=0; i<operations.length; i++){
            switch (operations[i]){
                case "+":
                    stack[top] = stack[top-1] + stack[top-2];
                    sum += stack[top];
                    top++;
                    break;
                case "C":
                    sum -= stack[top-1];
                    top--;
                    break;
                case "D":
                    stack[top] = stack[top-1] * 2;
                    sum += stack[top];
                    top++;
                    break;
                default:
                    stack[top] = Integer.parseInt(operations[i]);
                    sum += stack[top];
                    top++;
                    break;
            }
        }
        return sum;
    }
}
