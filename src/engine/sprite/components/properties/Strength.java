package engine.sprite.components.properties;

public class Strength implements IProperty {
    
    private double myStrength;
    
    public Strength (double strength) {
            myStrength = strength;
            
    }
    
    @Override
    public void update() {
            // TODO Auto-generated method stub
            
    }

    public double getStrength() {
            return myStrength;
    }
    
    public void setStrength(double strength){
            myStrength = strength;      
    }
    

}
