package engine.actions;

import java.util.List;
import engine.gameObject.GameObject;

public abstract class PhysicsAction implements Action, Initializable {
    
    protected GameObject mySprite;
    protected double myValue;
    public PhysicsAction (GameObject sprite, double value) {
    	mySprite=sprite;
    	myValue=value;
    }
    @Override
    public void execute () {
    	applyPhysics();
    }

    public abstract void applyPhysics();
}
