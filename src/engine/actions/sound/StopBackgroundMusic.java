package engine.actions.sound;

/**
 * Stops specified background music
 * @author Will
 *
 */

public class StopBackgroundMusic extends SoundAction {
    
    public StopBackgroundMusic (String soundPath) {
        super(soundPath);
    }

    @Override
    public void execute () {
        mySoundUtility.stopBackGroundMusic(mySoundPath);
    }

}
