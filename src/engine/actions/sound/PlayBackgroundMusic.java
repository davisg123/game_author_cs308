package engine.actions.sound;

/**
 * Plays the given sound
 * @author Will
 *
 */

public class PlayBackgroundMusic extends SoundAction {

    public PlayBackgroundMusic (String soundPath) {
        super(soundPath);
    }

    @Override
    public void execute () {
        mySoundUtility.playBackGroundMusic(mySoundPath);
    }

}
