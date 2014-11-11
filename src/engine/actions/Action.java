package engine.actions;

/**
 * This interface will define the handlers for the action classes and 
 * execute the corresponding sequence of updates based on actions.
 * 
 * Can call methods to change Sprite state, Level state, CameraView state...
 * 
 * 
 * @author Will Chang
 *
 */

//Temporary implementation, might change it back to an Abstract Class
/*
 * Types of events
 *      - Collision events
 *      - state changes:
 *              - health
 *              - location 
 *              - orientation
 *              - velocity
 *              - images.../display and visibility
 *      - Game Progression Events
 *              - Game Start
 *              - Game End
 *                      - Win/lose
 *              - Levels
 *      - Camera changes...
 */

public interface Action {
    
    /**
     * Will execute the consequences resulting from applying an Action.
     * @param action
     */
    public abstract void execute ();
    
}
