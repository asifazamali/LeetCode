package LLD.Chess.src;

import java.util.UUID;

public class Knight extends Piece {
    public Knight(Color color) {
        super(UUID.randomUUID().toString(), color);
    }
    @Override
    boolean validMove(int x1, int x2, int y1, int y2) {
        return false;
    }

    @Override
    public void printPiece() {
        System.out.print('k');
    }
}
