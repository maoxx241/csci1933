import java.awt.Color;
 
import junit.framework.TestCase;


public class TriangleTest extends TestCase {

	private Triangle tri;

	protected void setUp() throws Exception {
		tri = new Triangle(400, 400, 50, 100);
	}

	public void testCalculateArea() {
		assertEquals(2500, tri.calculateArea(),0.001);
	}

	public void testCalculatePerimeter() {
		assertEquals(256.155, tri.calculatePerimeter(),0.001);
	}

	public void testSetAndGetColor() {
		tri.setColor(Color.BLUE);
		assertEquals(Color.BLUE, tri.getColor());
	}

	public void testSetAndGetPos() {
		tri.setPos(100, 200);
		assertEquals(100.0, tri.getXPos());
		assertEquals(200.0, tri.getYPos());
	}

	public void testSetAndGetHeight() {
		tri.setHeight(150);
		assertEquals(150.0, tri.getHeight());
	}

	public void testSetAndGetWidth() {
		tri.setWidth(150);
		assertEquals(150.0, tri.getWidth());
	}

}
