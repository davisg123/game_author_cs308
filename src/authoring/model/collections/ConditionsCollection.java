package authoring.model.collections;

import java.util.ArrayList;
import java.util.List;
import engine.conditions.Condition;
import engine.gameObject.Identifier;

public class ConditionsCollection extends GeneralCollection<Condition> {
	
    public List<Identifier> getIdentifierList(){
        ArrayList<Identifier> IdList = new ArrayList<Identifier>();
        for (Condition c : this){
            IdList.add(c.getIdentifier());
        }
        return IdList;
    }
}
