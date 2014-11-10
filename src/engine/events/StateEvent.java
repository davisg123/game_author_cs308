package engine.events;

import java.util.List;

/**
 * Event changes Health, Power, and items of Sprites by interacting with the State Component.
 * @author Will
 *
 */

public class StateEvent implements Event {

    private List<Double> myValues;
    
    
    /**
     * Constructor loads values that can be changed in state
     * @param values
     */
    public StateEvent (List<Double> values) {
        myValues = values;
    }
    
    @Override
    public void execute () {
        // TODO Auto-generated method stub
        
    }

}
