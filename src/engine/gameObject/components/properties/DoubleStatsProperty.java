package engine.gameObject.components.properties;

public class DoubleStatsProperty implements IProperty{
    private double myDoubleProp;
    
    public DoubleStatsProperty(double doubleProp){
        myDoubleProp = doubleProp;
    }
    @Override
    public void update () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public IProperty getClone () {
        // TODO Auto-generated method stub
        return null;
    }

    
    public double getDoubleProp () {
        return myDoubleProp;
    }

    public void setDoubleProp (double doubleVal) {
        this.myDoubleProp = doubleVal;
    }
  
    public void decreaseProp(double doubleVal){
        this.myDoubleProp -= doubleVal;
    }

    public void addProp(double doubleVal){
        this.myDoubleProp += doubleVal;
    }
}
