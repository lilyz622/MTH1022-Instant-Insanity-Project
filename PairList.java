public class PairList
{
	
	/* returns a list of all subgraphs. A subgraph at this stage is strictly defined as an ordered combination of one pair of each cube */
	public ArrayList<Pair[]> createSubgraphs(Cube c1, Cube c2, Cube c3, Cube c4)
	{
		ArrayList<Pair[]> allSubgr = new ArrayList<Pair[]>;
		
		for (int count=1; count<=81; count++)
		{
			Pair [] oneSubgr = new Pair[4];
			for (int i=0; i<3; i++)
			{
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
		}
		return allSubgr;
	}	
	
	public ArrayList<Pair[]> findAllValidSubgraphs(ArrayList<Pair[]> allSubgr)
	{
		ArrayList<Pair[]> allValidSubgr = new ArrayList<Pair[]>();
		for (Pair[] element : allSubgr)
		{
			int countR = countRed(element),
				countW = countWhite(element),
				countG = countGreen(element),
				countB = countBlue(element);
				
			if (countR == 2 &&
				countW == 2 &&
				countG == 2 &&
				countB == 2)
				allValidSubgr.add(element);
		}
		return allValidSubgr;
	}
	
	
	public void findAllSolutions(ArrayList<Pair[]> validSubs)
	{
		int i=0;
		while (i < validSubs.size() - 1)
			for (int j=i+1; j < validSubs.size(); j++)
			{
				if (checkUnique(validSubs.get(i), validSubs.get(j)) == true))
					System.out.println(validSubs.get(i), validSubs.get(j));
			}
	}
	
	
	public static int countRed(Pair[] oneSubgr)
	{
		int countR = 0;
		for (int i=0; i<oneSubgr.length; i++)
		{
			if oneSubgr[i].getColor1() == 'R'
				countR += 1;
			if oneSubgr[i].getColor2() == 'R'
				countR += 1;
		}
		return countR;
	}
	
	public static int countWhite(Pair[] oneSubgr)
	{
		int countW = 0;
		for (int i=0; i<oneSubgr.length; i++)
		{
			if oneSubgr[i].getColor1() == 'W'
				countW += 1;
			if oneSubgr[i].getColor2() == 'W'
				countW += 1;
		}
		return countW;
	}
	
	public static int countGreen(Pair[] oneSubgr)
	{
		int countG = 0;
		for (int i=0; i<oneSubgr.length; i++)
		{
			if oneSubgr[i].getColor1() == 'G'
				countG += 1;
			if oneSubgr[i].getColor2() == 'G'
				countG += 1;
		}
		return countG;
	}
	
	public static int countBlue(Pair[] oneSubgr)
	{
		int countB = 0;
		for (int i=0; i<oneSubgr.length; i++)
		{
			if oneSubgr[i].getColor1() == 'B'
				countB += 1;
			if oneSubgr[i].getColor2() == 'B'
				countB += 1;
		}
		return countB;
	}
	
	public static boolean checkUnique(Pair thisPair, Pair otherPair)
	{
		String ver11 = thisPair.getBothColors(),
			   ver21 = otherPair.getBothColors(),
			   ver22 = otherPair.getColorsReverse();
		if ((ver11.equals(ver21)) || (ver11.equals(ver22)))
			return false;
		else return true;
	}
}	