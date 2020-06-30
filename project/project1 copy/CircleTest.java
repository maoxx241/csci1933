import java.awt.Color;
 
import junit.framework.TestCase;


public class CircleTest extends TestCase {
	private Circle circ;

	protected void setUp() throws Exception {
		circ = new Circle(400, 400, 50);
	}

	public void testCalculateArea() {
		assertEquals(7853.98163, circ.calculateArea(),0.001);
	}

	public void testCalculatePerimeter() {
		assertEquals(314.15927, circ.calculatePerimeter(),0.001);
	}

	public void testSetAndGetColor() {
		circ.setColor(Color.BLUE);
		assertEquals(Color.BLUE, circ.getColor());
	}

	public void testSetAndGetPos() {
		circ.setPos(100, 200);
		assertEquals(100.0, circ.getXPos());
		assertEquals(200.0, circ.getYPos());
	}

	public void testSetAndGetRadius() {
		circ.setRadius(150);
		assertEquals(150.0, circ.getRadius());
	}
}
