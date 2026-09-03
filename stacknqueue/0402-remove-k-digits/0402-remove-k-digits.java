import java.util.Stack;

class Solution {
    public String removeKdigits(String nums, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < nums.length(); i++) {

            char digit = nums.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        // If k digits are still remaining
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        res.reverse();

        // Remove leading zeros
        int i = 0;

        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        if (i == res.length()) {
            return "0";
        }

        return res.substring(i);
    }
}