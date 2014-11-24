package engine.actions;

import java.util.List;

import engine.GameManager;

/**
 * Event changes Health, Power, and items of Sprites by interacting with the State Component.
 * @author Will
 *
 */

public class StateAction implements Action, Initializable {

    private List<Double> myValues;
    
    
    /**
     * Constructor loads values that can be changed in state
     * @param values
     */
    public StateAction (List<Double> values) {
        myValues = values;
    }
    
    @Override
    public void execute () {
        // TODO Auto-generated method stub
        
    }

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

}
