package engine.gameObject.components.properties;

public class Armor implements IProperty {
    
    private double myArmor;
    
    public Armor (double armor) {
            myArmor = armor;
            
    }
    
    @Override
    public void update() {
            // TODO Auto-generated method stub
            
    }

    public double getArmor () {
        return myArmor;
    }

    public void setArmor (double armor) {
        this.myArmor = armor;
    }

   
    

}
