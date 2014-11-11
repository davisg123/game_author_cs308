package gamePlayer.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class GameCanvas implements ViewController{
	
	private Group myCanvas;
	
	
	public GameCanvas(){
		myCanvas = new Group();
	}
	
	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return myCanvas;
	}
	
	public void addToGroup(Node n){
		myCanvas.getChildren().add(n);
	}
	
	public void clear(){
		myCanvas.getChildren().clear();
	}
	
	

	
	
}
