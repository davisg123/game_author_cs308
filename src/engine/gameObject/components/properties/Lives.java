package engine.gameObject.components.properties;

public class Lives implements IProperty {
    
    private double myLives;
    private boolean loseLives;
    private boolean gainLives;
    
    public Lives (double lives) {
            myLives = lives;
            
    }
    
    @Override
    public void update() {
            // TODO Auto-generated method stub
            if (loseLives)  {myLives--;}
            else if(gainLives){myLives++;}
            
            
    }

    public double getLives () {
        return myLives;
    }

    public void setLives (double lives) {
        this.myLives = lives;
    }
  
    

}
