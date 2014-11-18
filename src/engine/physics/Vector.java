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

	protected void calculateMagnitude() {
		myMagnitude = Math.sqrt(myXComponent * myXComponent + myYComponent
				* myYComponent);
	}

	protected void constructionHelper(double x, double y) {
		myXComponent = x;
		myYComponent = y;
		calculateMagnitude();
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
		calculateMagnitude();

	}

	public void delta(Vector vector) {
		delta(vector.getX(), vector.getY());
	}

	public double getMagnitude() {
		return myMagnitude;
	}

	public void scalarMultiplication(double multiply) {
		myXComponent *= multiply;
		myYComponent *= multiply;
		calculateMagnitude();
	}

	public void setX(double x) {
		myXComponent = x;
		calculateMagnitude();

	}

	public void setY(double y) {
		myYComponent = y;
		calculateMagnitude();

	}
}
