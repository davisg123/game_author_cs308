package authoring.model.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import data.Observable;

/**
 * General Collection is the abstract superclass for all collections held in the game. Uses generics to share common behavior.
 * @author Arjun Jain
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 *
 *
 * @param <T> The generic type of object we want to make a collection of.
 */
public abstract class GeneralCollection<T> extends Observable implements Iterable<T> {
	
	//it can be protected so that all subclasses can access it, tradeoff for repeated code reduction
	protected List<T> myObjects;

	public GeneralCollection(){
		myObjects = new ArrayList<T>();
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return myObjects.iterator();
	}
	
	public T get(int i){
		return myObjects.get(i);
	}
	
	public boolean remove(T a){
		return myObjects.remove(a);
	}
	
	public void add(T a){
		myObjects.add(a);
		setChanged();
		notifyObservers(a);
	}
	
	public void addAll(GeneralCollection<T> collection){
	    myObjects.addAll(collection.myObjects);
	}
	
	public String toString(){
		return myObjects.toString();
	}
	
	public int getSize(){
		return myObjects.size();
	}
	
}
