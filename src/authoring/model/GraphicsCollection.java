package authoring.model;

public class GraphicsCollection extends GeneralCollection<String>{

	public void addImage(String s){
		myObjects.add(s);
		setChanged();
		notifyObservers(s);
	}
	
	
	
}
