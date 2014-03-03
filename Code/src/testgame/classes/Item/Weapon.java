package testgame.classes.Item;

public class Weapon extends Item{
	
	private int power;
	private int endurance;
	private int HP;
	private int MP;
	private float chance;
	private float velocity;
	private float lifesteal;
	

	public int getPower() {
		return power;
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
	public float getVelocity() {
		return velocity;
	}
	
	public Weapon(String name, String description, int levelRequirement
			, int power, int endurance,  int HP, int MP, float chance, 
			float velocity, float lifesteal) {
		super(name, description, levelRequirement);
		this.power=power;
		this.endurance=endurance;
		this.HP=HP;
		this.MP=MP;
		this.chance=chance;
		this.velocity=velocity;
		this.lifesteal=lifesteal;
	}
	

}
