package Backtracking;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode{
    TreeNode[] treeNode;
    boolean isEOW;
    public TreeNode(){
       treeNode = new TreeNode[52];
       isEOW = false;
    }
    public boolean isValid(char c){
        return isSmallCase(c) || isLargeCase(c);

    }
    public boolean isSmallCase(char c){
        return c >= 'a' && c <= 'z';
    }
    public boolean isLargeCase(char c){
        return c >= 'A' && c <= 'Z';
    }

    public TreeNode getNode(char c){
        if(isSmallCase(c)) return this.treeNode[c - 'a'];
        if(isLargeCase(c)) return this.treeNode[c - 'A'+ 26];
        return null;
    }

}
public class WordBoggle {
    public static void main(String[] args) {
        String[] dictionary = {"GEEKS","FOR","QUIZ","GO"};
        char[][] board = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
        String[] res = wordBoggle(board, dictionary);

    }
    public static String[] wordBoggle(char board[][], String[] dictionary){
        TreeNode root = createTrie(dictionary);
        Set<String> res = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                solve(board, i, j, new StringBuilder(), root, res);
        }

        System.out.println(res);
        return res.toArray(new String[0]);
    }

    private static  boolean solve(char[][] board, int i, int j, StringBuilder sb, TreeNode root, Set<String> res) {
        if(root.isEOW) res.add(sb.toString());
        if(i < 0 || i >= board.length || j < 0 || j >= board.length || root == null || board[i][j] == '-') return true;
        char ch = board[i][j];
        if(root.isValid(ch) && root.getNode(ch) != null) {
            board[i][j] = '-';
            TreeNode childNode = root.getNode(ch);
            sb.append(ch);
            solve(board, i + 1, j, sb, childNode, res);
            solve(board, i - 1, j, sb, childNode, res);
            solve(board, i , j-1, sb, childNode, res);
            solve(board, i , j+1, sb, childNode, res);
            solve(board, i+1 , j+1, sb, childNode, res);
            solve(board, i+1 , j-1, sb, childNode, res);
            solve(board, i-1 , j+1, sb, childNode, res);
            solve(board, i-1 , j-1, sb, childNode, res);
            sb.setLength(sb.length()-1);
            board[i][j] = ch;
        }
        return false;
    }

    private static TreeNode createTrie(String[] dictionary) {
        TreeNode root = new TreeNode();
        for(String str: dictionary){
            addToTrie(root, str);
        }
        return root;
    }

    private static void addToTrie(TreeNode root, String str) {
        TreeNode temp = root;
        for (char c : str.toCharArray()) {
            if(root.isValid(c)){
                TreeNode child = temp.getNode(c);
                if (child == null) {
                    child = new TreeNode();
                }
                temp.treeNode[ temp.isSmallCase(c)? c - 'a' : c - 'A' + 26] = child;
                temp = child;
            }
        }
        temp.isEOW = true;
    }
}
