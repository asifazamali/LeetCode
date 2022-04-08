package LLD.Chess.src;

import java.util.Objects;

public class Board {
    Piece[][] board;
    public Board() {
        board = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
        init();
    }

    private void init() {
        this.setPiece(new Rook(Color.BLACK), 0, 0);
        this.setPiece(new Rook(Color.BLACK), 0, 7);
        this.setPiece(new Knight(Color.BLACK), 0, 1);
        this.setPiece(new Knight(Color.BLACK), 0, 6);
        this.setPiece(new Bishop(Color.BLACK), 0, 2);
        this.setPiece(new Bishop(Color.BLACK), 0, 5);
        this.setPiece(new King(Color.BLACK), 0, 3);
        this.setPiece(new Queen(Color.BLACK), 0, 4);
//pawns

        this.setPiece(new Rook(Color.WHITE), 7, 0);
        this.setPiece(new Rook(Color.WHITE), 7, 7);
        this.setPiece(new Knight(Color.WHITE), 7, 1);
        this.setPiece(new Knight(Color.WHITE), 7, 6);
        this.setPiece(new Bishop(Color.WHITE), 7, 2);
        this.setPiece(new Bishop(Color.WHITE), 7, 5);
        this.setPiece(new King(Color.WHITE), 7, 3);
        this.setPiece(new Queen(Color.WHITE), 7, 4);
//pawns

    }


    public void setPiece(Piece p, int x, int y) {
        board[x][y] = p;
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void displayBoard(){
        for(int i = 0; i < 8; i++){
            System.out.println("-------------------");
            for(int j = 0; j< 8; j++){
                if(Objects.nonNull(board[i][j])){
                    board[i][j].printPiece();
                }else{
                    System.out.print('x');
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
