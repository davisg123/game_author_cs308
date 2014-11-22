package engine.physics;

/**
 * super for vector valued components
 * 
 * @author Ben
 *
 */
public class Vector extends PhysicsComponent {
	protected double myXComponent, myYComponent, myMagnitude;

	public Vector(double x, double y) {
		this.constructionHelper(x, y);
	}

	public Vector() {
		this(0, 0);
	}

	/**
	 * calculates magnitude of a vector
	 */
	protected void calculateMagnitude() {
		myMagnitude = Math.sqrt(myXComponent * myXComponent + myYComponent
				* myYComponent);
	}

	/**
	 * used to overcome a problem with the constructor and super classes
	 * 
	 * @param x
	 * @param y
	 */
	protected void constructionHelper(double x, double y) {
		myXComponent = x;
		myYComponent = y;
		calculateMagnitude();
	}

	/**
	 * getter for x value
	 * 
	 * @return x value
	 */
	public double getX() {
		return myXComponent;
	}

	/**
	 * getter for y value
	 * 
	 * @return y value
	 */
	public double getY() {
		return myYComponent;
	}

	/**
	 * getter for the vector
	 * 
	 * @return this
	 */
	public Vector getVector() {
		return this;
	}

	/**
	 * adds two doubles to current x,y values
	 * 
	 * @param x
	 *            -add to x
	 * @param y
	 *            -add to y
	 */
	public void delta(double x, double y) {
		myXComponent += x;
		myYComponent += y;
		calculateMagnitude();

	}

	/**
	 * same as other delta
	 * 
	 * @param vector
	 *            -same as other thing, just a vector instead of x and y doubles
	 */
	public void delta(Vector vector) {
		delta(vector.getX(), vector.getY());
	}

	/**
	 * getter for magnitude of vector
	 * 
	 * @return magnitude of vector
	 */
	public double getMagnitude() {
		return myMagnitude;
	}

	/**
	 * scalar multiplication
	 * 
	 * @param multiply
	 *            what scalar you're multiplying by
	 */
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
