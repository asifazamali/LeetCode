package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {
    public static void main(String[] args) {
        int[][] arr =
                {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        ArrayList<String> res = new ArrayList<>();
        solve(arr, arr.length, 0, 0, new StringBuilder(), res);
        System.out.println(res);
    }
// T(N) = 4T(N-1) + O(1)
// T(N) = 4^(N*N)
    private static boolean solve(int[][] arr, int n, int i, int j, StringBuilder sb, ArrayList<String> res) {
       if(i == n-1 && j == n-1 && arr[i][j] == 1) {
           res.add(sb.toString());
           return true;
       }
       if(i < 0 || i >= n || j < 0  || j >= n || arr[i][j] == 0) return false;
       arr[i][j] = 0;
       sb.append("D");
       solve(arr, n, i + 1, j, sb, res);
       sb.setCharAt(sb.length()-1, 'U');
       solve(arr, n, i - 1, j, sb, res);
       sb.setCharAt(sb.length()-1, 'L');
       solve(arr, n, i, j - 1, sb, res);
       sb.setCharAt(sb.length()-1, 'R');
       solve(arr, n, i, j + 1, sb, res);
       sb.setLength(sb.length()-1);
       arr[i][j] = 1;
       return false;
    }
}
