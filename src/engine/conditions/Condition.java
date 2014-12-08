package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.actions.TranslateAction;
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
    private boolean myEnabled;
    private Identifier myId;
    protected transient GameManager myGameManager;
    
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
        initializeActions(manager);
    }
    
    private void initializeActions(GameManager manager){
        if (myActions != null){
            for (Action a : myActions){
                //TODO: expand to whatever action class needs initializing
                //TODO: make this code look less like vomit
                if (a instanceof TranslateAction){
                    ((TranslateAction) a).initialize(manager);
                }
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
