package engine.actions.sound;

/**
 * Pauses specified background music
 * @author Will
 *
 */

public class PauseBackgroundMusic extends SoundAction {

    public PauseBackgroundMusic (String soundPath) {
        super(soundPath);
    }

    @Override
    public void execute () {
        mySoundUtility.pauseBackGroundMusic(mySoundPath);
    }

}
