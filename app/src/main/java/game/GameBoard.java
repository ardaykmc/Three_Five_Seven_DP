package game;

import repository.IUser;

public class GameBoard {
    private Layout layout;
    private Player player1;
    private Player player2;

    public GameBoard(Layout layout, Player player1, Player player2) {
        this.layout = layout;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Layout getLayout() {
        return layout;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
