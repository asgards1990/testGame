package testgame.classes.Item;

import testgame.classes.StateCombat.StateCombat;

public class Consumable {
	
	private int addHP;
	private int addMP;
	private String description;
	private String removeState;
	private StateCombat addState;
	
	public int getAddHP() {
		return addHP;
	}
	public int getAddMP() {
		return addMP;
	}
	public String getDescription() {
		return description;
	}
	public String getRemoveState() {
		return removeState;
	}
	public StateCombat getAddState() {
		return addState;
	}
	
	public Consumable() {
		super();
		addHP=0;
		addMP=0;
	}

}
