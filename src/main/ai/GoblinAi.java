package main.ai;

import main.creature.DirectionEnum;

public class GoblinAi extends CreatureAi {

    public DirectionEnum onUpdate() {
        return randomMove();
    }

}
