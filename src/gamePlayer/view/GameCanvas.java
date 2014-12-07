package gamePlayer.view;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;

public class GameCanvas implements ViewController{
	
	private Group myCanvas;
	private Camera myCamera;
	private Integer mySpriteX;
	private Integer mySpriteY;
	
	public GameCanvas() {
		myCanvas = new Group();
		myCamera = new PerspectiveCamera(true);
		mySpriteX = 0;
		mySpriteY = 0;
		myCamera.setNearClip(mySpriteX - 100);
		myCamera.setFarClip(mySpriteY + 100);
		myCanvas.getChildren().add(myCamera);
	}
	
	@Override
	public Group getNode() {
		return (Group)myCanvas;
	}
	
	public void incrementX() {
		mySpriteX += 10;
		mySpriteY += 10;
	}
	
	public void addToGroup(Node n){
		myCanvas.getChildren().add(n);
	}
	
	public void clear(){
		myCanvas.getChildren().clear();
	}
	
}
