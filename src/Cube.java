import java.util.Arrays;

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
	
	public Cube(Pair[] p){
		UD = p[0];
		FB = p[1];
		LR = p[2];
	}
	
	public Cube(){
		LR = null;
		UD = null;
		FB = null;
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
	
	
	public void setLR(Pair lR) {
		LR = lR;
	}

	public void setUD(Pair uD) {
		UD = uD;
	}

	public void setFB(Pair fB) {
		FB = fB;
	}

	public Pair[] getCubePairs()
	{
		Pair [] cubepairs = {UD, FB, LR};
		return cubepairs;
	}
	
	public String toString(){
		return Arrays.toString(this.getCubePairs());
	}
}
