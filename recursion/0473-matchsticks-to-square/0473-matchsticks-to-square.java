import java.util.*;

class Solution {

    private boolean backtrack(int index, int[] nums, int[] sides, int target) {

        if (index == nums.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {

            if (sides[i] + nums[index] > target) {
                continue;
            }

            sides[i] += nums[index];

            if (backtrack(index + 1, nums, sides, target)) {
                return true;
            }

            sides[i] -= nums[index];

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] sides = new int[4];

        return backtrack(0, matchsticks, sides, sum / 4);
    }
}