package engine.gameObject;

public class Identifier {
    private String myType;
    private String myUniqueId;
    
    
    public Identifier (String myType, String myUniqueId) {
        this.myType = myType;
        this.myUniqueId = myUniqueId;
    }
    
    public String getType () {
        return myType;
    }
    
    public void setType (String myType) {
        this.myType = myType;
    }
    
    public String getUniqueId () {
        return myUniqueId;
    }
    
    public void setUniqueId (String myUniqueId) {
        this.myUniqueId = myUniqueId;
    }
    
    public String getHash () {
        return myType+myUniqueId;
    }
    
}
