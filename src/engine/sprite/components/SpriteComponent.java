package engine.sprite.components;


import java.util.ArrayList;
import java.util.List;

import engine.sprite.components.properties.IProperty;


public abstract class SpriteComponent {
	protected List<IProperty> myProperties;
	
	public SpriteComponent () {
		this(new ArrayList<IProperty>());
	}
	
	public SpriteComponent (List<IProperty> properties){
		myProperties = properties;
	}
	
	public abstract void addProperty(IProperty property) ; 
	
	public abstract void update();
	
	//TODO turn into Iterator;
	public List<IProperty> getProperties() {
		return myProperties;
	}
	
	
	

}
