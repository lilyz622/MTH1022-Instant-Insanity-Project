import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SolutionComponent extends JComponent {
	public ArrayList<Pair[][]> solutions;
	public final int LEFT_CUBE_X = 80;
	public final int LEFT_CUBE_Y = 80;
	public int cubeWidth;

	public SolutionComponent(ArrayList<Pair[][]> solutions, int cubeWidth) {
		this.solutions = solutions;
		this.cubeWidth = cubeWidth;
	}

	public Color charToColor(char c) {
		switch (c) {
		case 'R':
			return Color.RED;
		case 'B':
			return Color.BLUE;
		case 'G':
			return Color.GREEN;
		case 'W':
			return Color.WHITE;
		case 'Z':
			return Color.gray;
		default:
			return Color.BLACK;
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.BLACK);
		int curX = this.LEFT_CUBE_X;
		int curY = this.LEFT_CUBE_Y;

		for (int sol = 0; sol < this.solutions.size(); sol++) {
			Pair[][] solution = solutions.get(sol);
			int tempX = curX;
			for (int i = 0; i < solution.length; i++) {
				paintCube(g2, tempX, curY, solution[i]);
				tempX += 4 * this.cubeWidth;
			}
			curY += 5 * this.cubeWidth;
		}

	}

	public void paintSquare(Graphics2D g, int x, int y, int width, char c) {
		// draws a cube
		Rectangle r = new Rectangle(x, y, width, width);
		g.setColor(this.charToColor(c));
		g.fill(r);
		
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.BLACK);
		// top
		Line2D top = new Line2D.Float(x, y, x+this.cubeWidth, y);
		g.draw(top);
		// left
		Line2D left = new Line2D.Float(x, y, x, y+this.cubeWidth);
		g.draw(left);
		// right
		Line2D right = new Line2D.Float(x, y+this.cubeWidth, x+this.cubeWidth, y+this.cubeWidth);
		g.draw(right);
		// right
		Line2D bottom = new Line2D.Float(x+this.cubeWidth, y, x+this.cubeWidth, y+this.cubeWidth);
		g.draw(bottom);
		
	}

	public void paintCube(Graphics2D g2, int x, int y, Pair[] cube) {
		int curX = x;
		int curY = y;
		

		curX += this.cubeWidth;
		paintSquare(g2, curX, curY, this.cubeWidth, cube[0].getColor1());
		curY += this.cubeWidth;

		curX -= this.cubeWidth;
		paintSquare(g2, curX, curY, this.cubeWidth, cube[2].getColor1());
		curX += this.cubeWidth;
		paintSquare(g2, curX, curY, this.cubeWidth, cube[1].getColor1());
		curX += this.cubeWidth;
		paintSquare(g2, curX, curY, this.cubeWidth, cube[2].getColor2());
		curX -= this.cubeWidth;
		curY += this.cubeWidth;

		paintSquare(g2, curX, curY, this.cubeWidth, cube[0].getColor2());
		curY += this.cubeWidth;

		paintSquare(g2, curX, curY, this.cubeWidth, cube[1].getColor2());

	}

}
