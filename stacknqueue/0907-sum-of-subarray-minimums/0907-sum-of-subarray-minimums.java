import java.util.*;

class Solution {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] nse = new int[n];
        int[] psee = new int[n];

        Stack<Integer> st = new Stack<>();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        st.clear();

        // Previous Smaller or Equal Element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long left = i - psee[i];
            long right = nse[i] - i;

            long contribution = left * right * arr[i];

            sum = (sum + contribution) % mod;
        }

        return (int) sum;
    }
}