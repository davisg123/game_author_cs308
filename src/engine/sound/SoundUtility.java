package engine.sound;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Plays sounds using composition JavaFX elements in Game
 * @author Will
 *
 */

public class SoundUtility {
    
    private Map<String,MediaPlayer> myMediaPlayerMap;
    private Map<String,AudioClip> myAudioClipMap;
    
    public SoundUtility () {
        myMediaPlayerMap = new HashMap<>();
        myAudioClipMap = new HashMap<>();
    }
    
    public void initializeAllMusic () {
        
    }
    
    public void playBackGroundMusic (String title) {
        myMediaPlayerMap.get(title).play();
    }
    
    public void addBackGroundMusic (String title, String musicPath) {
        myMediaPlayerMap.put(title,makeMediaPlayer(musicPath));
    }
    
    private MediaPlayer makeMediaPlayer (String musicPath) {
        File music = new File(musicPath);
        Media media = new Media(music.toURI().toString());
        return new MediaPlayer(media);
    }
    
    public void playAudioClip(String title) {
        myAudioClipMap.get(title).play();
    }
    
    public void addAudioClip (String title, String audioClipPath) {
        myAudioClipMap.put(title, makeAudioClip(audioClipPath));
    }
    
    private AudioClip makeAudioClip (String audioClipPath) {
        File audioClip = new File(audioClipPath);
        return new AudioClip(audioClip.toURI().toString());
    }
    
    public void stopBackGroundMusic (String title) {
        myMediaPlayerMap.get(title).stop();
    }
    
    public void pauseBackGroundMusic (String title) {
        myMediaPlayerMap.get(title).pause();
    }
    
    public void removeBackGroundMusic (String title) {
        myMediaPlayerMap.remove(title);
    }
    
    public void removeAudioClip (String title) {
        myAudioClipMap.remove(title);
    }
}
