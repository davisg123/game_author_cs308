package engine.gameObject.components.properties;

/**
 * Properties of the Components
 * @author ArihantJain
 *
 */

//Alternate design, instead of using Properties with the components,
//Give everything an id, and put components in a map, or put them in a manager?
//Just make everything an individual component... would solve search issues?...
//Is this excessive because components become container classes, and then we have a lot of getters/setters. Additionally, all this does is update. 
public interface IProperty {
    
/**
 * This is updated when Actions are executed.    
 */
	public void update();
	
}
