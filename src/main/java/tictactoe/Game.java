package tictactoe;

class Game {
    private Board board;
    private Display display;
    private IPlayer currentPlayer;
    IPlayer playerX;
    IPlayer playerO;

    Game(Display display, Board board, IPlayer playerX, IPlayer playerO) {
        this.display = display;
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
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
        markBoard(getMove());
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

    private void markBoard(int move) {
        try {
            board.markCellAtPosition(currentPlayer.getMark(), move);
        } catch(InvalidInputException e) {
            display.print(e.getMessage());
            getMove();
        }
    }

    private int getMove() {
        try {
            return Integer.parseInt(currentPlayer.getMove());
        } catch(InvalidInputException e) {
            display.print(e.getMessage());
            return getMove();
        }
    }

    private void switchPlayers() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }
}
