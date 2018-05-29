package tictactoe;

class Game {
    public Board board;
    private Display display;

    private Player currentPlayer;
    Player playerX;
    Player playerO;

    Game(Display display, Board board, Player playerX, Player playerO) {
        this.display = display;
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    void play() {
        startGame();

        while (!isOver()) {
            playTurn();
        }

        endGame();
    }

    boolean isOver() {
        return board.hasWin() || board.hasTie();
    }

    private void startGame() {
        display.printGreeting();
        display.printBoard(board);
    }

    void playTurn() {
        display.announcePlayerTurn(currentPlayer.getMark());
        display.promptPickMove(currentPlayer.getMark());
        markBoard(getMove(this));
        switchPlayers();
        display.printBoard(board);
    }

    private void endGame() {
        if (board.hasWin()) {
            display.announceWinner(board.getWinner());
        } else {
            display.announceDraw();
        }
        display.printGoodbye();
    }

    private void markBoard(int position) {
        board.markCellAtPosition(currentPlayer.getMark(), position);
    }

    private int getMove(Game game) {
        return currentPlayer.getMove(game);
    }

    private void switchPlayers() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }
}
