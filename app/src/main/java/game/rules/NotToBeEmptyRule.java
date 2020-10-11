package game.rules;

import java.util.List;

import game.Box;
import game.Layout;
import game.Movement;
import helper.CountNonNullElementInListOfList;
import helper.ListOfListCopier;

public class NotToBeEmptyRule extends Rule implements IRule {
    private Layout layout;
    public NotToBeEmptyRule(Movement movement, Layout layout) {
        super(movement);
        this.layout = layout;
    }
    public NotToBeEmptyRule(){
        super();
    }
    @Override
    public boolean isValid() {
        return checkLayout();
    }

    private boolean checkLayout(){
        CountNonNullElementInListOfList countNonNullElementInListOfList = new CountNonNullElementInListOfList(this.getMovement().getChosenElement());
        int countOfBoxes =countNonNullElementInListOfList.count();
        return countOfBoxes - this.getMovement().getChosenElement().size() != 0;
    }
    private boolean checkLayout(Movement movement){
        CountNonNullElementInListOfList countNonNullElementInListOfList = new CountNonNullElementInListOfList(movement.getChosenElement());
        int countOfBoxes =countNonNullElementInListOfList.count();
        return countOfBoxes - movement.getChosenElement().size() != 0;
    }
}
