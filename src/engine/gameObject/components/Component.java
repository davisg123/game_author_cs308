package engine.gameObject.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.IEnabled;
import engine.gameObject.Identifier;
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


public abstract class Component implements IEnabled {
    protected String myID;
    
    //Not sure if it should be included in constructor but we might need to know if this component is enabled or not.
    protected Boolean enabled;
    // Probably will create a Properties files with types of Components
    
    /**
     * Constructors
     */
    public Component () {
        this("");
    }
    public Component (String id){
        myID = id;
    }


    public abstract void update(GameObject object);

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }
    
//    protected List<IProperty> copyProperties(){
//    	List<IProperty> clonesOfProperties = new ArrayList<IProperty>();
//    	for (IProperty prop: myProperties){
//    		clonesOfProperties.add(prop.getClone());
//    	}
//    	return clonesOfProperties; 
//    }
    
    public abstract Component getClone();

    public String getID () {
        // TODO Auto-generated method stub
        return myID;
    } 
    
    public abstract String getStringValue();
    
    public abstract void setStringValue(String val);
    
    public abstract double getDoubleValue();
    
    public abstract void setDoubleValue(double val);
}
