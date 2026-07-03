class Solution {

    int count = 0;

    private void backtrack(int[] freq) {

        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0) {
                continue;
            }

            count++;

            freq[i]--;

            backtrack(freq);

            freq[i]++;
        }
    }

    public int numTilePossibilities(String tiles) {

        int[] freq = new int[26];

        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        backtrack(freq);

        return count;
    }
}