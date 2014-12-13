package engine.conditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.input.KeyCode;
import engine.actions.Action;

public class ButtonReleaseCondition extends Condition {
    
    private Map<KeyCode,Boolean> myKeyMap;

    public ButtonReleaseCondition (List<Action> onReleaseActions, List<KeyCode> keyList) {
        super(onReleaseActions);
        myKeyMap = new HashMap<KeyCode,Boolean>();
        for (KeyCode myKey : keyList){
            myKeyMap.put(myKey, Boolean.FALSE);
        }
    }

    @Override
    protected void executeActions () {
        //TODO: think more about the logic of managing the release of multiple keys
        //probably need to turn this into a map
        for (KeyCode myKey : myKeyMap.keySet()){
            if (ButtonConditionManager.getInstance().keyIsActive(myKey)){
                myKeyMap.put(myKey, Boolean.TRUE);
            }
            else if (myKeyMap.get(myKey) && !ButtonConditionManager.getInstance().keyIsActive(myKey)){
                //the key was pressed, now it's not
                for (Action a : getActions()){
                    a.execute();
                }
                myKeyMap.put(myKey, Boolean.FALSE);
            }
        }
    }
    
    @Override
    public void frameElapsed () {
        executeActions();
    }
    
    public String getKeyIdentifier() {
        return myId.getUniqueId();
    }
    
    public List<KeyCode> getKeyList()
    {
        List<KeyCode> generatedKeyCodeList = new ArrayList<KeyCode>();
        for (KeyCode kc : myKeyMap.keySet()){
            generatedKeyCodeList.add(kc);
        }
        return generatedKeyCodeList;
    }
    
    public void addKey(KeyCode kc)
    {
        myKeyMap.put(kc, Boolean.FALSE);
    }
    
    public void removeKey(KeyCode kc){
        myKeyMap.remove(kc);
    }
    
    public void setKeyIdentifier(String id)
    {
        myId.setUniqueId(id);
    }

}
