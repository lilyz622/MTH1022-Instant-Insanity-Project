import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplaySolutions {
	public final int CUBE_WIDTH = 70;
	public int frameWidth;
	public int frameHeight;

	public static void main(String[] args) {
		DisplaySolutions d = new DisplaySolutions(null, null);
	}

	private ArrayList<Pair[][]> createTestSolutions() {
		Pair[][] p = { { new Pair('B', 'R'), new Pair('B', 'W'), new Pair('G', 'W') },
				{ new Pair('W', 'B'), new Pair('G', 'R'), new Pair('R', 'W') },
				{ new Pair('R', 'G'), new Pair('W', 'G'), new Pair('B', 'B') },
				{ new Pair('G', 'W'), new Pair('R', 'B'), new Pair('R', 'R') } };

		Pair[][] p2 = { { new Pair('G', 'W'), new Pair('B', 'R'), new Pair('B', 'W') },
				{ new Pair('G', 'R'), new Pair('W', 'B'), new Pair('R', 'W') },
				{ new Pair('R', 'G'), new Pair('W', 'G'), new Pair('B', 'B') },
				{ new Pair('R', 'B'), new Pair('G', 'W'), new Pair('R', 'R') } };
		ArrayList<Pair[][]> testSolutions = new ArrayList<Pair[][]>();
		testSolutions.add(p);
		testSolutions.add(p2);
		return testSolutions;
	}
	
	private Cube[] createTestOriginalCubes(){
		Cube[] out = {new Cube( new Pair('G', 'W'), new Pair('B', 'R'), new Pair('B', 'W') ),
			new Cube(new Pair('G', 'R'), new Pair('W', 'B'), new Pair('R', 'W')),
			new Cube(new Pair('R', 'G'), new Pair('W', 'G'), new Pair('B', 'B')),
			new Cube(new Pair('R', 'B'), new Pair('G', 'W'), new Pair('R', 'R'))
		};
		return out;	
	}
	
	private ArrayList<Pair[][]> createTestInputSolutions(){
		ArrayList<Pair[][]> out = new ArrayList<Pair[][]>();
		Pair[][] p = { { new Pair('B', 'R'), new Pair('B', 'W'), new Pair('G', 'W') },
				{ new Pair('W', 'B'), new Pair('G', 'R'), new Pair('R', 'W') },
				{ new Pair('R', 'G'), new Pair('W', 'G'), new Pair('B', 'B') },
				{ new Pair('G', 'W'), new Pair('R', 'B'), new Pair('R', 'R') } };
		
		Pair[][] p1 = {
				{new Pair('B', 'R'), new Pair('W', 'B'), new Pair('R', 'G'), new Pair('G', 'W')},
				{new Pair('B', 'W'), new Pair('G', 'R'), new Pair('W', 'G'), new Pair('R', 'B')}
		};
		out.add(p1);
		return out;
	}

	private Pair[][] mapToCube(Pair[][] input, Cube[] originalCubes) {

		Cube[] solutionCubes = new Cube[originalCubes.length];
		for (int i = 0; i < solutionCubes.length; i++) {
			solutionCubes[i] = new Cube();
		}

		// SETTING UD PAIRS

		// p1k p2k p3k p4k
		Pair[] pairSet1 = input[0];

		// set C0P0 to be first pair from Solutions
		solutionCubes[0].setUD(pairSet1[0]);

		for (int cubeNum = 1; cubeNum < pairSet1.length; cubeNum++) {
			boolean c1IsUd1 = true;
			Pair curPair = pairSet1[cubeNum];
			for (int prevCube = 0; prevCube < cubeNum; prevCube++) {
				Pair prevPair = solutionCubes[prevCube].getUpDown();
				// if the color of the face of a prev pair
				// is the same of that of the current pair,
				// switch the colors on the current pair
				if (prevPair.getColor1() == curPair.getColor1() || prevPair.getColor2() == curPair.getColor2()) {
					c1IsUd1 = false;
					char temp = curPair.getColor1();
					curPair.setColor1(curPair.getColor2());
					curPair.setColor2(temp);
				}
			}
			solutionCubes[cubeNum].setUD(curPair);
		}

		// SETTING FB PAIRS

		// p1b p2b p3b p4b
		Pair[] pairSet2 = input[1];

		solutionCubes[0].setFB(pairSet2[0]);
		for (int cubeNum = 1; cubeNum < pairSet2.length; cubeNum++) {
			boolean c1IsFb1 = true;
			Pair curPair = pairSet2[cubeNum];
			for (int prevCube = 0; prevCube < cubeNum; prevCube++) {
				Pair prevPair = solutionCubes[prevCube].getFrontBack();
				// if the color of the face of a prev pair
				// is the same of that of the current pair,
				// switch the colors on the current pair
				if (prevPair.getColor1() == curPair.getColor1() || prevPair.getColor2() == curPair.getColor2()) {
					c1IsFb1 = false;
					char temp = curPair.getColor1();
					curPair.setColor1(curPair.getColor2());
					curPair.setColor2(temp);
				}
			}
			solutionCubes[cubeNum].setFB(curPair);
		}

		// SETTING AUX LR PAIRS

		Pair[][] out = new Pair[4][3];

		for (int idx = 0; idx < originalCubes.length; idx++) {
			Pair[] originalCube = { originalCubes[idx].getUpDown(), originalCubes[idx].getFrontBack(),
					originalCubes[idx].getLeftRight() };
			Pair[] solutionCube = { solutionCubes[idx].getUpDown(), solutionCubes[idx].getFrontBack(),
					solutionCubes[idx].getLeftRight() };
//			System.out.println("Debug:idx:"+idx);
//			System.out.println("Debug:original cube:"+Arrays.toString(originalCube));
//			System.out.println("Debug:solution cube:"+Arrays.toString(solutionCube));
			boolean[] hasBeenMapped = {false, false};
			
			for (int i = 0; i<3; i++){
				boolean isAux = true;
				for (int j = 0; j<2; j++){
//					System.out.println("Debug:originalCube[j].hashCode()="+originalCube[i].hashCode());
//					System.out.println("Debug:solutionCube[i].hashCode()="+solutionCube[j].hashCode());
					if (!hasBeenMapped[j] && (originalCube[i].hashCode()==solutionCube[j].hashCode())){
//						System.out.println("Debug:"+hasBeenMapped);
						isAux = false;
						hasBeenMapped[j] = true;
					}
				}
				if (isAux){
					solutionCube[2] = originalCube[i];
				}
			}
			out[idx] = solutionCube;
		}
		
		
//		for (Pair[] p: out)
//			System.out.println(Arrays.toString(p));
		
		
		return out;

	}

	public DisplaySolutions(ArrayList<Pair[][]> solutions, Cube[] originalCubes) {
		// Create test solutions
//		ArrayList<Pair[][]> testInSolutions = this.createTestInputSolutions();
//		ArrayList<Pair[][]> testOutSolutions = new ArrayList<Pair[][]>();
//		Cube[] cube = this.createTestOriginalCubes();
//		for (int i = 0; i< testInSolutions.size(); i++){
//			testOutSolutions.add(this.mapToCube(testInSolutions.get(i), cube));
//			
//		}
		ArrayList<Pair[][]> outSolutions = new ArrayList<Pair[][]>();
		
		for (int i = 0; i< solutions.size(); i++){
			outSolutions.add(this.mapToCube(solutions.get(i), originalCubes));
			
		}

		frameWidth = CUBE_WIDTH * (4 * 4 + 2);
		frameHeight = CUBE_WIDTH * (6 * 2);

		JFrame frame = new JFrame();
		Image cubepic = (new ImageIcon("Cubes.jpg")).getImage();
		frame.setIconImage(cubepic);
		frame.setBackground(Color.BLACK);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Solutions");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SolutionComponent component = new SolutionComponent(outSolutions, CUBE_WIDTH);
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
