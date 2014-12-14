package engine.conditions;

/**
 * @author Abhishek B
 * @author Davis Gossage
 * @author Safkat Islam
 */
import java.util.ArrayList;
import java.util.List;

import engine.actions.Action;
import javafx.scene.input.KeyCode;

public class ButtonPressCondition extends Condition {
    private List<KeyCode> myKeyList;
    private List<Action> myReleaseActions;
    private Double myFramesElapsed;
    private Double myTargetFrameCount;
    private Boolean myKeyRepeats;
    private Boolean myExpired = false;
    private Boolean myButtonActive = false;
    
    

    public ButtonPressCondition (List<Action> onPressActions, List<KeyCode> keyList, Double frameCount, Boolean keyRepeats) {
        super(onPressActions);
        myTargetFrameCount = frameCount;
        myKeyRepeats = keyRepeats;
        myKeyList = keyList;
        //we want the button to execute the first frame, then frames elapsed will be set to 0
        myFramesElapsed = 1000.0;
    }
    
    public void setOnReleaseActions(List<Action> onReleaseActions){
        myReleaseActions = onReleaseActions;
    }
    
    public String getKeyIdentifier() {
    	return myId.getUniqueId();
    }
    
    public List<KeyCode> getKeyList()
    {
    	return myKeyList;
    }
    
    public void addKey(KeyCode kc)
    {
    	if(!myKeyList.contains(kc))
    	{
    		myKeyList.add(kc);
    	}    	
    }
    
    public void removeKey(KeyCode kc){
    	myKeyList.remove(kc);
    }
    
    public void setKeyIdentifier(String id)
    {
    	myId.setUniqueId(id);
    }

    @Override
    protected void executeActions () {
    	boolean shouldExecute = false;
    	for (KeyCode myKey : myKeyList){
            if (ButtonConditionManager.getInstance().keyIsActive(myKey)){
                shouldExecute = true;
            }
    	}
        myFramesElapsed += 1;
    	if (shouldExecute){
    	    myButtonActive = true;
    	    if (!myExpired && myFramesElapsed >= myTargetFrameCount){
    	        myExpired = !myKeyRepeats;
    	        myFramesElapsed = 0.0;
                for (Action a : getActions()){
                    a.execute();
                }
    	    }
    	}
    	else{
    	    if (myButtonActive){
    	        myButtonActive = false;
    	        if (myReleaseActions != null){
    	            for (Action a: myReleaseActions){
    	                a.execute();
    	            }
    	        }

    	    }
    	    myButtonActive = false;
    	}
    }
    
    @Override
    public void frameElapsed () {
        executeActions();
    }
}
