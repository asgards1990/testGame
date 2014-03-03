package testgame.classes.Item;

public class Item {
	protected String name;
	protected String description;
	protected int levelRequirement;
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int levelRequirement() {
		return levelRequirement;
	}
	
	public Item() {
		name="unknown";
		description="this is one big mystery";
		levelRequirement=1;
	}
	
	public Item(String name, String description, int levelRequirement) {
		this.name=name;
		this.description=description;
		this.levelRequirement=levelRequirement;
	}
	
	

}
