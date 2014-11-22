package engine.physics;
/**
 * friction force, subclass of force, is a vector
 * @author Ben
 *
 */
public class Friction extends Force{
	private static final double GRAVITY_ACCELERATION = 9.8;
	private double mass;
	private double coefficientOfFriction;
	
	public Friction(double x, double y, double mass, double friction)
	{
		super();
		this.mass=mass;
		coefficientOfFriction=friction;
		constructionHelper(x*myForceValue, y*myForceValue);
	}
	/**
	 * calculates value of friction force
	 */
	protected double calculateForce()
	{
		return coefficientOfFriction*mass*GRAVITY_ACCELERATION;
	}
}
