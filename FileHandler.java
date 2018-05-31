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
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.blackScreen("Welcome to Urashina, a place full of unique opportunities and characters eager to meet you. ",
					"As a new student at Miyazaki High School, you should take your time to explore this unusual",
					"town and all that it has to offer. Good luck, and have fun!");
			break;
		case 1:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("schoolclassroom.jpg", "", "3:01PM",
					"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
					"not looking forward to going home. The weatherman didn’t say anything about it",
					"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
			break;
		case 2:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
					"Continue out of the classroom and find an umbrella somewhere else.");
			break;
		case 3:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 4:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("schoolclassroom.jpg", "'Thank you!'", "'I'll make sure to return it tomorrow.'");
			break;
		case 5:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
					"Continue out of the classroom and find an umbrella somewhere else.");
			break;
		case 6:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 7:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("schoolcafeteria.jpg", "'I'm sorry, is this yours?'",
					"Shrug and leave to go home with the umbrella.");
			break;
		case 8:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 9:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("townstreet.jpg", "", "3:10PM",
					"You begin your walk home, taking in the sights of the quiet town around you. Despite having",
					"lived here for only two months, it feels like home already and you smile to yourself.",
					"");
			break;
		case 10:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("townstreet.jpg", "carl_happy.png", "CARL",
					"Excuse me, but do you know the way to Miyazaki High School? I’m a transfer student from Kyoto",
					"and these mountain roads got me turned around.", "");
			break;
		case 11:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("townstreet.jpg", "'Of course, go down this road and take a left after the bridge. It’s right there.'",
					"'Ask someone else, I'm in a rush.'");
			break;
		case 12:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 13:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("house.png", "", "3:30PM",
					"Home… finally. You take a deep breath and smile at the sight of your house after a long day of",
					"school.", "");
			break;
		case 14:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("house.png", "mandv_happy.png", "VITA",
					"Is this where you live?",
					"", "");
			break;
		case 15:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("house.png", "mandv_happy.png", "MORT",
					"Is this where you live?",
					"", "");
			break;
		case 16:
			Display.response("house.png", "'Yes, you two are in my history class, right?'",
					"'Do I know you?'");
			break;
		case 17:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 18:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 2));
			direct(Display.data);
			break;
		case 19:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 3));
			direct(Display.data);
			break;
		case 20:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 4));
			direct(Display.data);
			break;
		case 21:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 5));
			direct(Display.data);
			break;
		case 22:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "", "3:44PM",
						"You wave goodbye to Mort and Vita and stretch your arms above your head, yawning. This",
						"town is certainly full of interesting people. You can't wait to see what tomorrow brings.", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 23:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.dayTransition(1);
			break;
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
