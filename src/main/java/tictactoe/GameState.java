package tictactoe;

public class GameState {
    private Board board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;

    public GameState(Game game) {
        this.board = game.getBoard();
        this.currentPlayer = game.getCurrentPlayer();
        this.playerX = game.getPlayerX();
        this.playerO = game.getPlayerO();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isTerminal() {
        return board.hasWin() || board.hasTie();
    }

    public Player getNextPlayer() {
        if(currentPlayer.equals(playerX)) {
            return playerO;
        } else {
            return playerX;
        }
    }
}
