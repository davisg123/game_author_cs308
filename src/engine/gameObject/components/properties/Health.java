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
	
	public void loseHealth(int healthLost){
		myHealth-=healthLost;
	}
	
	public void gainHealth(int healthGain){
		myHealth+=healthGain; 
	}

	@Override
	public IProperty getClone() {
		// TODO Auto-generated method stub
		return new Health(myHealth);
	}
	
	
	
	
}
