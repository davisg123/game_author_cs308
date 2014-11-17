package authoring.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.GameObject;

public class GameObjectCollection implements Iterable<GameObject>{
	
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
