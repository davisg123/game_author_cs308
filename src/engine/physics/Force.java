package engine.physics;

public abstract class Force extends Vector {
	protected double myForceValue;
	protected String myForceType;
	
	public Force(double x, double y, String forceType) {
		super(x, y);
		this.myForceType = forceType;
		myForceValue = calculateForce();
	}

	public Force(String forceType) {
		this(0, 0, forceType);
	}

	public String getForceType()
	{
		return this.myForceType;
	}
	protected abstract double calculateForce();
}
