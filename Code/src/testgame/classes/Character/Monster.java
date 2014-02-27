package testgame.classes.Character;

import java.util.ArrayList;

import tesstgame.classes.State.State;
import testgame.classes.Spell.Spell;

public class Monster extends Character {
	
	private int lootExp;
	private int lootMoney;
	private String description;
	private ArrayList<String> dialogues;
	
	public Monster() {
		super();
		lootExp=1;
		lootMoney=1;
		description="I am a flower";
		dialogues=new ArrayList<String>(){{add("what");add("the");add("fuck");}};
	}
	
	public Monster(String name, int level, int HP, int MP, int POW, int END, float SHI, float CHA, int VEL, 
			ArrayList<Spell> listOfSpells,ArrayList<State> listOfStates, int lootExp, int lootMoney, String description, ArrayList<String> dialogues) {
		super(name, level, HP, MP, POW, END, SHI, CHA, VEL,listOfSpells,listOfStates);
		this.lootExp=lootExp;
		this.lootMoney=lootMoney;
		this.description=description;
		this.dialogues=dialogues;
		
	}
	
	public ArrayList<String> getDialogues() {
		return dialogues;
	}
	
}
