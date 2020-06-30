

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class Canvas extends JApplet {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		Color col = Color.BLUE;
		Triangle tri1 = new Triangle(400,400,50,100);
		tri1.setColor(col);
		canvas.drawShape(tri1);
	}


	private int height;
	private int width;
	private LinkedList<Circle> circles;
	private LinkedList<Rectangle> rectangles;
	private LinkedList<Triangle> triangles;

	public Canvas() {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = 800;
		width = 800;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new LinkedList<Circle>();
		rectangles = new LinkedList<Rectangle>();
		triangles = new LinkedList<Triangle>();
		f.setVisible(true);
	}

	public Canvas(int h, int w) {
		JFrame f = new JFrame("Canvas");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		height = h;
		width = w;
		f.setSize(width, height);
		f.getContentPane().add(this);
		circles = new LinkedList<Circle>();
		rectangles = new LinkedList<Rectangle>();
		triangles = new LinkedList<Triangle>();
		f.setVisible(true);
	}

	public synchronized void paint(Graphics g) {
		ListIterator<Circle> circItr = circles.listIterator();
		ListIterator<Rectangle> recItr = rectangles.listIterator();
		ListIterator<Triangle> triItr = triangles.listIterator();

		while (circItr.hasNext()) {
			Circle curCircle = circItr.next();
			g.setColor(curCircle.getColor());
			int curRadius = (int)curCircle.getRadius();
			g.fillOval((int)curCircle.getXPos() - curRadius, (int)curCircle.getYPos()
					- curRadius, 2 * curRadius, 2 * curRadius);

		}

		while (recItr.hasNext()) {
			Rectangle curRectangle = recItr.next();
			g.setColor(curRectangle.getColor());
			g.fillRect((int)curRectangle.getXPos(), (int)curRectangle.getYPos(),
					(int)curRectangle.getWidth(), (int)curRectangle.getHeight());
		}

		while (triItr.hasNext()) {
			Triangle curTriangle = triItr.next();
			g.setColor(curTriangle.getColor());
			Polygon po = new Polygon();
			po.addPoint((int)curTriangle.getXPos(), (int)curTriangle.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth()), (int)curTriangle
					.getYPos());
			po.addPoint((int)(curTriangle.getXPos() + curTriangle.getWidth() / 2), (int)(curTriangle.getYPos() - curTriangle.getHeight()));
			g.fillPolygon(po);
		}
	}


	public synchronized void drawShape(Circle circ){
		circles.add(circ);
	}

	public synchronized void drawShape(Rectangle rec){
		rectangles.add(rec);
	}

	public synchronized void drawShape(Triangle tri){
		triangles.add(tri);
	}

	public synchronized void clear() {
		circles.clear();
		rectangles.clear();
		triangles.clear();
	}

	public void CircleFractal(double x, double y,double radius, Color color, Canvas canvas, int times) {
		double totalArea = 0.0;
		Circle circle = new Circle(x, y, radius);
		circle.setColor(color);
		if (times < 8) {
			canvas.drawShape(circle);
			totalArea = totalArea +circle.calculateArea();

			Color nextColor = color;
			if (color == Color.BLUE) {
				nextColor = Color.RED;
			} else if (color == Color.RED) {
				nextColor = Color.GREEN;
			} else if (color == Color.GREEN) {
				nextColor = Color.BLUE;
			}

			CircleFractal( x + 1.5 * radius, y,radius / 2, nextColor, canvas, times + 1);
			CircleFractal( x - 1.5 * radius, y,radius / 2, nextColor, canvas, times + 1);
			CircleFractal(  x, y + 1.5 * radius,radius / 2, nextColor, canvas,times + 1);
			CircleFractal(  x, y - 1.5 * radius,radius / 2, nextColor, canvas,times + 1);
		}
	}

	public void RectangleFractal(double x, double y, double width,double height, Color color, Canvas canvas, int times){
		double totalArea = 0.0;
		Rectangle rectangle= new Rectangle(x,y,width,height);
		rectangle.setColor(color);
		if (times<8) {
			canvas.drawShape(rectangle);
			totalArea = totalArea + rectangle.calculateArea();

			Color nextColor = color;
			if (color == Color.BLUE) {
				nextColor = Color.RED;
			} else if (color == Color.RED) {
				nextColor = Color.GREEN;
			} else if (color == Color.GREEN) {
				nextColor = Color.BLUE;
			}

			RectangleFractal(x-width/2, y-height/2, width / 2, height / 2, nextColor, canvas, times + 1);
			RectangleFractal(x-width/2, y + height, width / 2, height / 2, nextColor, canvas, times + 1);
			RectangleFractal(x + width, y-height/2, width / 2, height / 2, nextColor, canvas, times + 1);
			RectangleFractal(x + width, y + height, width / 2, height / 2, nextColor, canvas, times + 1);
		}

	}

	public void TriangleFractal(double x, double y,double width, double height, Color color, Canvas canvas, int times){
		double totalArea = 0.0;
		Triangle triangle= new Triangle(x,y,width,height);
		triangle.setColor(color);
		if(times<8){
			canvas.drawShape(triangle);
			totalArea = totalArea + triangle.calculateArea();

			Color nextColor = color;
			if (color == Color.BLUE) {
				nextColor = Color.RED;
			} else if (color == Color.RED) {
				nextColor = Color.GREEN;
			} else if (color == Color.GREEN) {
				nextColor = Color.BLUE;
			}

			TriangleFractal(x-width/2,y,width/2,height/2,nextColor,canvas,times+1);
			TriangleFractal(x+width,y,width/2,height/2,nextColor,canvas,times+1);
			TriangleFractal(x+width/4,y-height,width/2,height/2,nextColor,canvas,times+1);

		}

	}


}
