package main.ai;

import main.creature.CreatureEnum;
import main.creature.DirectionEnum;

public abstract class CreatureAi {

    public CreatureAi() {

    }

    public CreatureAi(CreatureEnum creatureEnum) {

    }

    public abstract DirectionEnum onUpdate();

    protected DirectionEnum randomMove() {
        switch((int) Math.ceil(Math.random() * 10)) {
            case 1: return DirectionEnum.UP;
            case 2: return DirectionEnum.DOWN;
            case 3: return DirectionEnum.LEFT;
            case 4: return DirectionEnum.RIGHT;
            case 5: return DirectionEnum.TOP_LEFT;
            case 6: return DirectionEnum.TOP_RIGHT;
            case 7: return DirectionEnum.BOTTOM_LEFT;
            case 8: return DirectionEnum.BOTTOM_RIGHT;
            default: return DirectionEnum.STAND_STILL;
        }
    }
}
