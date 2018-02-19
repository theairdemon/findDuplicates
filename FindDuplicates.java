import java.io.*;
import java.util.*;

public class FindDuplicates {
  private static String nameOfFile = "sample.txt";	//location of text file
  private static String nameOfFileND = "sample_no_duplicates.txt";	//location of text file
	private static Scanner scanner = new Scanner( System.in );		//scanner
	private static WriteFile newData = new WriteFile(nameOfFileND, true);	//new WriteFile
  private static ArrayList<String> noDuplicates = new ArrayList<String>();
  private static int dTime = 50;

  public static void main (String[] args){
    readTextFile(nameOfFile);
  }

  public static void readTextFile(String nameFile) {
		//The name of the file to open
				String fileName = nameFile;

				//This will reference the one line at a time
				String line = null;

				try {
					//FileReader reads the text files in the default encoding
					//FileReader fileReader = new FileReader(fileName);
					//System.out.println("hi");

					//Always wrap FileReader in BufferedReader
					BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

					while ((line = bufferedReader.readLine()) != null){
            if (!noDuplicates.contains(line)){
              noDuplicates.add(line);
              newData.writeToFile(line);
            }
					}

					//Always close files
					bufferedReader.close();
					return;

				}

				catch(FileNotFoundException ex){
					typeWrite("Unable to open file '" + fileName + "'", dTime/2);
					return;

				}

				catch(IOException ex) {
					typeWrite("Error reading file '" + fileName + "'", dTime);
					//Or we could just do this:
					//ex.printStackTrace();
					return;

				}

	}
  public static void typeWrite(String printOut, int delay){
    String text = printOut;
    for(int i = 0; i < text.length(); i++){
      System.out.printf("%c", text.charAt(i));
      try{
          Thread.sleep(delay);//0.5s pause between characters
      }catch(InterruptedException ex){
          Thread.currentThread().interrupt();
      }
    }
    System.out.println(" ");
  }
}
