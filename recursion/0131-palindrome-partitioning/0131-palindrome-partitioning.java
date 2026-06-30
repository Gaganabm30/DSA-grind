import java.util.*;

class Solution {

    private void dfs(int index, String s, List<String> path, List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                path.add(s.substring(index, i + 1));

                dfs(i + 1, s, path, ans);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(0, s, path, ans);

        return ans;
    }
}