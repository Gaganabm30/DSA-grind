import java.util.*;

class Solution {

    private void func(int ind, int target, List<Integer> current,
                      int[] candidates, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || ind == candidates.length) {
            return;
        }

        current.add(candidates[ind]);

        func(ind + 1, target - candidates[ind], current, candidates, ans);

        current.remove(current.size() - 1);

        for (int i = ind + 1; i < candidates.length; i++) {

            if (candidates[i] != candidates[ind]) {

                func(i, target, current, candidates, ans);
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        func(0, target, current, candidates, ans);

        return ans;
    }
}