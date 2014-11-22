package authoring.model.collections;


import engine.gameObject.GameObject;

public class GameObjectsCollection extends GeneralCollection<GameObject>{
	
	public void addGameObject(GameObject g){
		myObjects.add(g);
		setChanged();
		notifyObservers(g);
	}
	
}
