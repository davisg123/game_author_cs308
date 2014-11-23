package engine.physics;

public class Gravity extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;
	private double mass;
	private double gravityConstant;

	public Gravity(double x, double y, double mass, double gravityConstant) {
		super();
		this.mass = mass;
		this.gravityConstant = gravityConstant;
		constructionHelper(x*myForceValue, y*myForceValue);
	}

	@Override
	protected double calculateForce() {
		return mass * gravityConstant * GRAVITY_ACCELERATION;
	}
	
	//write something that switches/negates gravity
}
