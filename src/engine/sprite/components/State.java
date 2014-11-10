package engine.sprite.components;

/**
 * This Class holds State Information for Sprite;
 * @author Arihant Jain
 * 
 */
public class State {

    private double myHealth;

    public State(int health){
        myHealth = health;

    }

    /**
     * Sets Player's Health Points
     * 
     * @param h - new Player's Health
     */
    public void setHealth(double h){
        myHealth = h;
    }

    /**
     * returns Player's Health Points
     * 
     * @return double - Player's Health
     */
    public double getHealth(){
        return myHealth;
    }
}