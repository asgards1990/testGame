package testgame.classes.StateCombat;

public class StateCombat {
	
	private String name;
	private String description;
	private float numberEffect;
	private int tours;
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public float getNumberEffect() {
		return numberEffect;
	}
	public int getTours() {
		return tours;
	}
	
	public void toursDown() {
		this.tours=tours-1;
	}
	public void setTours() {
		int random = (int) (Math.random()*3+2);
		this.tours=random;
	}
	
	public StateCombat(String name, String description, float numberEffect, int tours) {
		this.name=name;
		this.description=description;
		this.numberEffect=numberEffect;
		this.tours=tours;
	}
	
	

}
