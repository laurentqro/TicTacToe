package TicTacToe;

class Session {
    private static final int MAX_MARK_LENGTH = 2;
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

        String markChoice = "";
        while(!isValid(markChoice)) {
            markChoice = sanitize(player.getMarkChoice());
            if(isValid(markChoice)) {
                player.setMark(markChoice);
                break;
            }
            display.warnInvalidInput(markChoice);
        }
    }

    private boolean isValid(String input) {
        return !input.isEmpty() & input.length() <= MAX_MARK_LENGTH;
    }

    private String sanitize(String input) {
        return input.replaceAll("\\s+","");
    }
}
