package engine.physics;

public class Scalar extends PhysicsComponent{
	protected double myValue;

	public Scalar(double value) {
		myValue = value;
	}

	public double getValue() {
		return myValue;
	}
}
