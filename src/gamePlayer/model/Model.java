package gamePlayer.model;

import java.io.IOException;

import gamePlayer.view.PlayerView;

public class Model {

	private DataWrapper myWrapper; 
	private PlayerView myPlayerView;
	
	public Model() throws IOException {
		myPlayerView = new PlayerView(this);
		myPlayerView.initialize();
	}
	
	
	
	
}
