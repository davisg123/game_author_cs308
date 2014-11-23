package engine.physics;

public class Buoyancy extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;
	private double volume;
	private double densityOfFluid;

	public Buoyancy(double x, double y, double volume, double density) {
		super();
		this.volume = volume;
		this.densityOfFluid = density;
		constructionHelper(x*myForceValue, y*myForceValue);
	}
	
	protected double calculateForce() {
		return densityOfFluid * GRAVITY_ACCELERATION * volume;
	}
}
