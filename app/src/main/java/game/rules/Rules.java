package game.rules;

import game.Movement;

public class Rules {
    private Movement movement;

    public Rules(Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return movement;
    }
}
