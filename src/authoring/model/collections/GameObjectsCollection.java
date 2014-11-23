package authoring.model.collections;


import java.util.ArrayList;
import java.util.List;

import engine.gameObject.GameObject;

public class GameObjectsCollection extends GeneralCollection<GameObject>{
	
	public void addGameObject(GameObject g){
		myObjects.add(g);
		setChanged();
		notifyObservers(g);
	}
	
//	public void clear(){
//		myObjects = new ArrayList<GameObject>();
//	}
}
