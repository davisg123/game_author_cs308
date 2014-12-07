package gamePlayer.view;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameCanvas implements ViewController{
	
	private Group myCanvas;
	
	public GameCanvas() {
		myCanvas = new Group();
		Circle circle = new Circle(50, 50, 0);
		circle.setFill(Color.BLACK);
		myCanvas.getChildren().add(circle);
	}
	
	@Override
	public Group getNode() {
		return (Group)myCanvas;
	}
		
	public void addToGroup(Node n){
		myCanvas.getChildren().add(n);
	}
	
	public void clear(){
		myCanvas.getChildren().clear();
	}
	
}
