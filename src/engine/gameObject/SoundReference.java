package engine.gameObject;

import java.util.List;
import engine.gameObject.components.ComponentComponent;
import engine.gameObject.components.properties.IProperty;

public class SoundReference extends ComponentComponent {

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
