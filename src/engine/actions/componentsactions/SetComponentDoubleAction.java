package engine.actions.componentsactions;

import java.util.List;
import engine.gameObject.Identifier;

public class SetComponentDoubleAction extends ChangeComponentAction{
    private double myValue;
    public SetComponentDoubleAction (List<Identifier> ids, double value, Identifier componentID) {
        super(ids, componentID);
        myValue = value;
        // TODO Auto-generated constructor stub
    }

}
