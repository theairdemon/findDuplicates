import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
	private String path;
	private boolean append_to_file = true;

	public WriteFile (String file_path) {
		path = file_path;

	}

	public WriteFile (String file_path, boolean append_value) {
		path = file_path;
		append_to_file = append_value;

	}

	public void writeToFile (String textLine) {
		try {
			FileWriter write = new FileWriter(path, append_to_file);
			PrintWriter print_line = new PrintWriter(write);

			print_line.printf("%s" + "%n", textLine);
			print_line.close();
		}
		catch (IOException e) {
			System.out.println("IOException caught");
		}
	}

}
