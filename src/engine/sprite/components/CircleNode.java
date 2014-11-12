package engine.sprite.components;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

/**
 * 
 * @author ArihantJain
 * @author Will Chang
 *
 */

public class CircleNode extends PhysicsBody {

	public CircleNode(Point2D point, double height, double width) {
		super(point, height, width);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createNode() {
		// TODO Auto-generated method stub
		myRenderedNode = new Circle();
	}
	
	protected Node initializeNode(){
		Circle circle = new Circle(myLocation.getX(),myLocation.getY(),);
		circle.setCenterX(myLocation.getX());
		
		
	}

}
