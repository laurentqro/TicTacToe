package TicTacToe;

public class Session {
    private Game game;
    private Display display;

    Session(Game game, Display display) {
        this.game = game;
        this.display = display;
    }

    void start() {
        display.printGreeting();
        customiseMark(game.playerX);
        customiseMark(game.playerO);
        game.play();
    }

    private void customiseMark(IPlayer player) {
        display.promptPlayerToCustomiseMark(player.getMark());
        String markChoice = player.getMarkChoice();
        player.setMark(markChoice);
    }
}
