package authoring.model;

import java.util.ArrayList;
import java.util.List;

public class GraphicsCollection extends GameObjectCollection{

	private List<String> myImageNames;
	
	public GraphicsCollection(){
		myImageNames = new ArrayList<String>();
	}
	
	
	public void addImage(String s){
		myImageNames.add(s);
		setChanged();
		notifyObservers(s);
	}
	
	
	
}
