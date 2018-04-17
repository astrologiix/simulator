import java.io.BufferedReader;
import java.io.BufferedWriter
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {

	//rewrites files with same name
	//CHANGE: check if file already exists, make sure user wants to overwrite it
	//saves array into file
	public static void save(String saveName, String[] data) throws IOException{
		// have uhh file name to save to in
		//CHANGE: create file in appdata and use user.home instead
		String fileName = System.getProperty("user.dir\\") + saveName + ".txt";
		// Create a BufferedWriter around a FileWriter.
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
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
	public static String[] load(String loadName) throws IOException{
		String fileName = System.getProperty("user.dir\\") + loadName + ".txt";

		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str=null;
		ArrayList<String> lines = new ArrayList<String>();
		while((str = in.readLine()) != null){
		    lines.add(str);
		}

		return lines.toArray(new String[lines.size()]);
	}

	public static void main(String[] args) throws IOException{
		// save(some string for file name, array of info);
	}
}
