package engine.actions.componentsactions;

import java.util.List;
import engine.gameObject.Identifier;

public class ChangeComponentString extends ChangeComponentAction{

    private String myString;

    public ChangeComponentString (List<Identifier> ids, String value, Identifier componentID) {
        super(ids, componentID);
        myString = value;
        // TODO Auto-generated constructor stub
    }

}
