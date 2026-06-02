class Solution {

    public int maxVowels(String s, int k) {

        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int max = count;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            // Add new character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Remove old character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' ||
               ch == 'i' || ch == 'o' ||
               ch == 'u';
    }
}