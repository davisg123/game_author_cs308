// This entire file is part of my masterpiece.
// Davis Gossage

package engine.conditions;

/**
 * @author Abhishek B
 * @author Davis Gossage
 * @author Safkat Islam
 * 
 * A condition that listens for a button press.
 * Options can be set including repeat delay and non-repeating trigger
 */
import java.util.List;
import engine.actions.Action;
import javafx.scene.input.KeyCode;

public class ButtonPressCondition extends ButtonCondition {
    private List<KeyCode> myKeyList;
    private Double myFramesElapsed;
    private Double myTargetFrameCount;
    private Boolean myKeyRepeats;
    private Boolean myExpired = false;
    
    
    /**
     * constructor for a button press condition
     * 
     * @param onPressActions
     * list of actions to execute when the button is pressed
     * @param keyList
     * 
     * @param frameCount
     * @param keyRepeats
     */
    public ButtonPressCondition (List<Action> onPressActions, List<KeyCode> keyList,
                                 Double frameCount, Boolean keyRepeats) {
        super(onPressActions,keyList);
        myTargetFrameCount = frameCount;
        myKeyRepeats = keyRepeats;
        myKeyList = keyList;
    }

    @Override
    protected void executeActions () {
    	boolean shouldExecute = false;
    	//check if any key in our list of keys to monitor is active
    	for (KeyCode myKey : myKeyList) {
            if (ButtonConditionManager.getInstance().keyIsActive(myKey)) {
                shouldExecute = true;
            }
    	}
    	if (shouldExecute) {
    	    //check that the condition has not expired
    	    //and that we're not in the timeout window UNLESS this is the first time we're executing
    	    if (!myExpired && (myFramesElapsed >= myTargetFrameCount || myFramesElapsed == null)) {
    	        myExpired = !myKeyRepeats;
    	        myFramesElapsed = 0.0;
                for (Action a : getActions()) {
                    a.execute();
                }
    	    }
    	}
        myFramesElapsed += 1;
    }
}
