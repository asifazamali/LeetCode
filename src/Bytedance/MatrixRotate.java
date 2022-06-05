package Bytedance;

import java.util.PriorityQueue;

public class MatrixRotate {
    public static void main(String[] args) {
       int[][] matrix  = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
       rotateMatrix(matrix);
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.remove(2);

    }
    /*
        [1, 2, 3, 10]
        [4, 5, 6, 11]
        [7, 8, 9, 12]

        [1, 4, 7]
        [2, 5, 8]
        [3, 6, 9]
        [10, 11, 12]


        [7, 4, 1]
        [8, 5, 2]
        [9, 6, 3]
        [12, 11, 10]

        [1, 4, 7]
        [2, 5, 8]
        [3, 6, 9]

        [7, 4, 1]
        [8, 5, 2]
        [9, 6, 3]
     */
    public static void rotateMatrix(int[][] matrix){
        matrix= rotateMainDiagonal(matrix);
        matrix= mirrorImage(matrix);
        print(matrix);
    }

    private static void print(int[][] mirroredMatrix) {
        for(int i = 0; i < mirroredMatrix.length; i++){
            for(int j = 0; j < mirroredMatrix.length; j++){
                System.out.printf(mirroredMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mirrorImage(int[][] transposeMatrix) {
        for(int i = 0; i < transposeMatrix.length; i++){
            int k = 0;
            int j = transposeMatrix[0].length-1;
            while(k < j){
                int temp = transposeMatrix[i][k];
                transposeMatrix[i][k] = transposeMatrix[i][j];
                transposeMatrix[i][j] = temp;
                k++;
                j--;
            }
        }
        return transposeMatrix;
    }

    private static int[][] rotateMainDiagonal(int[][] matrix) {
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

}
