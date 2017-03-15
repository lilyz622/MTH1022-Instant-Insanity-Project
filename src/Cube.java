public class Cube
{
	
	private Pair LR; 
	private Pair UD;
	private Pair FB;

	public Cube(Pair a, Pair b, Pair c){

		LR = a;
		UD = b;
		FB = c;
	}

	public Pair getLeftRight(){
		return LR;
	}

	public Pair getUpDown(){
		return UD;
	}

	public Pair getFrontBack(){
		return FB;
	} 
	
	public Pair[] getCubePairs()
	{
		Pair [] cubepairs = {LR, UD, FB};
		return cubepairs;
	}
}
