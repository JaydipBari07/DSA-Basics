package com.dev.dsa.arrays.stack;

public class ParenthesesValidation {

    public static void main(String[] args) {
        String s = "([{}])))))((((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];

        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (top > 0 && stack[top - 1] == '(') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (top > 0 && stack[top - 1] == '{') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (top > 0 && stack[top - 1] == '[') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack[top] = s.charAt(i);
                    top++;
                    break;
            }
        }
        return top == 0;
    }
}
