package engine.gameObject.components;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class StringComponent extends Component {
    private String myStringVal;
    public StringComponent(){
        super("");
    }
    public StringComponent (String val){
  
       myStringVal = val;
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

    
    public String getStringValue(){
        return myStringVal;
    }
    
    public void setStringValue(String val){
        myStringVal = val;
    }
   
    @Override
    public double getDoubleValue () {
        // TODO Auto-generated method stub
        return 0;
     
    }
    @Override
    public void setDoubleValue (double val) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void setIdentifier (Identifier myId) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Identifier getIdentifier () {
        // TODO Auto-generated method stub
        return null;
    }
}
