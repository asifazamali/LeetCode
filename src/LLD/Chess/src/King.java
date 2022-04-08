package LLD.Chess.src;

import java.util.UUID;

public class King extends Piece {
    public King(Color color) {
        super(UUID.randomUUID().toString(), color);
    }

    @Override
    boolean validMove(int x1, int x2, int y1, int y2) {
        return true;
    }

    @Override
    public void printPiece() {
        System.out.print('K');
    }
}
