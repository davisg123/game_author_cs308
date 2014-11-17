package engine.sprite;

import java.util.ArrayList;
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
    private String myCurrentImage;

    public ImageReference() {
        myImagePaths = new ArrayList<>();
    }
    
    public ImageReference (List<String> imagePaths) {
        myImagePaths = imagePaths;
        
    }
    

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

    public void setCurrentImage(String imagePath) {
        myCurrentImage = imagePath;
    }
    
    public String getCurrentImage () {
        return myCurrentImage;
    }

}
