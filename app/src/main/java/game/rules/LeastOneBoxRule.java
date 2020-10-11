package game.rules;

import game.Movement;

public class LeastOneBoxRule extends Rule implements IRule {
    public LeastOneBoxRule(Movement movement) {
        super(movement);
    }
    public LeastOneBoxRule(){
        super();
    }
    /**
     * This method force user to choose at least one valid box
     * @return true if at leas one box is chosen
     */
    @Override
    public boolean isValid() {
        boolean result = false;
        Movement movement = this.getMovement();
        if (movement.getChosenElement().size() > 0 )
            result = true;
        return result;
    }
    public boolean isValid(Movement movement) {
        boolean result = false;

        if (movement.getChosenElement().size() > 0 )
            result = true;
        return result;
    }

}
