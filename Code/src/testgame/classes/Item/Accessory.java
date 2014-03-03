package testgame.classes.Item;

public class Accessory extends Item{
	
	protected  int HP;
	protected  int HPregen;
	protected  int MP;
	protected  int MPregen;
	protected  int power;
	protected  int endurance;
	protected  int indexShield;
	protected  float chance;
	protected  int velocity;

	public int getHP() {
		return HP;
	}
	public int getHPregen() {
		return HPregen;
	}
	public int getMP() {
		return MP;
	}
	public int getMPregen() {
		return MPregen;
	}
	public int getPower() {
		return power;
	}
	public int getEndurance() {
		return endurance;
	}
	public int indexShield() {
		return indexShield;
	}
	public float getChance() {
		return chance;
	}
	public int getVelocity() {
		return velocity;
	}

	
	public Accessory(String name, String description, int levelRequirement
			, int indexShield, int endurance,  int HP, int MP, float chance) {
		super(name, description, levelRequirement);
		this.indexShield=indexShield;
		this.endurance=endurance;
		this.HP=HP;
		this.MP=MP;
		this.chance=chance;
	}


}
