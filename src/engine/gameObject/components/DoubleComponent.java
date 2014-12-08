package engine.gameObject.components;

import engine.gameObject.GameObject;
import engine.gameObject.IEnabled;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

public class DoubleComponent extends Component{
    private double myDoubleVal;
    public DoubleComponent(){
      
    }
    
    public DoubleComponent(Identifier id){
        this(id,0);
    }
    public DoubleComponent(Identifier id, double val){
       super.myID = id;
       myDoubleVal = val;
    }
    
    @Override
    public void update (GameObject object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Component getClone () {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    public double getDoubleValue(){
        return myDoubleVal;
    }
    
    public void setDoubleValue(double val){
        myDoubleVal = val;
    }
    @Override
    public String getStringValue () {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setStringValue (String val) {
        // TODO Auto-generated method stub
        
    }

}
