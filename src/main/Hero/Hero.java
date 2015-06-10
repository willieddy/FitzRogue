package main.Hero;

import java.awt.Color;

public abstract class Hero {
	private int x;
	private int y;

    protected int hp;
    protected int hpRegen;
    protected int str;
    protected int luck;
    protected int intel;
    protected int mgk;
    protected int mgkRegen;
	
	private char glyph;
	private Color color;
    private int HP;
	
	public Hero() {
		glyph = '@';
		color = Color.BLUE;
	}
	
	public char getGlyph() {
		return glyph;
	}
	
	public Color getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpRegen() {
        return hpRegen;
    }

    public void setHpRegen(int hpRegen) {
        this.hpRegen = hpRegen;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getMgk() {
        return mgk;
    }

    public void setMgk(int mgk) {
        this.mgk = mgk;
    }

    public int getMgkRegen() {
        return mgkRegen;
    }

    public void setMgkRegen(int mgkRegen) {
        this.mgkRegen = mgkRegen;
    }
}
