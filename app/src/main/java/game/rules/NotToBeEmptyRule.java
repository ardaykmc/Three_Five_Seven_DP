package game.rules;

import java.util.List;

import game.Box;
import game.Layout;
import game.Movement;
import helper.ListOfListCopier;

public class NotToBeEmptyRule extends Rule implements IRule {
    private Layout layout;
    public NotToBeEmptyRule(Movement movement, Layout layout) {
        super(movement);
        this.layout = layout;
    }
    @Override
    public boolean isValid() {

        this.getMovement().getChosenElement();
        return false;
    }

    private boolean checkLayout(){
        List<List<Box>> layoutList ;
        ListOfListCopier listOfListCopier = new ListOfListCopier();
        layoutList = listOfListCopier.getCopyList(this.layout.getLayoutList());

    }

}
