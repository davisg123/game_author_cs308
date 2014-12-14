package engine.conditions;

import java.util.ArrayList;
import java.util.List;

import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.actions.PhysicsTypeAction;
import engine.actions.TranslateTypeAction;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

/**
 * root class for conditions, or the event that triggers actions
 * 
 * @author Davis
 *
 */

public abstract class Condition implements Identifiable, Initializable{

    protected List<Action> myActions = new ArrayList<Action>();
    private Boolean myEnabled;
    protected transient GameManager myGameManager;
    protected Identifier myId;
    
    public Condition(List<Action> actions){
        myActions = actions;
        myEnabled = true;
    }
    
    public List<Action> getActions(){
        return myActions;
    }
    
    public void setEnabled(Boolean enabled){
        myEnabled = enabled;
    }
    
    public boolean isEnabled(){
        return myEnabled;
    }
    
    
    /**
     * method to call for executing the associated action/s
     */
    protected abstract void executeActions();
    
    /**
     * method for children to respond to a frame elapsing
     */
    protected abstract void respondToFrameElapsed();
    
    /**
     * method to call to increment the frame counter for conditions that are frame based
     */
    public void frameElapsed(){
        if (myEnabled){
            respondToFrameElapsed();
        }
    }
    
    
    @Override
    public void setIdentifier (Identifier myId) {
        this.myId = myId;
    }

    @Override
    public Identifier getIdentifier () {
        return myId;
    }
    
    @Override
    public void initialize (GameManager manager) {
        myGameManager = manager;
        initializeActions(manager);
    }
    
    protected void initializeActions(GameManager manager){
        if (myActions != null){
            for (Action a : myActions){
                a.initialize(manager);
            }
        }
    }

    protected GameManager getGameManager () {
        return myGameManager;
    }
    
    public void addAction(Action a){
    	myActions.add(a); 
    }
    
    
}
