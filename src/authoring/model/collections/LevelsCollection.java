package authoring.model.collections;
import engine.conditions.Condition;
import engine.level.Level;

public class LevelsCollection extends GeneralCollection<Level>{
	
	@Override
	public void add(Level a){
		myObjects.add(a);
		setChanged();
		notifyObservers(this);
	}
	
    public void removeByID(String id){
    	for(Level l : this.myObjects){
    		if(l.getIdentifier().getUniqueId().equals(id)){
    			this.myObjects.remove(l);
    			break;
    		}
    	}
    	setChanged();
    	notifyObservers(this);
    }
	
}
