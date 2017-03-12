
public class Pair 
{
	private char color1;
	private char color2;

	
	public Pair(char a, char b)
	{	
		color1 = a;
		color2 = b;
	}
	

	public char getColor1(){
		return color1;
	}


	public char getColor2()
	{
		return color2;
	}

	/* // Not sure if we need the methods below
	public String getBothColors()
	{
		return color1+color2;
	}

	public String getColorsReverse()
	{	
		return color2+color1;
	} */

	public String toString()
	{
		return " " +color1+ "-" +color2+ " ";
	}
}
