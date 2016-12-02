
public class NumberPad {
	
	private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int number;
	
	public NumberPad() {
		number = -1;
	}
	
	public int getNextNumber(char cmd) {
		switch(cmd) {
		case 'U':
		case 'D':
		case 'L':
		case 'R':
		default:
			System.out.println("Invalid command has been provided.");
			System.exit(1);
		}
		return -1;
	}
	
	public int getNumber() {
		return number;
	}

}
