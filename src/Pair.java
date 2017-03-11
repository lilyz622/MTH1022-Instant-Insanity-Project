public class Pair 
{
	char col1;
	char col2;

	
	public Pair(char one, char two)
	{	
		col1 = one;
		col2 = two;
	}
	
	
	public char getColor1()
	{
		return col1;
	}


	public char getColor2()
	{
		return col2;
	}


	public String getBothColors()
	{
		return col1+col2;
	}

	
	public String getColorsReverse()
	{	
		return col2+col1;
	}
}