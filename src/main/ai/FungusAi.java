package main.ai;

import main.creature.DirectionEnum;

public class FungusAi extends CreatureAi {

    public DirectionEnum onUpdate() {
        return DirectionEnum.STAND_STILL;
    }
}
