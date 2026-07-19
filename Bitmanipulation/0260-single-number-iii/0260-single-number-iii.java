class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;

        for(int num: nums) {
            xor ^= num;
        }

        xor = (xor & (xor - 1)) ^ xor;

        for(int num: nums) {
            if((num & xor) != 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }

        return ans;
    }
}