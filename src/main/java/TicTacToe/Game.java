package TicTacToe;

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
        board.mark(currentPlayer.getMark(), move);
    }

    private int getMove() {
        String input = "";
        int move = 0;

        while(!isValid(input)) {
            input = currentPlayer.getInput();

            if(isValid(input)) {
                move = Integer.parseInt(input);
                return move;
            }

            display.warnInvalidInput(input);
            display.promptPickMove(currentPlayer.getMark());
        }

        return move;
    }

    private boolean isValid(String input) {
        return board.getGridAsList().contains(input);
    }

    private void switchPlayers() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }
}
