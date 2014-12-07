package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;

public class FileIcon extends BaseIcon {
	protected File myGameLocation;

	public FileIcon(File gameLoc, String label, GameHandler... handler) {
		super(label, handler);
		myGameLocation = gameLoc;
	}

	public String getName() {
		return myLabel;
	}
}
