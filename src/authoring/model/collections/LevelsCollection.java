package authoring.model.collections;
import engine.level.Level;

public class LevelsCollection extends GeneralCollection<Level>{
	
	
	public void add(Level l){
		myObjects.add(l);
		setChanged();
		notifyObservers(l);
	}
}
