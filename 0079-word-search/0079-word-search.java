class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        char[] wordChar = word.toCharArray();

        if(wordChar.length > m * n) return false;

        int[] count = new int[256];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count[board[i][j]]++;
            }
        }

        int len = wordChar.length;

        for(int i =0;i<len/2;i++){
            if(count[wordChar[i]] > count[wordChar[len - i -1]]){
                for(int j = 0;j<len/2;j++){
                    char temp = wordChar[j];
                    wordChar[j] = wordChar[len - 1 - j];
                    wordChar[len - 1 - j] = temp;
                }
                break;
            }
        }

        for(char c :wordChar){
            if(--count[c] < 0) return false;
        }

        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(solve(0,i,j,board,m,n,visited,wordChar)) return true;
            }
        }

        return false;
    }

    private boolean solve(int start,int i,int j,char[][] board,int m,int n,boolean[][] visited,char[] wordChar){
        if(start == wordChar.length) return true;

        if(i>=m || j>=n || i<0 || j<0 || visited[i][j] || wordChar[start] != board[i][j])
                return false;

        visited[i][j] = true;

        boolean found = solve(start+1,i+1,j,board,m,n,visited,wordChar) || 
                        solve(start+1,i-1,j,board,m,n,visited,wordChar) || 
                        solve(start+1,i,j+1,board,m,n,visited,wordChar) || 
                        solve(start+1,i,j-1,board,m,n,visited,wordChar);

    
        visited[i][j] = false;

        return found;
    }
}