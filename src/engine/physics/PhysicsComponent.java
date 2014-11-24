package engine.physics;

import java.util.Arrays;
import java.util.LinkedList;

public class PhysicsComponent {

	public String toString() {
		return new LinkedList<String>(Arrays.asList(this.getClass().toString()
				.split("\\."))).getLast();
	}
}
