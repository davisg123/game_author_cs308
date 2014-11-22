package authoring.model.collections;

public class ImagesCollection extends GeneralCollection<String>{

	public void addImage(String s){
		myObjects.add(s);
		setChanged();
		notifyObservers(s);
	}
	
	
	
}
