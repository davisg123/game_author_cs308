package engine.sprite;

import java.util.List;

import engine.sprite.components.SpriteComponent;
import engine.sprite.components.properties.IProperty;

public class SoundReference extends SpriteComponent {

    private List<String> mySoundPaths;
    
    public List<String> getSoundPaths () {
        return mySoundPaths;
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

    public String getCurrentSound () {
        // TODO Auto-generated method stub
        return null;
    }

}
