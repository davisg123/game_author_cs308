package engine.physics;

public class Volume extends Scalar{
	public Volume(double value) {
		super(value);
	}

	@Override
	protected void initializeForceList() {
		myAssociatedForces.add("Buoyancy");
	}
	
}
