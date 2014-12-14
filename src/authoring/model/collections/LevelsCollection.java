package authoring.model.collections;
import engine.level.Level;
/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 *
 */
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
