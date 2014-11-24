package engine.gameObject.components.properties;

public class Ammunition implements IProperty {
    
    private double myAmmunition;
    
    public Ammunition (double ammunition) {
            myAmmunition = ammunition;
            
    }
    
    public double getAmmunition () {
        return myAmmunition;
    }

    public void setAmmunition (double myAmmo) {
        this.myAmmunition = myAmmo;
    }

    @Override
    public void update() {
            // TODO Auto-generated method stub
            
    }

	@Override
	public IProperty getClone() {
		return new Ammunition(myAmmunition);
	}

    
}
