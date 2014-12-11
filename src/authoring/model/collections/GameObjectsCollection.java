package authoring.model.collections;


import java.util.ArrayList;
import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class GameObjectsCollection extends GeneralCollection<GameObject>{
	
	public GameObjectsCollection(){
		super();
	}
	
	public GameObjectsCollection(GameObjectsCollection collection){
		for(GameObject t : collection){
			myObjects.add(new GameObject(t));
		}
	}
	
	public void addGameObject(GameObject g){
		myObjects.add(g);
		setChanged();
		notifyObservers(g);
	}
	
	public List<Identifier> getIdentifierList(){
	    ArrayList<Identifier> IdList = new ArrayList<Identifier>();
	    for (GameObject g : this){
	        IdList.add(g.getIdentifier());
	    }
	    return IdList;
	}
	

	
	
}
