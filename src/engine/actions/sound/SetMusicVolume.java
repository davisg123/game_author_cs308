package engine.actions.sound;

/**
 * Sets the background music volume 
 * @author Will
 *
 */

public class SetMusicVolume extends SoundAction {
    private double myVolume;
    
    public SetMusicVolume (String soundPath) {
        this(soundPath, 0);
        
    }
    
    public SetMusicVolume (String soundPath, double volume) {
        super(soundPath);
        myVolume = volume;
    }

    @Override
    public void execute () {
        mySoundUtility.setVolume(mySoundPath, myVolume);
    }


}
