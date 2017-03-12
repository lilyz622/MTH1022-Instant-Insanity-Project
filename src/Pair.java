public class Pair 
{
	private char color1;
	private char color2;

	
	public Pair(char a, char b)
	{	
		color1 = a;
		color2 = b;
	}
	
	
	public char getColor1()
	{
		return color1;
	}


	public char getColor2()
	{
		return color2;
	}


	public String getBothColors()
	{
		return col1+col2;
	}

	
	public String getColorsReverse()
	{	
		return col2+col1;
	}
	
	public String toString()
	{
		return " " +col1+ "-" +col2+ " ";
	}
}