package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

/**
 * root class for conditions, or the event that triggers actions
 * 
 * @author Davis
 *
 */

public abstract class Condition implements Identifiable, Initializable{

    private List<Action> myActions = new ArrayList<Action>();
    private boolean myEnabled;
    protected Identifier myId;
    private GameManager myGameManager;
    
    public Condition(List<Action> actions){
        myActions = actions;
    }
    
    public List<Action> getActions(){
        return myActions;
    }
    
    public void setEnabled(boolean enabled){
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
     * method to call to increment the frame counter for conditions that are frame based
     */
    public void frameElapsed(){
        //overridden by frame based conditions
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
    }

    protected GameManager getGameManager () {
        return myGameManager;
    }
    
    
}
