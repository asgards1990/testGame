package testgame.classes.Character;

import java.util.ArrayList;

import testgame.classes.Spell.Spell;
import testgame.classes.StateCombat.StateCombat;

public class Monster extends Character {
	
	private float shieldCombat;
	private int lootExp;
	private int lootMoney;
	private String description;
	private ArrayList<String> dialogues;
	
	public String getNameTotal() {
		return name;
	}
	public int getHPTotal() {
		return HP;
	}
	public int getMPTotal() {
		return MP;
	}
	public int getPowerTotal() {
		return power;
	}
	public int getEnduranceTotal() {
		return endurance;
	}
	public int getIndexShieldTotal() {
		return indexShield;
	}
	public float getChanceTotal() {
		return chance;
	}
	public int getVelocityTotal() {
		return velocity;
	}
	
	public float getShieldTotal(){
		double d = (double) this.getIndexShieldTotal();
		return (int)(Math.pow(Math.log(d),2.5)*100)/100;
	}
	public float getShieldCombat() {
		return shieldCombat;
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
			ArrayList<Spell> listOfSpells,ArrayList<StateCombat> listOfStates, int lootExp, int lootMoney, String description, 
			ArrayList<String> dialogues) {
		super(name, level, HP, MP, power, endurance, indexShield, chance, velocity,listOfSpells,listOfStates);
		this.shieldCombat=this.getShieldTotal();
		this.lootExp=lootExp;
		this.lootMoney=lootMoney;
		this.description=description;
		this.dialogues=dialogues;
		
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
				
		if (damage>=target.getHPCombat()) {
			target.setHPCombat(1);
			return true;				
		}
		else {
			target.setHPCombat(target.getHPCombat()-damage);
			return false;
		}
	}

	
}
