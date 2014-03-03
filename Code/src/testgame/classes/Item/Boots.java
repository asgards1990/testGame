package testgame.classes.Item;

public class Boots extends Item {

	private int velocity;
	private int indexShield;
	private int endurance;
	private int HP;
	private int MP;
	private float chance;
	
	public int getVelocity() {
		return velocity;
	}
	public int getIndexShield() {
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
		
	public Boots(String name, String description, int levelRequirement
			, int velocity, int indexShield, int endurance,  int HP, int MP, float chance) {
		super(name, description, levelRequirement);
		this.velocity=velocity;
		this.indexShield=indexShield;
		this.endurance=endurance;
		this.HP=HP;
		this.MP=MP;
		this.chance=chance;

	}
}
