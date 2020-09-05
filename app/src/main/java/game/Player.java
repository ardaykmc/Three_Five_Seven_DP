package game;

import java.util.ArrayList;
import java.util.List;

import repository.IUser;

public class Player {
    private List<Card> cardList;
    private IUser user;
    private double score;
    private boolean isTurn;
    private Movement movement;
    public Player(List<Card> cardList, IUser user, boolean isTurn) {
        this.cardList = cardList;
        this.user = user;
        this.score = 0;
        this.isTurn = isTurn;
    }

    public Player(IUser user) {
        cardList = new ArrayList<Card>();
        this.user = user;
        isTurn = false;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public List<Card> getCardList() {
        return cardList;
    }

}
