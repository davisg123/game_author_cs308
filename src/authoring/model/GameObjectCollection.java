package authoring.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import engine.gameObject.GameObject;

public abstract class GameObjectCollection extends Observable implements Iterable<GameObject>{
	
	private List<GameObject> myGameObjects;

	public GameObjectCollection(){
		myGameObjects = new ArrayList<GameObject>();
	}
	
	@Override
	public Iterator<GameObject> iterator() {
		return myGameObjects.iterator();
	}
	
	public Object get(int i){
		return myGameObjects.get(i);
	}
	
	public void remove(int i){
		myGameObjects.remove(i);
	}
}
