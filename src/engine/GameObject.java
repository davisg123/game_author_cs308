package engine;

/**
 * Abstract Class representing all game objects
 * @author Will
 *
 */

public abstract class GameObject {
    
    private String myName;
    
    public GameObject(String name) {
        myName = name;
    }
    
    public String getName() {
        return myName;
    }

}
