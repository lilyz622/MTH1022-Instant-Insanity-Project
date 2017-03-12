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
	
	//trying to implement some kind of linked list structure to the list of pairs, 
	//so that each pair has an identifier different from its own data,
	//which can later be called on to compare Pair with Pair in the PairList.checkUnique() method
	
	/* public Node getCubePairs(this.getCubePairs())
	{
		Node head, newNode;
		head = null;
		for (int i= 2; i >= 0; i--)
		{
			newNode = new Node();
			newNode.info = this.getCubePairs()[i];
			newNode.link = head;
			head = newNode;
		}
		return head;
	} */
}
