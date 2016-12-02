
public class NumberPad {
	
	/**
	 * Fields required by the number pad
	 * number represents the current number status
	 * numbers refers to the array of numbers for navigation
	 */
	private int number;
	private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	
	/**
	 * Constructor to indicate the start number.
	 * @param number The indicated start number.
	 */
	public NumberPad(int number) {
		this.number = number;
	}
	
	/**
	 * Navigates through the array of numbers and finds 
	 * the new number based on the given command.
	 * @param cmd The command given to navigate.
	 * @return The number based off of the command given.
	 */
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
	
	/**
	 * Indicates the current number on the pad.
	 * @return The current number.
	 */
	public int getNumber() {
		return number;
	}

}
