import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {

	// rewrites files with same name
	// CHANGE: check if file already exists, make sure user wants to overwrite it
	// saves array into file
	public static void save(String userName, String[] data) throws IOException {
		// have uhh file name to save to in
		String address = ("C:\\Simulator\\" + userName + ".txt");
		// Create a BufferedWriter around a FileWriter.
		BufferedWriter writer = new BufferedWriter(new FileWriter(address));
		// Write these lines to the file.
		// ... We call newLine to insert a newline character.

		for (int i = 0; i < data.length; i++) {
			writer.write(data[i]);
			if (i != data.length - 1) {
				writer.newLine();
			}
		}
		writer.close();
	}

	// load contents of file into array
	public static String[] load(String userName) throws IOException {
		String address = ("C:\\Simulator\\" + userName + ".txt");

		BufferedReader in = new BufferedReader(new FileReader(address));
		String str = null;
		ArrayList<String> lines = new ArrayList<String>();
		while ((str = in.readLine()) != null) {
			lines.add(str);
		}

		return lines.toArray(new String[lines.size()]);
	}

	// does not overwrite folder if it already exists
	public static void createDir() throws IOException {
		Files.createDirectories(Paths.get("C:\\Simulator"));
	}

	public static void direct(String[] data) throws IOException {
		switch (Integer.parseInt(data[3])) {
		case 0:
			Display.blackScreen(
					"Welcome to Urashina, a place full of unique opportunities and characters eager to meet you. ",
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
					"lived here for only two months, it feels like home already and you smile to yourself.", "");
			break;
		case 10:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("townstreet.jpg", "carl_happy.png", "CARL",
					"Excuse me, but do you know the way to Miyazaki High School? I’m a transfer student from Kyoto",
					"and these mountain roads got me turned around.", "");
			break;
		case 11:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.response("townstreet.jpg",
					"'Of course, go down this road and take a left after the bridge. It’s right there.'",
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
			Display.inGame("house.png", "mandv_happy.png", "VITA", "Is this where you live?", "", "");
			break;
		case 15:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.inGame("house.png", "mandv_happy.png", "MORT", "Is this where you live?", "", "");
			break;
		case 16:
			Display.response("house.png", "'Yes, you two are in my history class, right?'", "'Do I know you?'");
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
						"town is certainly full of interesting people. You can't wait to see what tomorrow brings.",
						"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 23:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.dayTransition(1);
			break;
		case 24:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				data[3] = "25";
				Display.inGame("schooloutside.jpg", "", "11:50AM",
						"School got out early today. You’re very happy to leave and enjoy your lunch somewhere ",
						"on the town. You’re not sure what you want to eat yet, but you’re very hungry.", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 25:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("schooloutside.jpg", "Eat a light meal at a cafe in the heart of town.",
						"Eat at the new ramen place in the metro station.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 26:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 27:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("cafeinside.png", "Approach them and help pay for their meal.",
						"Ignore them and finish your meal.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 28:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 29:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("cafeoutside.png", "long_happy.png", "12:34PM",
						"You end up sitting with the tall boy, talking about school and enjoying your meals. You chat outside for a moment ",
						"before you leave.", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 30:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("cafeoutside.png", "long_happy.png", "LONG",
						"Thank you again for your help, you were lovely company.  I’d love to hang out with you another time, my treat!",
						"", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 31:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("cafeoutside.png", "Agree with them and exchange numbers.",
						"Keep it professional and explain you were just being nice.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 32:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 33:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("cafeoutside.png", "long_blush.png", "LONG", "I-I’ll see you around then!", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 34:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("ramen.jpg", "Ask if they mind having company for lunch.",
						"Sit towards the back of the small restaurant.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 35:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 36:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("ramen.jpg", "yes_sad.png", "12:12PM",
						"You assure your classmate that there’s nothing to worry about, and that you would love to sit",
						"with him. As you talk, you notice they are reluctant to meet your glance. ", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 37:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("ramen.jpg", "Ask them if there is something wrong.",
						"Ignore their behavior and continue talking.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 38:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 39:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("ramen.jpg", "yes_blush.png", "12:16PM",
						"You laugh in reply to your classmate’s cute comment, prompting a slight blush from them. You",
						"tell them you’re enjoying your time with them and hope to soothe their nerves.", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 40:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("ramen.jpg", "yes_blush.png", "YES",
						"Thank you f-for being so kind! Not many people treat me like that anymore… Would you like to go out",
						"to eat again another time?", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 41:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("ramen.jpg", "Tell them you would love to spend more time with them.",
						"Turn their offer down.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 42:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 43:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_happy.png", "1:03PM",
						"After lunch, you find yourself wandering to the park. There’s a comfy bench with your name on it right",
						"under a sakura tree. As you approach it, a boxy classmate you recognize sits right in the middle.",
						"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 44:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("park.jpg", "Ask the classmate if they would mind if you sat there.",
						"Shrug and walk off to the other corner of the park.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 45:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 46:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_happy.png", "1:07PM",
						"The box boy stammers with a mouth full of peanuts, scooching over quickly. He pats the space next",
						"to him, gesturing for you to sit down. As you sit down next to him, he starts to talk about his day.",
						"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 47:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_happy.png", "CARL",
						"-And I couldn’t believe what the lady at the counter said to me! I was only trying to be nice…",
						"", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 48:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_happy.png", "1:10PM",
						"You notice that CARL has stray peanuts on his cheek.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 49:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("park.jpg", "Tell him he has peanuts on his cheek",
						"Wipe the peanuts off his cheek for him.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 50:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 51:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_happy.png", "CARL",
						"Yeah, I’m not even supposed to be eating peanuts, I’m actually pretty allergic to them. But they ",
						"taste so good!", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 52:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("park.jpg", "Offer him the walnuts in your bag.", "Roll your eyes.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 53:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 54:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("park.jpg", "carl_sad.png", "CARL",
						"Actually... I'm feeling a bit sick now... Can I make this up to you a different time?", "",
						"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 55:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("park.jpg", "Agree to hang out another time.", "Let him down nicely.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 56:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 57:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "Hello " + data[1] + ".", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 58:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("parkcorner.jpg", "mandv_happy.png", "VITA", "Nice of you to drop by.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 59:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "What brings you here?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 60:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("parkcorner.jpg", "Just stopping by.", "Change your mind and head home.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 61:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 62:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "Come, take a seat.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 63:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("parkcorner.jpg", "Decline and be on your way.", "Sit with them.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 64:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 65:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "We have business to attend to.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 66:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("parkcorner.jpg", "Exclaim you don't want them to go.", "Shrug and say goodbye.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 67:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 68:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "", "8:15PM",
						"After a long day out on the town, you finally reach home. It’s only 8pm, but you decide on an early night.",
						"Something tells you tomorrow is going to be a big day.", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 69:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.dayTransition(2);
			break;
		case 70:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 71:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			Display.event("letter.jpg");
			break;
		case 72:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("house.png", "Respond to Long's letter.", "Ignore the letter and head to the store.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 73:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 74:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("phone.jpg", "", "9:01AM",
						"Hey. It’s Yes. I found you on Twotter and I thought it would be alright to add you. I’ve been thinking",
						"about some stuff recently and I wanted to talk to you about it. I’ll be blunt because I don’t really know",
						"know how to say it. Do you want to go out with me?");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 75:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("phone.jpg", "Reply immediately and agree to go out on a date with Yes.",
						"Leave him on read.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 76:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 77:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("apartment.jpg", "carl_blush.png", "CARL",
						"H-hey. I’m sorry to call you so late I just.. Couldn’t stop thinking about you. I know this is really ",
						"sudden but would you want to go out on… a real date date sometime?", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 78:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("apartment.jpg", "Agree to go out on a date with Carl.", "Turn him down.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 79:
			Display.data[3] = Integer.toString((Integer.parseInt(data[3]) - 1));
			direct(Display.data);
			break;
		case 80:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_happy.png", "MORT", "Hello " + data[1] + ".", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 81:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_blush.png", "VITA", "We are glad you've chosen us.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 82:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_happy.png", "MORT", "You've made the right choice.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 83:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_happy.png", "VITA", "You will not regret this.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 84:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_happy.png", "MORT",
						"You don't really have a choice anymore, do you?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 85:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "But why would you want another choice?", "",
						"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 86:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("house.png", "mandv_happy.png", "M&V", "You will not be mistreated. Let us in please.",
						"", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 87:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("houseinv.png", "Let them in.", "Let them in.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 88:
			Display.blackScreen("", "end.", "");
			break;
		case 101:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "Why did you choose them?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 102:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "What did we do wrong?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 103:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "Were we not good enough?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 104:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "We don't want you with them.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 105:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "You can't be with them.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 106:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "M&V", "Please, come with us.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 107:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("houseinv.png", "Go with them.", "Go with them.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 108:
			Display.blackScreen("", "end.", "");
			break;
		case 109:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "What have you done?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 110:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "Were we not good enough?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 111:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "You didn't even chose them.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 112:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "You chose nobody.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 113:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "We do not settle for 'nobody.'", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 114:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "MORT", "You will be with us.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 115:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "M&V", "We will be with you.", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 116:
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.response("houseinv.png", "Be with them.", "Be with them.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 117:
			Display.blackScreen("", "end.", "");
			break;
		}
	}

	// checks if game should be "corrupt"
	public static boolean checkCorrupt() {
		if (Files.exists(Paths.get("C:\\Simulator\\corrupt.txt"))) {
			return true;
		} else {
			return false;
		}
	}

	// adds corrupts file to directory when gone through bad ending
	@SuppressWarnings("resource")
	public static void makeCorrupt() throws IOException {
		String address = ("C:\\Simulator\\corrupt.txt");
		new FileWriter(address);
	}

}
