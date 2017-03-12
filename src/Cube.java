
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
		return {LR, UD, FB};
	}
	
	//Don't think we need linked list anymore.
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


