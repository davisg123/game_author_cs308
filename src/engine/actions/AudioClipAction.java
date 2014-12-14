package engine.actions;

import engine.GameManager;
import engine.sound.SoundUtility;

/**
 * Superclass for actions related to AudioClips
 * @author Will
 *
 */

public abstract class AudioClipAction implements Action, Initializable {
    protected String myAudioClipPath;
    protected transient SoundUtility mySoundUtility;
    
    public AudioClipAction (String path) {
        myAudioClipPath = path;
    }
    
    @Override
    public void initialize (GameManager manager) {
        mySoundUtility = manager.getSoundUtility();
        mySoundUtility.addAudioClip(myAudioClipPath);
    }

}
