import java.util.ArrayList;

public class PairList {

	/*
	 * returns a list of all subgraphs. A subgraph at this stage is strictly
	 * defined as an ordered combination of one pair of each cube
	 */
	public ArrayList<Pair[]> createSubgraphs(Cube c1, Cube c2, Cube c3, Cube c4)
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
					}
				}
			}
		}
		return allSubgr;
	}

	public ArrayList<Pair[]> findAllValidSubgraphs(ArrayList<Pair[]> allSubgr) {
		ArrayList<Pair[]> allValidSubgr = new ArrayList<Pair[]>();
		for (Pair[] element : allSubgr) {
			int countR = countColor(element, 'R'), 
					countW = countColor(element, 'W'), 
					countG = countColor(element, 'G'),
					countB = countColor(element, 'B');

			if (countR == 2 && countW == 2 && countG == 2 && countB == 2)
				allValidSubgr.add(element);
		}
		return allValidSubgr;
	}

	public void findAllSolutions(ArrayList<Pair[]> validSubs)
	{
		// ArrayList of solutions, which are couples of valid subgraphs
		ArrayList<Pair[][]> solutions = new ArrayList<Pair[][]>();
		int i=0;
		while (i < validSubs.size() - 1){
			for (int j=i+1; j < validSubs.size(); j++)
			{
				/*
				if (checkUnique(validSubs.get(i), validSubs.get(j))){    
				*wrong parameter here, validSubs.get(k) returns the element kth of the ArrayList, which is an ARRAY of pairs, not a pair of faces
					System.out.println(validSubs.get(i)+ "," +validSubs.get(j));
					Pair[][] solution = {validSubs.get(i),validSubs.get(j)};
					solutions.add(solution);
				} 
				*
				*/
				
			}
			i++;
		}
	}

	public static int countColor(Pair[] oneSubgr, char color)
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

	//still thinking to correct this method
	/* public boolean checkUnique(Pair thisPair, Pair otherPair) {
		if (thisPair and otherPair are from the same cube)
		{
			if (thisPair.equals(otherPair))
				return false;
			return true;
		else 
		{
			String ver11 = thisPair.getBothColors(), 
				ver21 = otherPair.getBothColors(),
				ver22 = otherPair.getColorsReverse();
			if ((ver11.equals(ver21)) || (ver11.equals(ver22)))
				return false;
			else
				return true;
		}
		}	
	} */
}