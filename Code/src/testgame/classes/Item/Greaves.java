package testgame.classes.Item;

public class Greaves extends Item{
	
	private int indexShield;
	private int endurance;
	private int HP;
	private int MP;
	private float chance;
	private float damageReturn;
	

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
	
	public Greaves(String name, String description, int levelRequirement
			, int indexShield, int endurance,  int HP, int MP, float chance, 
			float damageReturn) {
		super(name, description, levelRequirement);
		this.indexShield=indexShield;
		this.endurance=endurance;
		this.HP=HP;
		this.MP=MP;
		this.chance=chance;
		this.damageReturn=damageReturn;
	}


}
