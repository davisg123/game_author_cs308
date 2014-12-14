package engine.actions;

public class PlayAudioClipAction extends AudioClipAction {

    public PlayAudioClipAction (String path) {
        super(path);
    }

    @Override
    public void execute () {
        mySoundUtility.playAudioClip(myAudioClipPath);
    }

}
