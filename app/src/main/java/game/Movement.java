package game;

import java.util.List;

public class Movement {
    private Player activePlayer;
    private List<Box> chosenElement;
    private Layout layout;

    public Movement(Player activePlayer, List<Box> chosenElement, Layout layout) {
        this.activePlayer = activePlayer;
        this.chosenElement = chosenElement;
        this.layout = layout;
    }
    public void chooseBox(Box box){
        chosenElement.add(box);
    }

    public List<Box> getChosenElement() {
        return chosenElement;
    }
}
