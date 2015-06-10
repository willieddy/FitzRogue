package main.Hero;

public class Peasant extends Hero {

    public static final int INITIAL_HP = 10;
    public static final int INITIAL_HP_REGEN = 20;
    public static final int INITIAL_STR = 1;
    public static final int INITIAL_LUCK = 1;
    public static final int INITIAL_INT = 1;
    public static final int INITIAL_MGK = 0;
    public static final int INITIAL_MGK_REGEN = 100;

    public Peasant() {
        super();
        hp = INITIAL_HP;
        hpRegen = INITIAL_HP_REGEN;
        str = INITIAL_STR;
        luck = INITIAL_LUCK;
        intel = INITIAL_INT;
        mgk = INITIAL_MGK;
        mgkRegen = INITIAL_MGK_REGEN;
    }
}
