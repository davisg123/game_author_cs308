package engine.actions;

import engine.GameManager;
import engine.sound.SoundUtility;

/**
 * Action interacts with the SoundUtility
 * @author Will
 *
 */

public abstract class SoundAction implements Action, Initializable {
    protected SoundUtility mySoundUtility;
    protected String mySoundPath;
    
    public SoundAction () {
        this("");
    }
    
    public SoundAction (String soundPath) {
        mySoundPath = soundPath;
    }
    
    @Override
    public void initialize (GameManager manager) {
        mySoundUtility = manager.getSoundUtility();
    }
    
    public void setSoundPath (String soundPath) {
        mySoundPath = soundPath;
    }

}
