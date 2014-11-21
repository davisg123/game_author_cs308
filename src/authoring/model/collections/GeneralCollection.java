package authoring.model.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

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
	
	public void remove(T a){
		myObjects.remove(a);
	}
	
	public void add(T a){
		myObjects.add(a);
	}

}
