class Solution {

    int count = 0;

    private void backtrack(int position, int n, boolean[] visited) {

        if (position > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {

            if (visited[num]) {
                continue;
            }

            if (num % position != 0 && position % num != 0) {
                continue;
            }

            visited[num] = true;

            backtrack(position + 1, n, visited);

            visited[num] = false;
        }
    }

    public int countArrangement(int n) {

        boolean[] visited = new boolean[n + 1];

        backtrack(1, n, visited);

        return count;
    }
}