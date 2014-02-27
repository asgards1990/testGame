package testgame.classes.Character;

import java.util.ArrayList;

import tesstgame.classes.State.State;
import testgame.classes.Spell.Spell;

public class Character {
	
	protected String name;
	protected  int level;
	protected  int HP;
	protected  int MP;
	protected  int POW;
	protected  int END;
	protected  float SHI;
	protected  float CHA;
	protected  int VEL;
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
	public int getPOW() {
		return POW;
	}
	public int getEND() {
		return END;
	}
	public float getSHI() {
		return SHI;
	}
	public float getCHA() {
		return CHA;
	}
	public float getVEL() {
		return VEL;
	}
	
	public Character(){
		this.name="inconnu";
		this.level=1;
		this.HP=100;
		this.MP=50;
		this.END=25;
		this.SHI=10;
		this.CHA=5;
		this.VEL=20;
		this.listOfSpells=null;
		this.listOfStates=null;
	}
	
	public Character(String name){
		this.name=name;
		this.level=1;
		this.HP=100;
		this.MP=50;
		this.END=25;
		this.SHI=10;
		this.CHA=5;
		this.VEL=20;
		this.listOfSpells=null;
		this.listOfStates=null;
		
	}
	
	public Character(String name, int level, int HP, int MP, int POW, int END, float SHI, float CHA, int VEL, ArrayList<Spell>
			listOfSpells,ArrayList<State> listOfStates) {
		this.name=name;
		this.level=level;
		this.HP=HP;
		this.MP=MP;
		this.END=END;
		this.SHI=SHI;
		this.CHA=CHA;
		this.VEL=VEL;
		this.listOfSpells=listOfSpells;
		this.listOfStates=listOfStates;
	}


}

