import java.awt.Color;
 
import junit.framework.TestCase;


public class RectangleTest extends TestCase {

	private Rectangle rec;

	protected void setUp() throws Exception {
		rec = new Rectangle(400, 400, 50, 100);
	}

	public void testCalculateArea() {
		assertEquals(5000, rec.calculateArea(),0.001);
	}

	public void testCalculatePerimeter() {
		assertEquals(300, rec.calculatePerimeter(),0.001);
	}

	public void testSetAndGetColor() {
		rec.setColor(Color.BLUE);
		assertEquals(Color.BLUE, rec.getColor());
	}

	public void testSetAndGetPos() {
		rec.setPos(100.0, 200.0);
		assertEquals(100.0, rec.getXPos());
		assertEquals(200.0, rec.getYPos());
	}

	public void testSetAndGetHeight() {
		rec.setHeight(150.0);
		assertEquals(150.0, rec.getHeight());
	}

	public void testSetAndGetWidth() {
		rec.setWidth(150.0);
		assertEquals(150.0, rec.getWidth());
	}
}
