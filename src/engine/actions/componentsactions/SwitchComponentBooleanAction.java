package engine.actions.componentsactions;

import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class SwitchComponentBooleanAction extends ChangeComponentAction {



    public SwitchComponentBooleanAction (List<Identifier> ids, Identifier componentID) {
        super(ids, componentID);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        for (GameObject object: myGameObjects){
            //use method to get component from component id
            //use value to update object's component
            if (super.myObjectIDs.contains(object.getIdentifier())){
                object.getComponent(super.myComponentID).switchBooleanValue();
            }
        }

    }

}
