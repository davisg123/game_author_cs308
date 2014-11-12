package engine.sprite.components;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * 
 * @author ArihantJain
 * @author Will Chang
 *
 */

public class PolygonNode extends PhysicsBody {

	public PolygonNode(Point2D point, double height, double width) {
		super(point, height, width);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createNode() {
		// TODO Auto-generated method stub
		myRenderedNode = new Polygon();
	}

}
