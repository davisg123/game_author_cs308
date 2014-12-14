package authoring.view.icons;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.FileProperties;
import authoring.view.propertiesview.Properties;

public class SoundIcon extends FileIcon implements IPropertiesMaker{
	private static final int DEFAULT_SOUND_ICON_SIZE = 60;
	private Image mySoundIcon;
	private MediaPlayer myAudioPlayer;

	FileChooser myFileChooser = new FileChooser();

	public SoundIcon(File gameLoc, String label, GameHandler... handler) {
		super(gameLoc, label, handler);
		mySoundIcon = new Image(getClass().getResourceAsStream(
				"/assets/authoring_images/audioicon.png"));
		makeIcon();
		generateMedia();
		this.addLabel();

	}

	private void generateMedia() {
		File file = new File(myGameLocation.getPath() + "/sounds/" + myLabel);
		Media media = new Media(file.toURI().toString());
		myAudioPlayer = new MediaPlayer(media);

	}

	@Override
	protected void makeIcon() {
		ImageView soundImageView = new ImageView(mySoundIcon);
		soundImageView.setFitHeight(DEFAULT_SOUND_ICON_SIZE);
		soundImageView.setPreserveRatio(true);
		this.getChildren().add(soundImageView);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}

	}

	public void play() {
		if (myAudioPlayer.getStatus().equals(MediaPlayer.Status.PLAYING))
			myAudioPlayer.stop();
		else {
			myAudioPlayer.play();
		}
	}

	@Override
	public Properties makeProperties() {
		return new FileProperties(this);
	}

}
