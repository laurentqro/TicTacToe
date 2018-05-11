package TicTacToe;

public class Main {

    public static void main(String[] args) {
        Display display = new Display(System.out, System.in);
        Board board = new Board();

        Game game = new Game(display, board);
        game.play();
    }
}
