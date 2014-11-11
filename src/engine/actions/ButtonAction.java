package engine.actions;

import java.util.List;
import engine.events.Event;

/**
 * 
 * @author Davis
 * 
 * actions caused by a button press
 *
 */

public class ButtonAction extends Action {
    private char triggerKey;
    
    public ButtonAction (char triggerKey) {
        super();
        this.triggerKey = triggerKey;
    }

    @Override
    public boolean isEnabled () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Event> getEvents () {
        // TODO Auto-generated method stub
        return null;
    }

}
