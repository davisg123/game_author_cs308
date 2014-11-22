package engine.actions;

import engine.gameObject.GameObject;
import engine.level.Level;

public abstract class InitializationAction implements Action {

    protected GameObject myGameObject;
    protected Level myLevel;
    
    public InitializationAction (GameObject object, Level level) {
       myGameObject = object;
       myLevel = level;
    }
    
    @Override
    public void execute () {
        initialize();
    }
    
    protected abstract void initialize ();

}
