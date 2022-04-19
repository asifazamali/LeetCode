package Backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid=
               {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solveSudoku(grid);
    }
    private static void solveSudoku(int[][] grid){
        solveUtil(grid, 0, 0);
        print(grid);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] == 0){
                    System.out.println("Can't be solved!");
                    return;
                }
            }
        }
    }

    private static boolean solveUtil(int[][] grid, int i, int j) {
        boolean found = false;
        for(i=0; i < 9; i++) {
            for(j=0; j < 9; j++){
                if(grid[i][j] == 0) {
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(i >= grid.length) return true;
        for(int n = 1; n <= 9; n++){
            if(isSafe(grid, i, j, n)){
                grid[i][j] = n;
                if(solveUtil(grid, i, j))
                    return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }
//T(N) = 9T(N-1) + O(18)
    // 9^(N*N)
    private static boolean isSafe(int[][] grid, int i, int j, int n) {
        for(int k = 0; k < 9; k++){
            if(grid[i][k] == n || grid[k][j] == n) return false;
        }

        int rf = (i / 3) * 3;
        int cf = (j / 3) * 3;
        for(int k=rf; k<rf+3;k++) {
            for(int l=cf; l<cf+3;l++)
               if(grid[k][l] == n) return false;
        }
        return true;
    }

    private static void print(int[][] grid){
        for(int[] arr: grid){
            for(int elt: arr){
                System.out.printf(elt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
