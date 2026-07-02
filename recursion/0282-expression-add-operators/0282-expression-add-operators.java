import java.util.*;

class Solution {

    private void backtrack(String num, int target, int index, long value, long previous, String path, List<String> ans) {

        if (index == num.length()) {
            if (value == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            if (index == 0) {

                backtrack(num, target, i + 1, curr, curr, currStr, ans);

            } else {

                backtrack(num, target, i + 1, value + curr, curr, path + "+" + currStr, ans);

                backtrack(num, target, i + 1, value - curr, -curr, path + "-" + currStr, ans);

                backtrack(num, target, i + 1, value - previous + previous * curr, previous * curr, path + "*" + currStr, ans);
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        backtrack(num, target, 0, 0, 0, "", ans);

        return ans;
    }
}