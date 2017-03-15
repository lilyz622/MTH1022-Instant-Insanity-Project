import javax.swing.*;
public class Main {
public static void main(String[] args) {
	
	ImageIcon cubepic = new ImageIcon("Cubes.jpg");
	JOptionPane.showMessageDialog(null, 
							      "This program is designed to determine any\n"
							      + "solutions to the Four Cubes Puzzle, given\n"
							      + "that there are any solutions to be found.\n"
							      + "As a user, you will be asked to enter input\n"
							      + "which will represent the colors of the faces\n"
							      + "of a given cube. This will be done in pairs of\n"
							      + "characters representing the colors of (6) faces\n"
							      + "or (3) pairs of colors on a given cube, for a\n"
							      + "total of (4) cubes."
							      + "Press OK to continue or Cancel to exit.",
								  "THE FOUR CUBES", 
								  JOptionPane.OK_CANCEL_OPTION, cubepic);

	char inputColorA;
	char inputColorB;
	
	Object[] possibilities = {"WW", "WG", "WB", "WR",
							  "GW", "GG", "GB", "GR",					
							  "BW", "BG", "BB", "BR",
							  "RW", "RG", "RB", "RR"};
	
	String option = (String)JOptionPane.showInputDialog(
	                    null,
	                    "Please enter Pair 1: ",
	                    "Cube 1",
	                    JOptionPane.QUESTION_MESSAGE,
	                    cubepic,
	                    possibilities,
	                    possibilities[0]);
	
	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);
	
	Pair P1 = new Pair(inputColorA, inputColorB);
	
	/////////////////////////////////////////////
	
	option = (String)JOptionPane.showInputDialog(
            null,
            "Please enter Pair 2: ",
            "Cube 1",
            JOptionPane.QUESTION_MESSAGE,
            cubepic,
            possibilities,
            possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);
	
	Pair P2 = new Pair(inputColorA, inputColorB);
	
	/////////////////////////////////////////////
	
	option = (String)JOptionPane.showInputDialog(
            null,
            "Please enter Pair 3: ",
            "Cube 1",
            JOptionPane.QUESTION_MESSAGE,
            cubepic,
            possibilities,
            possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);
	
	Pair P3 = new Pair(inputColorA, inputColorB);

	Cube C1 = new Cube(P1, P2, P3);
	
	//////////////////////////////////////////////////////////////////////
	
	option = (String)JOptionPane.showInputDialog(
            null,
            "Please enter Pair 1: ",
            "Cube 2",
            JOptionPane.QUESTION_MESSAGE,
            cubepic,
            possibilities,
            possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P4 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 2: ",
		"Cube 2",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P5 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 3: ",
		"Cube 2",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P6 = new Pair(inputColorA, inputColorB);
	
	Cube C2 = new Cube(P4, P5, P6);
	
	//////////////////////////////////////////////////////////////////////////
	
	option = (String)JOptionPane.showInputDialog(
            null,
            "Please enter Pair 1: ",
            "Cube 3",
            JOptionPane.QUESTION_MESSAGE,
            cubepic,
            possibilities,
            possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P7 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 2: ",
		"Cube 3",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P8 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 3: ",
		"Cube 3",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P9 = new Pair(inputColorA, inputColorB);
	
	Cube C3 = new Cube(P7, P8, P9);
	
	/////////////////////////////////////////////////////////////////
	
	option = (String)JOptionPane.showInputDialog(
            null,
            "Please enter Pair 1: ",
            "Cube 4",
            JOptionPane.QUESTION_MESSAGE,
            cubepic,
            possibilities,
            possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P10 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 2: ",
		"Cube 4",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P11 = new Pair(inputColorA, inputColorB);

	/////////////////////////////////////////////

	option = (String)JOptionPane.showInputDialog(
		null,
		"Please enter Pair 3: ",
		"Cube 4",
		JOptionPane.QUESTION_MESSAGE,
		cubepic,
		possibilities,
		possibilities[0]);

	inputColorA = option.charAt(0);
	inputColorB = option.charAt(1);

	Pair P12 = new Pair(inputColorA, inputColorB);
	
	Cube C4 = new Cube(P10, P11, P12);
	
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////
	
	}
}
