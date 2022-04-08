package LLD.Chess.src;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player("A", Color.WHITE, new GameController(game));
        Player player2 = new Player("B", Color.BLACK, new GameController(game));
        game.start();
        player1.displayBoard();
        System.out.println("\n\n");
        player1.playMove(0, 0, 1, 0);
        player2.displayBoard();
        System.out.println("\n\n");
        player2.playMove(0, 0, 2, 1);
        player1.displayBoard();
        System.out.println("\n\n");
    }

}
