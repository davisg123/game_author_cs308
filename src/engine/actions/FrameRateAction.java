package engine.actions;

import engine.GameManager;

/**
 * action for modifying frame rate
 * @author Davis
 *
 */

public class FrameRateAction implements Action, Initializable {
    
    private GameManager myGameManager;
    private double myFrameRate;
    
    public FrameRateAction (double frameRate) {
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
