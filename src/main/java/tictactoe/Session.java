package tictactoe;

class Session {
    private Game game;
    private Display display;

    Session(Game game, Display display) {
        this.game = game;
        this.display = display;
    }

    void start() {
        display.printGreeting();

        display.promptPlayerToCustomiseMark(game.playerX.getMark());
        String markX = display.getInput();
        game.playerX.setMark(markX);

        display.promptPlayerToCustomiseMark(game.playerO.getMark());
        String markO = display.getInput();
        game.playerO.setMark(markO);

        game.play();
    }
}
