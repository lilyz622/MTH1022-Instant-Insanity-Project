import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplaySolutions {
	public final int CUBE_WIDTH = 80;
	public int frameWidth;
	public int frameHeight;
	
	
	public DisplaySolutions(ArrayList<Pair[][]> solutions){
		Pair[][] p = {
				{new Pair('R','R'),new Pair('W','W'), new Pair('G','G')},
				{new Pair('B','B'), new Pair('G','G'), new Pair('W','W')},
				{new Pair('R','R'),new Pair('W','W'), new Pair('G','G')},
				{new Pair('B','B'), new Pair('G','G'), new Pair('W','W')}
		};
		
		Pair[][] p2 = {
				{new Pair('R','R'),new Pair('W','W'), new Pair('G','G')},
				{new Pair('B','B'), new Pair('G','G'), new Pair('W','W')},
				{new Pair('R','R'),new Pair('W','W'), new Pair('G','G')},
				{new Pair('B','B'), new Pair('G','G'), new Pair('W','W')}
		};
		
		ArrayList<Pair[][]> testSolutions = new ArrayList<Pair[][]>();
		testSolutions.add(p);
		testSolutions.add(p2);
		
		frameWidth = CUBE_WIDTH*(4*4+2);
		frameHeight = CUBE_WIDTH*(6*2);
		
		JFrame frame=new JFrame();
		Image cubepic = (new ImageIcon("Cubes.jpg")).getImage();
		frame.setIconImage(cubepic);
		frame.setBackground(Color.BLACK);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setTitle("Solutions");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SolutionComponent component=new SolutionComponent(testSolutions, CUBE_WIDTH);
		Dimension preferredDim = new Dimension(frameWidth, frameHeight);
		component.setPreferredSize(preferredDim);
		component.setBackground(Color.black);
		JPanel container = new JPanel();
		container.add(component);
		JScrollPane scrPane = new JScrollPane(container);
		frame.add(scrPane);
		frame.setVisible(true);
	}

}
