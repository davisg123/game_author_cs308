package engine.physics;

import engine.gameObject.GameObject;

public class NormalUpdate extends BEngine {
	public double impulseAndVelocity(double impulse, double mass) {
		return impulse / mass;
	}

	public double calculateLinearChange(double value)
	{
		return value/60.0;
	}
	
}
