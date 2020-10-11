package game.rules;

import game.Movement;

public class Rule {
    private Movement movement;
    public Rule(){

    }
    public Rule(Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return movement;
    }
}
