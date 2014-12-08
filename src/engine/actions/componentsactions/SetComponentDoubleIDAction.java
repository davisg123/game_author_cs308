package engine.actions.componentsactions;

import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class SetComponentDoubleIDAction extends ChangeComponentIDAction{
    private double myValue;
    public SetComponentDoubleIDAction (List<Identifier> ids, double value, Identifier componentID) {
        super(ids, componentID);
        myValue = value;
        // TODO Auto-generated constructor stub
    }
    @Override
    public void execute() {
            // TODO Auto-generated method stub
            for (GameObject object: myGameObjects){
                    //use method to get component from component id
                    //use value to update object's component
               
                   if (super.myObjectIDs.contains(object.getIdentifier())){
                        object.getComponent(super.myComponentID).setDoubleValue(myValue);
                    }
            
                    
            }
            
    }
    

}
