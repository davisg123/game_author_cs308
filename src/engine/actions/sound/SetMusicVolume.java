package engine.actions.sound;

/**
 * Sets the background music volume 
 * @author Will
 *
 */

public class SetMusicVolume extends SoundAction {
    private Double myVolume;
    
    public SetMusicVolume (String soundPath) {
        this(soundPath, (double) 0);
        
    }
    
    public SetMusicVolume (String soundPath, Double volume) {
        super(soundPath);
        myVolume = volume;
    }

    @Override
    public void execute () {
        mySoundUtility.setVolume(mySoundPath, myVolume);
    }


}
