package engine.gameObject.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.IEnabled;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

/**
 * Components of the GameObject Class
 * @author Will Chang
 * @author Arihant Jain
 *
 */

//Alternate design, instead of using Properties with the components,
//Give everything an id, and put properties 
//Just make everything an individual component... would solve search issues?...


public class Component implements IEnabled,Identifiable {
    protected Identifier myID;
    private double myDoubleValue;
    private String myStringValue;
    private Boolean myBooleanValue;
    //Not sure if it should be included in constructor but we might need to know if this component is enabled or not.
    protected Boolean enabled;
    // Probably will create a Properties files with types of Components
    
    /**
     * Constructors
     */
    public Component(){
        this("");
    }
    public Component (String stringVal){
       this.myStringValue = stringVal;
    }
    public Component(double doubVal){
        this.myDoubleValue = doubVal;
    }
    public Component(boolean boolVal){
        this.myBooleanValue =boolVal;
    }


    public void update(GameObject object){
        
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
    
//    protected List<IProperty> copyProperties(){
//    	List<IProperty> clonesOfProperties = new ArrayList<IProperty>();
//    	for (IProperty prop: myProperties){
//    		clonesOfProperties.add(prop.getClone());
//    	}
//    	return clonesOfProperties; 
//    }
    
    public Component getClone(){
        return null;
        
    }

    public String getID () {
        // TODO Auto-generated method stub
        return myID.getHash();
    } 
    
    public String getStringValue(){
        return myStringValue;
    }
    
    public  void setStringValue(String val){
        myStringValue = val;
    }
    
    public double getDoubleValue(){
       return myDoubleValue;
    }
    
    public void setDoubleValue(double val){
        myDoubleValue = val;
    }
    

    public boolean getBooleanValue(){
       return myBooleanValue;
    }
    
    public void setBooleanValue(boolean val){
        myBooleanValue = val;
    }
    
    public void changeBooleanValue(){
        myBooleanValue = !myBooleanValue;
    }

    public void setIdentifier (Identifier myId){
        myID = myId;   
    }
    public Identifier getIdentifier (){
        return myID;
    }
    
}
