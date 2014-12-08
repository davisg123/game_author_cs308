package engine.gameObject.components;

import java.util.ArrayList;

public class Health extends Component {
	
	private double myHealth;
	
	public Health (double health) {
		myHealth = health;
		
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

	
	
	
	
	
}
