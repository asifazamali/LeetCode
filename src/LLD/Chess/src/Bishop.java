package LLD.Chess.src;

import java.util.UUID;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(UUID.randomUUID().toString(), color);
    }
    public Color getColor(){
        return super.getColor();
    }

    @Override
    boolean validMove(int x1, int x2, int y1, int y2) {
        return true;
    }

    @Override
    public void printPiece() {
        System.out.print('B');
    }
}
