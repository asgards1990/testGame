package testgame.classes.Character;

import java.util.ArrayList;

import testgame.classes.Item.*;
import testgame.classes.Spell.Spell;
import testgame.classes.StateCombat.StateCombat;

public class Hero extends Character {
	
	private float shieldCombat;
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

	
	public float getShieldCombat() {
		return shieldCombat;
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
			ArrayList<Spell> listOfSpells, ArrayList<StateCombat> listOfStates, int expCurrent, Weapon weapon, Armor armor, 
			Greaves greaves, Accessory accessory, Boots boots, Gloves gloves, Helmet helmet, int Money, 
			ArrayList<Item> inventory) {
		
		super(name, level, HP, MP, power, endurance, indexShield, chance, velocity,listOfSpells,listOfStates); 
		this.shieldCombat=this.getShieldTotal();
		this.expCurrent=expCurrent;
		this.weapon=weapon;
		this.armor=armor;
		this.greaves=greaves;
		this.accessory=accessory;
		this.boots=boots;
		this.gloves=gloves;
		this.helmet=helmet;
		this.money=money;
		this.inventory=inventory;
		this.HPCombat=this.getHPTotal();
		this.MPCombat=this.getMPTotal();
	}

	public int getHPTotal() {
		return HP+weapon.getHP()+weapon.getEndurance()*5+armor.getHP()+greaves.getHP()
				+accessory.getHP()+boots.getHP()+gloves.getHP()+helmet.getHP()+this.getEnduranceTotal()*5;
	}
	public int getMPTotal() {
		return MP+weapon.getMP()+armor.getMP()+greaves.getMP()+accessory.getMP()+boots.getMP()+gloves.getMP()+helmet.getMP();
	}
	public int getPowerTotal() {
		return power+weapon.getPower()+accessory.getPower();
	}
	public int getEnduranceTotal() {
		return endurance+weapon.getEndurance()+armor.getEndurance()+greaves.getEndurance()+accessory.getEndurance()+
				boots.getEndurance()+gloves.getEndurance()+helmet.getEndurance();
	}
	public int getIndexShieldTotal() {
		return  indexShield+armor.getIndexShield()+greaves.getIndexShield()+boots.getIndexShield()+gloves.getIndexShield()
				+helmet.getIndexShield();
	}
	public float getChanceTotal() {
		return chance+weapon.getChance()+armor.getChance()+greaves.getChance()+accessory.getChance()+boots.getChance()+
				gloves.getChance()+helmet.getChance();
	}
	public int getVelocityTotal() {
		return velocity+boots.getVelocity();
	}
	public float getShieldTotal(){
		double d = (double) this.getIndexShieldTotal();
		return (int)(Math.pow(Math.log(d),2.5)*100)/100;
	}
	
	public void useItem(Consumable consumable) {
		this.HPCombat=Math.min(this.getHPTotal(),this.HPCombat+consumable.getAddHP());
		this.MPCombat=Math.min(this.getMPTotal(),this.MPCombat+consumable.getAddMP());
		String removeState=consumable.getRemoveState();
		StateCombat addState=consumable.getAddState();
		if (!(removeState.equals(null))) {
			for(StateCombat event : listOfStates) {
				if (removeState.equals(event.getName())) {
					this.deleteStateCombat(event);
				}
			}
		}
		if (!(addState.equals(null))) {
			StateCombat newState= addState;
			newState.setTours();
			this.listOfStates.add(newState);
		}
	}	
	public boolean attack(Character target) {
		boolean isPowerState = false;
		boolean isChanceState = false;
		StateCombat statePower = null;
		StateCombat stateChance = null;
		double powerMultiplier = 1;
		int damage = 0;
		for (StateCombat event : listOfStates) {
			if (event.getName()=="power"&&event.getTours()>1) {
				statePower=event;
				isPowerState=true;
				event.toursDown();
			}
			else if (event.getName()=="power"&&event.getTours()==1) {
				statePower=event;
				isPowerState=true;
				this.deleteStateCombat(statePower);
			}		
			else if (event.getName()=="chance"&&event.getTours()>1) {
				stateChance=event;
				isPowerState=true;
				event.toursDown();
			}
			else if (event.getName()=="chance"&&event.getTours()==1) {
				statePower=event;
				isPowerState=true;
				this.deleteStateCombat(stateChance);
			}		
		}
		if (isChanceState==false) {
			powerMultiplier=+Math.random()*10-5+this.getChanceTotal()/20;
		}
		else {
			powerMultiplier=+Math.random()*10-5+this.getChanceTotal()/20*stateChance.getNumberEffect();
		}
		
		if (isPowerState==false) {		
			damage = (int) (this.getPowerTotal()*powerMultiplier);
		}
		else {
			damage = (int) (this.getPowerTotal()*statePower.getNumberEffect()*powerMultiplier);
		}
				
		if (damage>=target.HPCombat) {
			target.setHPCombat(1);
			return true;				
		}
		else {
			target.setHPCombat(target.getHPCombat()-damage);
			return false;
		}
	}
	
	



}
