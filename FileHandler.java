import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {

	//rewrites files with same name
	//CHANGE: check if file already exists, make sure user wants to overwrite it
	//saves array into file
	public static void save(String userName, String[] data) throws IOException{
		// have uhh file name to save to in
		String address = ("C:\\Simulator\\" + userName + ".txt");
		// Create a BufferedWriter around a FileWriter.
        BufferedWriter writer = new BufferedWriter(new FileWriter(address));
        // Write these lines to the file.
        // ... We call newLine to insert a newline character.

        for(int i=0; i<data.length; i++){
        	writer.write(data[i]);
        	if(i != data.length - 1){
        		writer.newLine();
        	}
        }
        writer.close();
	}

	//load contents of file into array
	public static String[] load(String userName) throws IOException{
		String address = ("C:\\Simulator\\" + userName + ".txt");

		BufferedReader in = new BufferedReader(new FileReader(address));
		String str=null;
		ArrayList<String> lines = new ArrayList<String>();
		while((str = in.readLine()) != null){
		    lines.add(str);
		}

		return lines.toArray(new String[lines.size()]);
	}

	//does not overwrite folder if it already exists
	public static void createDir() throws IOException {
		Files.createDirectories(Paths.get("C:\\Simulator"));
	}


	public static void direct(String[] data) throws IOException {
		switch (Integer.parseInt(data[3])) {
		case 0:
			Display.blackScreen("Welcome to Urashina, a place full of unique opportunities and characters eager to meet you. ",
					"As a new student at Miyazaki High School, you should take your time to explore this unusual",
					"town and all that it has to offer. Good luck, and have fun!");
			break;
		case 1:
			Display.inGame("schoolclassroom.jpg", "", "3:01PM",
					"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
					"not looking forward to going home. The weatherman didn’t say anything about it",
					"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
			break;
		case 2:

		}
	}

	//checks if game should be "corrupt"
	public static boolean checkCorrupt() {
		if(Files.exists(Paths.get("C:\\Simulator\\corrupt.txt"))) {
		    return true;
		}else {
			return false;
		}
	}

	//adds corrupts file to directory when gone through bad ending
	@SuppressWarnings("resource")
	public static void makeCorrupt() throws IOException {
		String address = ("C:\\Simulator\\corrupt.txt");
		new FileWriter(address);
	}

}
