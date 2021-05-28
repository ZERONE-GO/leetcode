package p1190;

import java.util.Stack;

public class Solution {

    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> left = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                left.push(i);
            } else if (arr[i] == ')') {
                reverse(arr, left.pop(), i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '(' && arr[i] != ')') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

}
