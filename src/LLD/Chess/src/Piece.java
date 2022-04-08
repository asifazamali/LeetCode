package LLD.Chess.src;

public abstract class Piece {
    private String id;
    private Color color;
    public Piece(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    abstract boolean validMove(int x1, int x2, int y1, int y2);

    public abstract void printPiece();
}
