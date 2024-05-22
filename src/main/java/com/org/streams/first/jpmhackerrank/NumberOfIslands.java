package com.org.streams.first.jpmhackerrank;

public class NumberOfIslands {

	
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
		
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell is '1' (land), perform DFS to mark all adjacent land cells as visited
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
		
        return count;
	}
	private static void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check if current cell is out of bounds or not land
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark current cell as visited by changing it to '0'
        grid[i][j] = '0';

        // Perform DFS recursively for adjacent cells (up, down, left, and right)
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int islandsCount = solution.numIslands(grid);
        System.out.println("Number of islands: " + islandsCount);
        
        char [][] grid1= {
        		  {'1','1','1','1','0'},
        		  {'1','1','0','1','0'},
        		  {'1','1','0','0','0'},
        		  {'0','0','0','0','0'}};
        islandsCount = solution.numIslands(grid1);
        System.out.println("Number of islands: " + islandsCount);
        char [][] grid2= {
                       {'1','1','0','0','0'},
                       {'1','1','0','0','0'},
                       {'0','0','1','0','0'},
                       {'0','0','0','1','1'}
                     };
        islandsCount = solution.numIslands(grid2);
        System.out.println("Number of islands: " + islandsCount);
    }
    
    /*SOL 2*/
    public static int numIslands1(char[][] grid) {
    int m = grid.length, n= grid[0].length;
    int [][] dp = new int[m][n];
    
    int res=0;
    for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++){
            if(grid[i][j]=='1' && dp[i][j]==0) {
                res+=1;
                calculateNumberOfIslands(i,j,grid,dp,m,n);
            }
        }
    }
    return res;
    
}

	private static void calculateNumberOfIslands(int row, int col, char[][] grid, int[][] dp,int m, int n) {
	    if(row<0 || row>=m || col<0 || col>=n || grid[row][col]=='0' || dp[row][col]!=0)
	        return;
	    dp[row][col]=1;
	    
	    calculateNumberOfIslands(row-1,col,grid,dp,m,n);
	    calculateNumberOfIslands(row,col-1,grid,dp,m,n);
	    calculateNumberOfIslands(row+1, col,grid,dp,m,n);
	    calculateNumberOfIslands(row, col+1,grid,dp,m,n);
	}

}
