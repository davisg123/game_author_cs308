package engine.gameObject.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.components.properties.IProperty;

/**
 * Components of the Sprite Class
 * @author Will Chang
 * @author Arihant Jain
 *
 */

//Alternate design, instead of using Properties with the components,
//Give everything an id, and put components in a map, or put them in a manager?
//Just make everything an individual component... would solve search issues?...


public abstract class Component implements Iterable<IProperty> {
    protected List<IProperty> myProperties;

    public Component () {
        this(new ArrayList<IProperty>());
    }

    public Component (List<IProperty> properties){
        myProperties = properties;
    }

    public Iterator <IProperty> iterator () {
        return myProperties.iterator();
    }

    public void addProperty(IProperty property){
        myProperties.add(property);
    }
    
    public void removeProperty(IProperty property){
        myProperties.remove(property);
    }

    public abstract void update();


}
