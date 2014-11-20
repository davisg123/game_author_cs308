package engine.actions;

import java.util.List;
import engine.sprite.Sprite;

public abstract class PhysicsAction implements Action {
    
    protected Sprite mySprite;
    protected double myValue;
    public PhysicsAction (Sprite sprite, double value) {
    	mySprite=sprite;
    	myValue=value;
    }
    @Override
    public void execute () {
    	applyPhysics();
    }

    public abstract void applyPhysics();
}
