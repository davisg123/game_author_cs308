package engine.gameObject.components.properties;

import java.util.ArrayList;

public class Health implements IProperty {
	
	private double myHealth;
	
	public Health (double health) {
		myHealth = health;
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public double getHealth() {
		return myHealth;
	}
	
	public void setHeath(double health){
		myHealth = health;	
	}
	
	
}
