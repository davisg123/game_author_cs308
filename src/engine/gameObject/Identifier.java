package engine.gameObject;

import java.util.Random;

public class Identifier {
    private String myType;
    private String myUniqueId;
    private Random r; 
    
    
    public Identifier (String myType, String myUniqueId) {
        this.myType = myType;
        this.myUniqueId = myUniqueId;
    }
    
    public Identifier (Identifier id){
    	r = new Random();
    	myType = id.getType();
    	myUniqueId = id.getUniqueId()+r.nextInt();
    }
    
    public static Identifier valueOf (String descriptor) {
        String[] parts = descriptor.split(",");
        return new Identifier(parts[0],parts[1]);
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
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Identifier)) {
            return false;
        }
        if(this == o) {
            return true;
        }
        Identifier otherID = (Identifier) o;
        return this.getHash().equals(otherID.getHash());
    }

    @Override
    public int hashCode () {
        return myType.hashCode()*myUniqueId.hashCode();
    }
    
}
