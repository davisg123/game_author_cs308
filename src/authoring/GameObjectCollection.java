package authoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameObjectCollection implements Iterable<Object>{
	
	//Should eventually become List<GameObject>
	private List<Object> myGameObjects;

	public GameObjectCollection(){
		myGameObjects = new ArrayList<Object>();
	}
	
	@Override
	public Iterator<Object> iterator() {
		return myGameObjects.iterator();
	}
	
	public Object get(int i){
		return myGameObjects.get(i);
	}
	
	public void remove(int i){
		myGameObjects.remove(i);
	}
}
