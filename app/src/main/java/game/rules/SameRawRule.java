package game.rules;

import java.util.List;

import game.Box;
import game.Movement;

public class SameRawRule extends Rule implements IRule {
    public SameRawRule(Movement movement) {
        super(movement);
    }

    /**
     *
     * @return whether the condition true if all boxes are lying on same raw otherwise return false
     */
    public SameRawRule(){

    }
    @Override
    public boolean isValid() {
        Movement movement = this.getMovement();
        List<Box> chosenBoxes  = movement.getChosenElement();
        boolean result = true ;
        Box baseBox = chosenBoxes.get(0);
        for (int i = 1 ; i < chosenBoxes.size(); i++){
            if (chosenBoxes.get(i).getRaw() != baseBox.getRaw()){
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean isValid(Movement movement) {
        List<Box> chosenBoxes  = movement.getChosenElement();
        boolean result = true ;
        Box baseBox = chosenBoxes.get(0);
        for (int i = 1 ; i < chosenBoxes.size(); i++){
            if (chosenBoxes.get(i).getRaw() != baseBox.getRaw()){
                result = false;
                break;
            }
        }
        return result;
    }
}
