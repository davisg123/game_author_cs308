package engine.gameObject.components.properties;

public class Damage implements IProperty {

    private double myDamage;

    public Damage () {

    }

    public double getDamage () {
        return myDamage;
    }

    public void setDamage (double damage) {
        this.myDamage = damage;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public IProperty getClone() {
        return new Damage();
    }

    public void decreaseDamage(double val){
        myDamage-= val;
    }
    
    public void increaseDamage(double val){
        myDamage += val;
    }
    

}
