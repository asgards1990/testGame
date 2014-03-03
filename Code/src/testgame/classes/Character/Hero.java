package testgame.classes.Character;

import java.util.ArrayList;

import testgame.classes.Item.*;
import testgame.classes.Spell.Spell;
import testgame.classes.State.State;

public class Hero extends Character {
	
	private float shield;
	private int expCurrent;
	private Weapon weapon;
	private Armor armor;
	private Greaves greaves;
	private Accessory accessory;
	private Boots boots;
	private Gloves gloves;
	private Helmet helmet;
	private int money;
	private ArrayList<Item> inventory;
	
	public float getShield() {
		return shield;
	}
	public int getExpCurrent() {
		return expCurrent;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public Greaves getGreaves() {
		return greaves;
	}
	public Accessory getAccessory() {
		return accessory;
	}
	public Boots getBoots() {
		return boots;
	}
	public Gloves getGloves() {
		return gloves;
	}
	public Helmet getHelmet() {
		return helmet;
	}
	public int getMoney() {
		return money;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public Hero(String name, int level, int HP, int MP, int power, int endurance, int indexShield, float chance, int velocity, 
			ArrayList<Spell> listOfSpells, ArrayList<State> listOfStates, int expCurrent, Weapon weapon, Armor armor, 
			Greaves greaves, Accessory accessory, Boots boots, Gloves gloves, Helmet helmet, int Money, ArrayList<Item> inventory) {
		super(name, level, HP, MP, power, endurance, indexShield, chance, velocity,listOfSpells,listOfStates);
		this.shield=indexShield/200; //to be changed to diminish returns.
		this.expCurrent=expCurrent;
		this.weapon=weapon;
		this.armor=armor;
		this.greaves=greaves;
		this.accessory=accessory;
		this.accessory=accessory;
		this.boots=boots;
		this.gloves=gloves;
		this.helmet=helmet;
		this.money=money;
		this.inventory=inventory;
	}
	

}
