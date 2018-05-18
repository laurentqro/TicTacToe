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
        String markX = chooseMark(game.playerX);
        game.playerX.setMark(markX);

        String markO = chooseMark(game.playerO);
        game.playerO.setMark(markO);

        game.play();
    }

    private String chooseMark(Player player) {
        display.promptPlayerToCustomiseMark(player.getMark());
        try {
            return player.getMarkChoice();
        } catch(InvalidInputException e) {
            display.print(e.getMessage());
            return chooseMark(player);
        }
    }
}
