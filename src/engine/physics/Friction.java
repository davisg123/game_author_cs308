package engine.physics;

public class Friction extends Force{
	private double mass;
	private double coefficientOfFriction;
	
	public Friction(double x, double y, double mass, double friction)
	{
		super("friction");
		this.mass=mass;
		coefficientOfFriction=friction;
		constructionHelper(x*myForceValue, y*myForceValue);
	}
	
	protected double calculateForce()
	{
		return coefficientOfFriction*mass;
	}
}
