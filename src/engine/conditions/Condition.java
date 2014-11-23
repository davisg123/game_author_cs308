package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;

/**
 * root class for conditions, or the event that triggers actions
 * 
 * @author Davis
 *
 */

public abstract class Condition {

    private List<Action> myActions = new ArrayList<Action>();
    private String myID;
    
    public Condition(List<Action> actions, String ID){
        myActions = actions;
        myID = ID;
    }
    
    public List<Action> getActions(){
        return myActions;
    }
    
    public String getID(){
        return myID;
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
}
