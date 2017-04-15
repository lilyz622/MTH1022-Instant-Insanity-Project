import javax.swing.*;
import java.util.*;

public class Main{
	private static Cube C1;
	private static Cube C2;
	private static Cube C3;
	private static Cube C4;
	
	public static void main(String[] args){
		JOptionPane ui = new JOptionPane();
		ArrayList<Pair[][]> finalSolutions = DisplayIntro(ui);
		Cube[] originalCubes = {C1, C2, C3, C4};
		if (!finalSolutions.isEmpty()){
			DisplaySolutions s = new DisplaySolutions(finalSolutions, originalCubes);
		}
		
	}
	
	
	public static ArrayList<Pair[][]> DisplayIntro(JOptionPane ui) {
		ImageIcon cubepic = new ImageIcon("Cubes.jpg");

		JOptionPane.showMessageDialog(null, "This program is designed to determine any\n"
				+ "solutions to the Four Cubes Puzzle, given\n" + "that there are any solutions to be found.\n"
				+ "As a user, you will be asked to enter input\n" + "which will represent the colors of the faces\n"
				+ "of a given cube. This will be done in pairs of\n"
				+ "characters representing the colors of (6) faces\n"
				+ "or (3) pairs of colors on a given cube, for a\n" + "total of (4) cubes.\n\n\n"
				+ "Press OK to continue or Cancel to exit.", "THE FOUR CUBES", JOptionPane.OK_CANCEL_OPTION, cubepic);

		char inputColorA;
		char inputColorB;
		String value1 = null, value2 = null, value3 = null;
		String[] possibilities = { "WW", "WG", "WB", "WR", "GW", "GG", "GB", "GR", "BW", "BG", "BB", "BR", "RW", "RG",
				"RB", "RR" };

		JComboBox field1 = new JComboBox(possibilities);
		JComboBox field2 = new JComboBox(possibilities);
		JComboBox field3 = new JComboBox(possibilities);

		field1.setSelectedItem("GW");
		field2.setSelectedItem("BR");
		field3.setSelectedItem("BW");
		
		
		Object[] message = { "Top-Bottom Pair: ", field1, "Front-Back Pair: ", field2, "Left-Right Pair: ", field3 };

		int X = ui.showConfirmDialog(null, message, "CUBE 1", ui.OK_CANCEL_OPTION,
				ui.QUESTION_MESSAGE, cubepic);
		if (X == ui.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P1 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P2 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P3 = new Pair(inputColorA, inputColorB);

		C1 = new Cube(P1, P2, P3);

		//////////////////////////////////////////////////////////////////////

		field1.setSelectedItem("GR");
		field2.setSelectedItem("WB");
		field3.setSelectedItem("RW");
		
		X = ui.showConfirmDialog(null, message, "CUBE 2", ui.OK_CANCEL_OPTION,
				ui.QUESTION_MESSAGE, cubepic);
		if (X == ui.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P4 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P5 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P6 = new Pair(inputColorA, inputColorB);

		C2 = new Cube(P4, P5, P6);

		//////////////////////////////////////////////////////////////////////////

		field1.setSelectedItem("RG");
		field2.setSelectedItem("WG");
		field3.setSelectedItem("BB");
		
		X = ui.showConfirmDialog(null, message, "CUBE 3", ui.OK_CANCEL_OPTION,
				ui.QUESTION_MESSAGE, cubepic);
		if (X == ui.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P7 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P8 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P9 = new Pair(inputColorA, inputColorB);

		C3 = new Cube(P7, P8, P9);

		/////////////////////////////////////////////////////////////////

		field1.setSelectedItem("RB");
		field2.setSelectedItem("GW");
		field3.setSelectedItem("RR");
		
		X = ui.showConfirmDialog(null, message, "CUBE 4", ui.OK_CANCEL_OPTION,
				ui.QUESTION_MESSAGE, cubepic);
		if (X == ui.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P10 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P11 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P12 = new Pair(inputColorA, inputColorB);

		C4 = new Cube(P10, P11, P12);

		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////

		ArrayList<Pair[]> allsub = PairList.createSubgraphs(C1, C2, C3, C4);
		ArrayList<Pair[]> allValidSub = PairList.findAllValidSubgraphs(allsub);
		ArrayList<Pair[][]> sol = PairList.findGraphsSolutions(allValidSub);

		
		ui.showMessageDialog(null, PairList.matrixToString(sol), "POSSIBLE SOLUTIONS",
				ui.INFORMATION_MESSAGE, cubepic);
		
		return sol;
		
	}
	
	/*public static void main(String[] args) {

		ImageIcon cubepic = new ImageIcon("Cubes.jpg");

		JOptionPane.showMessageDialog(null, "This program is designed to determine any\n"
				+ "solutions to the Four Cubes Puzzle, given\n" + "that there are any solutions to be found.\n"
				+ "As a user, you will be asked to enter input\n" + "which will represent the colors of the faces\n"
				+ "of a given cube. This will be done in pairs of\n"
				+ "characters representing the colors of (6) faces\n"
				+ "or (3) pairs of colors on a given cube, for a\n" + "total of (4) cubes.\n\n\n"
				+ "Press OK to continue or Cancel to exit.", "THE FOUR CUBES", JOptionPane.OK_CANCEL_OPTION, cubepic);

		char inputColorA;
		char inputColorB;
		String value1 = null, value2 = null, value3 = null;
		String[] possibilities = { "WW", "WG", "WB", "WR", "GW", "GG", "GB", "GR", "BW", "BG", "BB", "BR", "RW", "RG",
				"RB", "RR" };

		JComboBox field1 = new JComboBox(possibilities);
		JComboBox field2 = new JComboBox(possibilities);
		JComboBox field3 = new JComboBox(possibilities);

		Object[] message = { "Top-Bottom Pair: ", field1, "Front-Back Pair: ", field2, "Left-Right Pair: ", field3 };

		int X = JOptionPane.showConfirmDialog(null, message, "CUBE 1", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, cubepic);
		if (X == JOptionPane.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P1 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P2 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P3 = new Pair(inputColorA, inputColorB);

		Cube C1 = new Cube(P1, P2, P3);

		//////////////////////////////////////////////////////////////////////

		X = JOptionPane.showConfirmDialog(null, message, "CUBE 2", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, cubepic);
		if (X == JOptionPane.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P4 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P5 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P6 = new Pair(inputColorA, inputColorB);

		Cube C2 = new Cube(P4, P5, P6);

		//////////////////////////////////////////////////////////////////////////

		X = JOptionPane.showConfirmDialog(null, message, "CUBE 3", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, cubepic);
		if (X == JOptionPane.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P7 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P8 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P9 = new Pair(inputColorA, inputColorB);

		Cube C3 = new Cube(P7, P8, P9);

		/////////////////////////////////////////////////////////////////

		X = JOptionPane.showConfirmDialog(null, message, "CUBE 4", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, cubepic);
		if (X == JOptionPane.OK_OPTION) {
			value1 = (String) field1.getSelectedItem();
			value2 = (String) field2.getSelectedItem();
			value3 = (String) field3.getSelectedItem();
		}

		inputColorA = Character.toUpperCase(value1.charAt(0));
		inputColorB = Character.toUpperCase(value1.charAt(1));
		Pair P10 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value2.charAt(0));
		inputColorB = Character.toUpperCase(value2.charAt(1));
		Pair P11 = new Pair(inputColorA, inputColorB);

		inputColorA = Character.toUpperCase(value3.charAt(0));
		inputColorB = Character.toUpperCase(value3.charAt(1));
		Pair P12 = new Pair(inputColorA, inputColorB);

		Cube C4 = new Cube(P10, P11, P12);

		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////
		/////////////////////////////////////////////

		ArrayList<Pair[]> allsub = PairList.createSubgraphs(C1, C2, C3, C4);
		ArrayList<Pair[]> allValidSub = PairList.findAllValidSubgraphs(allsub);
		ArrayList<Pair[][]> sol = PairList.findGraphsSolutions(allValidSub);

		JOptionPane.showMessageDialog(null, PairList.matrixToString(sol), "POSSIBLE SOLUTIONS",
				JOptionPane.INFORMATION_MESSAGE, cubepic);
	}*/
}
