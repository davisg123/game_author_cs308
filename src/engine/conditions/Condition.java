package engine.conditions;

/**
 * root class for conditions, or the event that triggers actions
 * 
 * @author Davis
 *
 */

public abstract class Condition {
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
