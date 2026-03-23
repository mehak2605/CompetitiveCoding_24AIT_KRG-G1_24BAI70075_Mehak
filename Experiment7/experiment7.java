class Solution {
    public boolean solve(char[][] board, String word, boolean[][] visited, int x, int y, int idx)
    {
        if(idx==word.length())
        return true;
        if(x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]||board[x][y]!=word.charAt(idx))
        {
            return false;
        }
        visited[x][y]=true;

        if(solve(board, word, visited, x+1, y, idx+1)||
            solve(board, word, visited, x-1, y, idx+1)||
            solve(board, word, visited, x, y+1, idx+1)||
            solve(board, word, visited, x, y-1, idx+1))
            {
                return true;
            }
        visited[x][y]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        boolean result=false;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]==word.charAt(0))
                result=solve(board, word, visited, i, j, 0);
                if(result)
                return true;
            }
        }
        return false;
    }
}
