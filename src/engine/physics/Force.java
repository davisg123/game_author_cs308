package engine.physics;

public abstract class Force extends Vector {
	protected double myForceValue;

	public Force(double x, double y) {
		super(x, y);
		myForceValue = calculateForce();
	}

	public Force() {
		this(0, 0);
	}

	protected abstract double calculateForce();
}
