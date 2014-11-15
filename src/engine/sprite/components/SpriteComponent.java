package engine.sprite.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.sprite.components.properties.IProperty;

/**
 * Components of the Sprite Class
 * @author Will Chang
 * @author Arihant Jain
 *
 */

//Alternate design, instead of using Properties with the components,
//Give everything an id, and put components in a map, or put them in a manager?
//Just make everything an individual component... would solve search issues?...


public abstract class SpriteComponent implements Iterable<IProperty> {
    protected List<IProperty> myProperties;

    public SpriteComponent () {
        this(new ArrayList<IProperty>());
    }

    public SpriteComponent (List<IProperty> properties){
        myProperties = properties;
    }

    public Iterator <IProperty> iterator () {
        return myProperties.iterator();
    }

    public abstract void addProperty(IProperty property); 
    
    public abstract void removeProperty(IProperty property);

    public abstract void update();




}
