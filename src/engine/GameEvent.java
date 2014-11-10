package engine;

/**
 * This class will define the handlers for the action classes and 
 * execute the corresponding sequence of updates based on actions.
 * 
 * Can call methods to change Sprite state, Level state, CameraView state...
 * 
 * 
 * @author Will Chang
 *
 */


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

public interface GameEvent {
    /**
     * Will execute this Event resulting from applying an Action.
     * @param action
     */
    public abstract void execute ();
    
}
