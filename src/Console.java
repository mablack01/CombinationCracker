import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Miles Black (mablack01@aol.com)
 *
 */
public class Console {
	
	/**
	 * Fields for the console to run, default pad number is 5 (middle).
	 */
	private static NumberPad pad = new NumberPad(5);
	private static String fileLocation = "./data/input.txt";
	
	/**
	 * The main method that handles the text file input.txt
	 * @param args
	 */
	public static void main(String[] args) {
        File file = new File(fileLocation);
        String line = null;
        String code = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
                code += Integer.toString(processCommand(line));
            bufferedReader.close();
            System.out.println("We have successfully cracked the code: " + code);
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getName() + "'");
            System.exit(2);
        } catch(IOException ex) {
            System.out.println("Error reading file '"  + file.getName() + "'");
            System.exit(3);
        } catch(StringIndexOutOfBoundsException ex) {
            System.out.println("No input detected in file '"  + file.getName() + "'");
            System.exit(4);
        }
	}
	
	/**
	 * Processes the given commands to crack the code.
	 * @param line The line of commands being parsed.
	 * @return The single digit from the starting code following the commands.
	 */
	public static int processCommand(String line) {
		for(char instr : line.toCharArray())
			pad.getNextNumber(instr);
		pad = new NumberPad(pad.getNumber());
		return pad.getNumber();
	}

}
