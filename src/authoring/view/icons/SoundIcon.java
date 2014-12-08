package authoring.view.icons;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import authoring.eventhandlers.GameHandler;

public class SoundIcon extends FileIcon {
	private static final int DEFAULT_SOUND_ICON_SIZE = 60;
	private Image mySoundIcon;

	public SoundIcon(File gameLoc, String label, GameHandler[] handler) {
		super(gameLoc, label, handler);
		mySoundIcon = new Image(getClass().getResourceAsStream(
				"/assets/authoring_images/audioicon.png"));
		makeIcon();
		this.addLabel();
	}

	@Override
	protected void makeIcon() {
		ImageView soundImageView = new ImageView(mySoundIcon);
		soundImageView.setFitHeight(DEFAULT_SOUND_ICON_SIZE);
		soundImageView.setPreserveRatio(true);
		
		this.getChildren().add(soundImageView);

	}
}
