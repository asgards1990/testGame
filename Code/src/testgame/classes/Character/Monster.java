package testgame.classes.Character;

import java.util.ArrayList;

import testgame.classes.Spell.Spell;
import testgame.classes.State.State;

public class Monster extends Character {
	
	private float shield;
	private int lootExp;
	private int lootMoney;
	private String description;
	private ArrayList<String> dialogues;
	
	public float getShield() {
		return shield;
	}
	public int getLootExp() {
		return lootExp;
	}
	public int getLootMoney() {
		return lootMoney;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<String> getDialogues() {
		return dialogues;
	}
	
	public Monster() {
		super();
		lootExp=1;
		lootMoney=1;
		description="I am a flower";
		dialogues=new ArrayList<String>(){{add("what");add("the");add("fuck");}};
	}
	
	public Monster(String name, int level, int HP, int MP, int power, int endurance, int indexShield, float chance, int velocity, 
			ArrayList<Spell> listOfSpells,ArrayList<State> listOfStates, int lootExp, int lootMoney, String description, 
			ArrayList<String> dialogues) {
		super(name, level, HP, MP, power, endurance, indexShield, chance, velocity,listOfSpells,listOfStates);
		this.shield=shield;//instancier l'indexShield du monstre sur le pourcentage de shield voulu.
		this.lootExp=lootExp;
		this.lootMoney=lootMoney;
		this.description=description;
		this.dialogues=dialogues;
		
	}

	
}
