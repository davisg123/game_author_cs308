package engine.physics;

public class Vector extends PhysicsComponent {
	protected double myXComponent, myYComponent, myMagnitude;

	// might need direction/quadrant
	public Vector(double x, double y) {
		this.constructionHelper(x, y);
	}

	public Vector() {
		this(0, 0);
	}

	protected double calculateMagnitude(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	protected void constructionHelper(double x, double y) {
		myXComponent = x;
		myYComponent = y;
		myMagnitude = calculateMagnitude(x, y);
	}

	public double getX() {
		return myXComponent;
	}

	public double getY() {
		return myYComponent;
	}

	public Vector getVector() {
		return this;
	}

	public void delta(double x, double y) {
		myXComponent += x;
		myYComponent += y;
	}

	public void delta(Vector vector) {
		delta(vector.getX(), vector.getY());
	}
	
	public double getMagnitude()
	{
		return myMagnitude;
	}
}
