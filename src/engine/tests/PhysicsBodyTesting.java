package engine.tests;

import engine.gameObject.components.PhysicsBody;
import engine.physics.Gravity;
import engine.physics.GravityConstant;
import engine.physics.Mass;

public class PhysicsBodyTesting {

	public static void main(String[] args){
		PhysicsBody pb = new PhysicsBody();
		pb.addForce(new Gravity(0,1.0));
		System.out.println(pb.getForce("Gravity").getMagnitude());
		pb.addScalar(new GravityConstant(4.0));
		//System.out.println(pb.getScalar("Mass").getValue());
		System.out.println(pb.getForce("Gravity").getMagnitude());
	}
}
