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

	// Not sure if we need the methods below
	public String getBothColors()
	{
		String both = ""+color1+color2;
		return both;
	}

	public String getColorsReverse()
	{	
		String reverse = ""+color2+color1;
		return reverse;
	}

	public String toString()
	{
		return " " +color1+ "-" +color2+ " ";
	}
}