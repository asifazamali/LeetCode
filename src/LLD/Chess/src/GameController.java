package LLD.Chess.src;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.start();
    }

    public void endGame() {
        game.end();
    }

    public void move(Player p, int fromX, int fromY, int toX, int toY) {
        game.move(p, fromX, fromY, toX, toY);
    }

    public void displayBoard(){
        game.displayBoard();
    }

}
