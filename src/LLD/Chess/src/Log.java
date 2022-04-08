package LLD.Chess.src;

import java.util.List;

public class Log {
    private List<Move> moveList;
    public Log(List<Move> moveList) {
        this.moveList = moveList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public List<Move> appendMove(Move move) {
        moveList.add(move);
        return moveList;
    }
}
