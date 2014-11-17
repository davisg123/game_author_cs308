package gamePlayer.model;

import java.io.IOException;

import gamePlayer.view.PlayerView;

public class PlayerModel {

	private DataWrapper myWrapper;
	private PlayerView myPlayerView;

	public PlayerModel() {
		myPlayerView = new PlayerView(this);
	}

	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}

}
