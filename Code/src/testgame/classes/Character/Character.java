package testgame.classes.Character;

import java.util.ArrayList;

import testgame.classes.Spell.Spell;
import testgame.classes.State.State;

public class Character {
	
	protected String name;
	protected  int level;
	protected  int HP;
	protected  int MP;
	protected  int power;
	protected  int endurance;
	protected  int indexShield;
	protected  float chance;
	protected  int velocity;
	protected ArrayList<Spell> listOfSpells;
	protected ArrayList<State> listOfStates;


	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public int getHP() {
		return HP;
	}
	public int getMP() {
		return MP;
	}
	public int getPower() {
		return power;
	}
	public int getEndurance() {
		return endurance;
	}
	public int getIndexShield() {
		return indexShield;
	}
	public float getChance() {
		return chance;
	}
	public float getVelocity() {
		return velocity;
	}
	
	public Character(){
		this.name="inconnu";
		this.level=1;
		this.HP=100;
		this.MP=50;
		this.endurance=25;
		this.indexShield=10;
		this.chance=5;
		this.velocity=20;
		this.listOfSpells=null;
		this.listOfStates=null;
	}
	
	public  Character(String name){
		this.name=name;
		this.level=1;
		this.HP=100;
		this.MP=50;
		this.endurance=25;
		this.indexShield=10;
		this.chance=5;
		this.velocity=20;
		this.listOfSpells=null;
		this.listOfStates=null;
		
	}
	
	public Character(String name, int level, int HP, int MP, int power, int endurance, int indexShield, float chance, int velocity, ArrayList<Spell>
			listOfSpells,ArrayList<State> listOfStates) {
		this.name=name;
		this.level=level;
		this.HP=HP;
		this.MP=MP;
		this.power=power;
		this.endurance=endurance;
		this.indexShield=indexShield;
		this.chance=chance;
		this.velocity=velocity;
		this.listOfSpells=listOfSpells;
		this.listOfStates=listOfStates;
	}


}

