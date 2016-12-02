
public class NumberPad {
	
	private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int number;
	
	public NumberPad(int number) {
		this.number = number;
	}
	
	public int getNextNumber(char cmd) {
		switch(cmd) {
		case 'U':
			if (number > 3 && number < 10)
				number = numbers[number - 4];
			break;
		case 'D':
			if (number > 0 && number < 7)
				number = numbers[number + 2];
			break;
		case 'L':
			if (number != 1 && number != 4 && number != 7)
				number = numbers[number - 2];
			break;
		case 'R':
			if (number != 3 && number != 6 && number != 9)
				number = numbers[number];
			break;
		default:
			System.out.println("Invalid command has been provided.");
			System.exit(1);
			break;
		}
		return number;
	}
	
	public int getNumber() {
		return number;
	}

}
