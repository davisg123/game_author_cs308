package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public abstract class FileIcon extends BaseIcon {
	protected File myGameLocation;

	public FileIcon(File gameLoc, String label, GameHandler... handler) {
		super(label, handler);
		myGameLocation = gameLoc;
	}

	protected abstract void makeIcon();
}
