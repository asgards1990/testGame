package testgame.classes.Item;

public class Helmet extends Item{
	
	private int indexShield;
	private int endurance;
	private int HP;
	private int MP;
	private float chance;
	

	public float getIndexShield() {
		return indexShield;
	}
	public int getEndurance() {
		return endurance;
	}

	public int getHP() {
		return HP;
	}
	public int getMP() {
		return MP;
	}
	public float getChance() {
		return chance;
	}
	
	public Helmet(String name, String description, int levelRequirement
			, int indexShield, int endurance,  int HP, int MP, float chance) {
		super(name, description, levelRequirement);
		this.indexShield=indexShield;
		this.endurance=endurance;
		this.HP=HP;
		this.MP=MP;
		this.chance=chance;
	}
}
