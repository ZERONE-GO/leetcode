package p1047;

public class Solution {

    public String removeDuplicates(String S) {
        int len = S.length();

        char[] stack = new char[len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (size == 0 || stack[size - 1] != S.charAt(i)) {
                stack[size] = S.charAt(i);
                size++;
            } else {
                size--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }

}
