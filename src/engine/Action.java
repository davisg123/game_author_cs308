package engine;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    private List<Event> myEvents = new ArrayList<Event>();
    private List<Sprite> mySprites = new ArrayList<Sprite>();
    
    public abstract boolean isEnabled();
    
    public List<Event> getEvents(){
        return myEvents;
    }
    
    public List<Sprite> getSprites(){
        return mySprites;
    }
}
