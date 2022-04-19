package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<Integer> temp = new ArrayList<>();
        placeQueen(board, n, 0, 0, temp, list);
        System.out.println(list);
    }

    private static boolean placeQueen(boolean[][] board, int n, int i, int l, List<Integer> list,  List<List<Integer>> res) {
        if(n  ==  0) {
            if(list.size() == board.length)
                res.add(new ArrayList<>(list));
            return true;
       }

       if(i >= board.length) {
          return false;
       }

       for(int j = 0; j < board.length; j++){
          if(canPlace(board, i, j)) {
              board[i][j] = true;
              list.add(j+1);
              placeQueen(board, n - 1, i + 1, 0, list, res);
              board[i][j] = false;
              list.remove(Integer.valueOf(j+1));
          }
       }
        return false;
    }

    private static boolean canPlace(boolean[][] board, int i, int j) {
        for(int k = i; k >= 0; k--) if(board[k][j]) return false;
        for(int k = j; k >= 0; k--) if(board[i][k]) return false;
        int m = i;
        int n = j;
        while(m >= 0 && n >= 0){
            if(board[m--][n--]) return false;
        }
        m = i;
        n = j;
        while(m >= 0 && n < board.length){
            if(board[m--][n++]) return false;
        }
        return true;
    }
    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf((board[i][j] ? 't' : 'f') + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
