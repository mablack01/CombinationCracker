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
	
	public static int processCommand(String line) {
		NumberPad pad = new NumberPad();
		for(char instr : line.toCharArray()) {
			pad.getNextNumber(instr);
		}
		return pad.getNumber();
	}

}
