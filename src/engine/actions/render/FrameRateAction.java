package engine.actions.render;

import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;

/**
 * action for modifying frame rate
 * @author Davis
 *
 */

public class FrameRateAction implements Action, Initializable {
    
    private GameManager myGameManager;
    private Double myFrameRate;
    
    public FrameRateAction (Double frameRate) {
        super();
        myFrameRate = frameRate;
    }

    @Override
    public void initialize (GameManager manager) {
        myGameManager = manager;
    }

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		myGameManager.setGameSpeed(myFrameRate, true);
	}

}
