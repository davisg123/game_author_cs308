package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class YVelocityIDAction extends VelocityIDAction {

	public YVelocityIDAction(ArrayList<Identifier> id, double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(double value, Vector vector) {
		vector=new Velocity(0, value);
		return vector;
	}

}
