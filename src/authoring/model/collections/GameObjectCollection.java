package authoring.model.collections;


import java.util.ArrayList;
import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class GameObjectCollection extends GeneralCollection<GameObject>{
	
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
