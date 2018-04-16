import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
	
	//rewrites files with same name
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
	
	public static void load(String loadName){
		
	}
	
	public static void main(String[] args) throws IOException{
		// save(some string for file name, array of info);
	}
}
