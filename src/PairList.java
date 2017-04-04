import java.util.ArrayList;
import java.util.HashSet;

public class PairList {
	private static int HASH_CONSTANT = 23;

	/*
	 * returns a list of all subgraphs. A subgraph at this stage is strictly
	 * defined as an ordered combination of one pair of each cube, i.e.
	 * each cube contributes at most one edge or one loop.
	 */
	public static ArrayList<Pair[]> createSubgraphs(Cube c1, Cube c2, Cube c3, Cube c4)
	{
		ArrayList<Pair[]> allSubgr = new ArrayList<Pair[]>();
		for (int i=0; i<3; i++)
		{
			Pair [] oneSubgr = new Pair[4];
			oneSubgr[0] = c1.getCubePairs()[i];
			for (int j=0; j<3; j++)
			{
				oneSubgr[1] = c2.getCubePairs()[j];
				for (int h=0; h<3; h++)
				{
					oneSubgr[2] = c3.getCubePairs()[h];
					for (int k=0; k<3; k++)
					{
						oneSubgr[3] = c4.getCubePairs()[k];
						allSubgr.add(oneSubgr);
						oneSubgr = new Pair[]{c1.getCubePairs()[i],c2.getCubePairs()[j],c3.getCubePairs()[h],c4.getCubePairs()[k]};
					}
				}
			}
		}
		return allSubgr;
	}
	
	/**
	 * returns a list of all valid subgraphs. A valid subgraph is herein defined as 
	 * a two-degree graph having at most one edge (or loop) from each cube.  
	 */
	public static ArrayList<Pair[]> findAllValidSubgraphs(ArrayList<Pair[]> allSubgr) {
		ArrayList<Pair[]> allValidSubgr = new ArrayList<Pair[]>();
		for (Pair[] element : allSubgr) {
				int countR = countColor(element, 'R'), 
					countW = countColor(element, 'W'), 
					countG = countColor(element, 'G'),
					countB = countColor(element, 'B');

			if (countR == 2 && countW == 2 && countG == 2 && countB == 2)
			{
				allValidSubgr.add(element);
			}
		}
		return allValidSubgr;
	}

	/**
	 * returns a list of graph-wise solutions, which are couples of valid subgraphs.
	 * A graph-wise solution can be used to construct a final solution, which is the 
	 * particular arrangement of the four cubes that win the challenge.
	 * @param a list of all valid subgraphs
	 * @return a list of all graph solutions 
	 */
	public static ArrayList<Pair[][]> findGraphsSolutions(ArrayList<Pair[]> validSubs)
	{
		// ArrayList of solutions, which are couples of valid subgraphs
		ArrayList<Pair[][]> solutions = new ArrayList<Pair[][]>();
		HashSet<Integer> uniqueSolutions = new HashSet<Integer>();
		int i=0;
		while (i < validSubs.size() - 1){
			for (int j=i+1; j < validSubs.size(); j++)
			{
				if (checkEdgeDisjoint(validSubs.get(i), validSubs.get(j))){    
				//validSubs.get(k) returns the element kth of the ArrayList, which is an ARRAY of pairs, not a pair of faces
					Pair[][] solution = {validSubs.get(i),validSubs.get(j)};
					// only add solution if the solution is unique
					if (!uniqueSolutions.contains(hashSolution(solution))){
						solutions.add(solution);
						uniqueSolutions.add(hashSolution(solution));
					}
				}
				
			}
			i++;
		}
		return solutions;

	}
	
	private static int hashSolution(Pair[][] solution) 
	{
		int hashCode = 0;
		// first subgraph in solution
		for (int i = 0; i<solution[0].length; i++){
			hashCode = HASH_CONSTANT*hashCode+solution[0][i].hashCode();
		}
		// second subgraph in solution
		for (int i = 0; i<solution[1].length; i++){
			hashCode = HASH_CONSTANT*hashCode+solution[1][i].hashCode();
		}
		return hashCode;
	}

	/**
	 * counts the degree of a graph's vertex
	 * @param oneSubgr: a graph, color: a vertex
	 * @return the degree of the specified vertex
	 */
	static int countColor(Pair[] oneSubgr, char color)
	{
		int count = 0;
		for (int i=0; i<oneSubgr.length; i++)
		{
			if (oneSubgr[i].getColor1() == color)
				count += 1;
			if (oneSubgr[i].getColor2() == color)
				count += 1;
		}
		return count;
	}

	/**
	 * checks if the two subgraphs passed in as parameters are edge-disjoint.
	 * Edge-disjoint graphs have no edges in common.
	 * @param two subgraphs
	 * @return false if there exists a common edge; true otherwise.
	 */
	private static boolean checkEdgeDisjoint(Pair[] subGr1, Pair[] subGr2) {
		for (int i=0; i < subGr1.length; i++)
		{
			if (subGr1[i].equals(subGr2[i]))  
			//compare a Pair object with a Pair object by their addresses. 
			//We already know same index means same cube, so we check to make sure no cube contributes a single edge to two different subgraphs, 
			//since a Pair in the solution cannot be both, say, a top-bottom and a left-right, of the same cube at the same time.
				return false;
		}
		return true;
	}

	public static String toString(Pair [] arr)
	{
		String str = "";
		for (int i=0; i < arr.length-1; i++)
		{
			str += arr[i].toString() + " | ";
		}
		str += arr[arr.length-1];
		return str;
	}

	public static String toString(ArrayList<Pair[]> arrLi)
		{
			String str = "";
			for (Pair[] element : arrLi)
			{
				str += (arrLi.indexOf(element)+1) + ". " + toString(element) +"\n";
			}
		System.out.println("There is/are " +arrLi.size()+ " valid subgraph(s)");
		return str;
	}
	
	public static String matrixToString(ArrayList<Pair[][]> arrLi)
	{
		String str = "";
		for (Pair[][] element : arrLi)
		{
			str += (arrLi.indexOf(element)+1) + ". " +toString(element) + "\n";
		}
		System.out.println("There is/are " +arrLi.size()+ " graph solution(s)");
		return str;
	}
	
	private static String toString(Pair[][] matrx)
	{
		String str = "";
		str += toString(matrx[0]) + " /// " + toString(matrx[1]);
		return str;
	}
	
}
