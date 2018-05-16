package TicTacToe;

public class Main {

    public static void main(String[] args) {
        Display display = new Display(System.out, System.in);
        Board board = new Board();
        Player playerX = new Player("X", display);
        Player playerO = new Player("O", display);

        Game game = new Game(display, board, playerX, playerO);
        game.play();
    }
}
