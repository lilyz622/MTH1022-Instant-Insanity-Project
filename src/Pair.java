import java.awt.Color;

public class Pair {
	private char color1;
	private char color2;

	public Pair(char a, char b) {
		color1 = a;
		color2 = b;
	}

	public char getColor1() {
		return color1;
	}

	public char getColor2() {
		return color2;
	}

	public void setColor1(char color1) {
		this.color1 = color1;
	}

	public void setColor2(char color2) {
		this.color2 = color2;
	}

	public String toString() {
		return " " + color1 + "-" + color2 + " ";
	}

	@Override
	public int hashCode() {
		int sum = 0;
		switch (color1) {
		case 'R':
			sum += 2;
			break;
		case 'B':
			sum += 3;
			break;
		case 'G':
			sum += 5;
			break;
		case 'W':
			sum += 7;
			break;
		default:
			System.out.println("Hashcode error");
			return -1;
		}

		switch (color2) {
		case 'R':
			sum += 2;
			break;
		case 'B':
			sum += 3;
			break;
		case 'G':
			sum += 5;
			break;
		case 'W':
			sum += 7;
			break;
		default:
			System.out.println("Hashcode error");
			return -1;
		}

		return sum;
	}

}
