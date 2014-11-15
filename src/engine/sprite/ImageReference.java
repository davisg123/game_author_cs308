package engine.sprite;

import java.util.List;
import engine.sprite.components.SpriteComponent;
import engine.sprite.components.properties.IProperty;

/**
 * 
 * @author Will
 *
 */

public class ImageReference extends SpriteComponent {
    private List<String> myImagePaths;
    
    public List<String> getImagePaths () {
        return myImagePaths;
    }
    
    @Override
    public void addProperty (IProperty property) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeProperty (IProperty property) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update () {
        // TODO Auto-generated method stub
        
    }

    public String getCurrentImage () {
        // TODO Auto-generated method stub
        return null;
    }

}
