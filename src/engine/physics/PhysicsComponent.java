package engine.physics;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * @author Ben might do something in the future...also was able to remove the
 *         toString which I love
 */
public class PhysicsComponent {

	public String toString() {
		return new LinkedList<String>(Arrays.asList(this.getClass().toString()
				.split("\\."))).getLast();
	}
}
