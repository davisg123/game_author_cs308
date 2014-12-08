package engine.sound;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import engine.FilePathUtility;
import authoring.model.collections.LevelsCollection;
import authoring.model.collections.SoundsCollection;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Plays sounds using composition JavaFX elements in Game
 * @author Will Chang
 *
 */

public class SoundUtility {
    
    private Map<String,MediaPlayer> myMediaPlayerMap;
    private Map<String,AudioClip> myAudioClipMap;
    private LevelsCollection myLevels;
    private FilePathUtility myFilePathUtility;
    private final String SOUNDS = "sounds";
    
    public SoundUtility (LevelsCollection levels, String relativePath) {
        myLevels = levels;
        myMediaPlayerMap = new HashMap<>();
        myAudioClipMap = new HashMap<>();
        myFilePathUtility = new FilePathUtility(SOUNDS,relativePath);
    }
    
    public void initializeMusic () {
        //something with myLevels
        
    }
    
    public void setVolume(String musicPath, double value) {
        myMediaPlayerMap.get(musicPath).setVolume(value);
    }
    
    public void playBackGroundMusic (String musicPath) {
        myMediaPlayerMap.get(musicPath).play();
    }
    
    public void addBackGroundMusic (String musicPath) {
        myMediaPlayerMap.put(musicPath,makeMediaPlayer(musicPath));
    }
    
    private MediaPlayer makeMediaPlayer (String musicPath) {
        File music = new File(musicPath);
        Media media = new Media(music.toURI().toString());
        return new MediaPlayer(media);
    }
    
    public void playAudioClip(String audioClipPath) {
        myAudioClipMap.get(audioClipPath).play();
    }
    
    public void addAudioClip (String audioClipPath) {
        myAudioClipMap.put(audioClipPath, makeAudioClip(audioClipPath));
    }
    
    private AudioClip makeAudioClip (String audioClipPath) {
        File audioClip = new File(audioClipPath);
        return new AudioClip(audioClip.toURI().toString());
    }
    
    public void stopBackGroundMusic (String musicPath) {
        myMediaPlayerMap.get(musicPath).stop();
    }
    
    public void pauseBackGroundMusic (String musicPath) {
        myMediaPlayerMap.get(musicPath).pause();
    }
    
    public void removeBackGroundMusic (String title) {
        myMediaPlayerMap.remove(title);
    }
    
    public void removeAudioClip (String title) {
        myAudioClipMap.remove(title);
    }
}
