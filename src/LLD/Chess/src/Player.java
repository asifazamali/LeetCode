package LLD.Chess.src;

public class Player {
    private String name;
    private Color color;
    GameController gameController;

    public Player(String name, Color color, GameController gameController) {
        this.name = name;
        this.color = color;
        this.gameController = gameController;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void playMove(int x1, int y1, int x2, int y2){
        gameController.move(this, x1, y1, x2, y2);
    }

    public void displayBoard(){
        gameController.displayBoard();
    }
}
