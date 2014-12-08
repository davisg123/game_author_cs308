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

public class ButtonCondition extends Condition {
    private List<KeyCode> myKeyList;
    

    public ButtonCondition (List<Action> actions, List<KeyCode> keyList) {
        super(actions);
        myKeyList = keyList;
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
    	if (shouldExecute){
    		for (Action a : getActions()){
                a.execute();
            }
    	}
    }
    
    @Override
    public void frameElapsed () {
        executeActions();
    }
}
