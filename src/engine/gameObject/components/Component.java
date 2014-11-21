package engine.gameObject.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.components.properties.IProperty;

/**
 * Components of the GameObject Class
 * @author Will Chang
 * @author Arihant Jain
 *
 */

//Alternate design, instead of using Properties with the components,
//Give everything an id, and put properties 
//Just make everything an individual component... would solve search issues?...


public abstract class Component implements Iterable<IProperty> {
    protected List<IProperty> myProperties;
    
    //Not sure if it should be included in constructor but we might need to know if this component is enabled or not.
    protected Boolean enabled;
    // Propbably will create a Properties files with types of Components
    // 
    
    /**
     * Constructors
     */
    public Component () {
        this(new ArrayList<IProperty>());
    }

    public Component (List<IProperty> properties){
        myProperties = properties;
    }

    /**
     * Returns an iterator for properties
     * @return Iterator
     */
    public Iterator <IProperty> iterator () {
        return myProperties.iterator();
    }

    
    /**
     * Adds property to Component
     * @param property
     */
    public void addProperty(IProperty property){
        myProperties.add(property);
    }
    
    
    /**
     * Removes property from Properties List
     * @param property
     */
    public void removeProperty(IProperty property){
        myProperties.remove(property);
    }

  
    
    /**
     * updates all properties of Components
     */
    public void update(){
        for(IProperty property : myProperties) {
            //property.update(this); Should include current Component?... 
            //update methods should be specific to each component...
            property.update();
        }
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
