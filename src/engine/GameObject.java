package engine;

import java.util.ArrayList;
import java.util.List;

import engine.sprite.components.SpriteComponent;

/**
 * Abstract Class representing all game objects
 * @author Will Chang
 * @author Arihant Jain
 *
 */

public abstract class GameObject {
    
    protected List<SpriteComponent> myComponents;
    
    public GameObject() {
    	this(new ArrayList<SpriteComponent>());
    }
    public GameObject(List<SpriteComponent> components) {
    	myComponents = components;
    }
    
    

}
