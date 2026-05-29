class Solution {
    public boolean backspaceCompare(String s, String t) {

        // Start from last index of both strings
        int i = s.length() - 1;
        int j = t.length() - 1;

        // Counts how many characters to skip
        int skipS = 0;
        int skipT = 0;

        // Run until both strings are fully processed
        while (i >= 0 || j >= 0) {

            // Find next valid character in s
            while (i >= 0) {

                // If current char is '#'
                if (s.charAt(i) == '#') {
                    skipS++; // increase skip count
                    i--;
                }

                // Skip character because of previous '#'
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }

                // Valid character found
                else {
                    break;
                }
            }

            // Find next valid character in t
            while (j >= 0) {

                // If current char is '#'
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                }

                // Skip character
                else if (skipT > 0) {
                    skipT--;
                    j--;
                }

                // Valid character found
                else {
                    break;
                }
            }

            // Get current valid character from s
            char first;
            if (i < 0) {
                first = '$';
            } else {
                first = s.charAt(i);
            }

            // Get current valid character from t
            char second;
            if (j < 0) {
                second = '$';
            } else {
                second = t.charAt(j);
            }

            // Compare characters
            if (first != second) {
                return false;
            }

            // Move to previous character
            i--;
            j--;
        }

        // All characters matched
        return true;
    }
}