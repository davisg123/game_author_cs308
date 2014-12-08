package engine.actions.componentsactions;

import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class SetComponentStringIDAction extends ChangeComponentIDAction{

    private String myString;

    public SetComponentStringIDAction (List<Identifier> ids, String value, Identifier componentID) {
        super(ids, componentID);
        myString = value;
        // TODO Auto-generated constructor stub
    }
    
    public void execute() {
        // TODO Auto-generated method stub
        for (GameObject object: myGameObjects){
                //use method to get component from component id
                //use value to update object's component
           
               if (super.myObjectIDs.contains(object.getIdentifier())){
                    object.getComponent(super.myComponentID).setStringValue(myString);
                }
        
                
        }
        
}

}
