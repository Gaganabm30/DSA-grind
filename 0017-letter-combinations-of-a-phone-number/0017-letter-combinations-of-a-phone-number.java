import java.util.*;

class Solution {

    private String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private void helper(String digits, int index, String current, List<String> ans) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            helper(digits, index + 1, current + letters.charAt(i), ans);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        helper(digits, 0, "", ans);

        return ans;
    }
}