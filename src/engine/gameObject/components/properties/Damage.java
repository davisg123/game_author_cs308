package engine.gameObject.components.properties;

public class Damage extends DoubleStatsProperty implements IProperty {

    private double myDamage;

    public Damage () {
        super.myDouble
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
        return new Damage(myDamage);
    }

    public void decreaseDamage(double val){
        myDamage-= val;
    }
    
    public void increaseDamage(double val){
        myDamage += val;
    }
    

}
