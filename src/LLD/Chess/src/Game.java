package LLD.Chess.src;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Log log;
    private GameStatus gameStatus;
    private Color turnColor;
    public void start() {
        board = new Board();
        log = new Log(new ArrayList<>());
        gameStatus = GameStatus.PLAYING;
        turnColor = Color.WHITE;
    }

    public void end(){
        gameStatus = GameStatus.FINISHED;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void displayBoard(){
        board.displayBoard();
    }

    public void move(Player player, int x1, int y1, int x2, int y2){
        if(player.getColor() != turnColor) {
            System.out.println("not valid turn");
            return;
        }
        Piece startPosition= board.getPiece(x1, y1);
        Piece endPosition = board.getPiece(x2, y2);
        if(startPosition == null) {
            System.out.println("not valid move: SourcePiece not there");
            return;
        }
        if(startPosition.validMove(x1,y1,x2,y2)){
            Move move = new Move(player, x1, y1, x2, y2);
            move.setPieceMoved(startPosition);
            if(endPosition != null){
                if(endPosition.getColor() != player.getColor()) {
                    move.setPieceKilled(endPosition);
                    if(endPosition instanceof King)
                        gameStatus = GameStatus.FINISHED;
                }
                else {
                    System.out.println("same color piece already exists at destination");
                    return;
                }
            }
            log.appendMove(move);
            board.setPiece(null, x1, y1);
            board.setPiece(startPosition, x2, y2);
        }
        if(turnColor == Color.BLACK) turnColor = Color.WHITE;
        else turnColor = Color.BLACK;
    }
}
