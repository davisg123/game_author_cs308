package authoring.model.collections;

public class GraphicsCollection extends GeneralCollection<String>{

	public void addImage(String s){
		myObjects.add(s);
		setChanged();
		notifyObservers(s);
	}
	
	
	
}
