package testgame.classes.Item;

public class Consumable {
	
	private int addHP;
	private int addMP;
	
	public int getAddHP() {
		return addHP;
	}
	public int getAddMP() {
		return addMP;
	}
	
	public Consumable() {
		super();
		addHP=0;
		addMP=0;
	}

}
