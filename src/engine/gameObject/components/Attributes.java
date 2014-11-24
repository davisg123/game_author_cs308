package engine.gameObject.components;

import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.components.properties.IProperty;

/**
 * This Class holds State Information for Sprite;
 * @author Arihant Jain
 * @author Will Chang
 * 
 */
public class Attributes extends Component{

    
	public Attributes(List<IProperty> properties){
		super(); 
	}
	
    //TODO figure out implementation
    @Override
    public void update (GameObject object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getID () {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Attributes getClone(){
    	List<IProperty> clonesOfProperties = copyProperties(); 
    	return new Attributes(clonesOfProperties);
    }

  
}