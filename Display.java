import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class Display {
	// file name[0], player name[1], gender[2], progress[3], long comp[4], yes
	// comp[5], carl comp[6], m&v comp[7]
	static String[] data = { "fileName", "player name", "gender", "0", "0", "0", "0", "0", "none" };
	static boolean cont = false;

	// title font
	static Font h1 = new Font("courier", Font.PLAIN, 100);
	// heading font
	static Font h2 = new Font("courier", Font.PLAIN, 40);
	// button font
	static Font h3 = new Font("courier", Font.PLAIN, 17);
	// character name font
	static Font h4 = new Font("courier", Font.PLAIN, 25);
	// char dialogue font
	static Font dia = new Font("courier", Font.PLAIN, 20);

	static JFrame jfrm = new JFrame("LuvMi");
	static ImageIcon icon = new ImageIcon("C:\\Simulator\\icon.png");

	static AudioPlayer MGP = AudioPlayer.player;
	static AudioStream BGM;
	AudioData MD;

	public static void def() {
		jfrm.setIconImage(icon.getImage());
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("restriction")
	public static void musicStart(String file) { // Plays the background music
		ContinuousAudioDataStream loop = null;

		try {
			InputStream test = new FileInputStream(file);
			BGM = new AudioStream(test);
			AudioPlayer.player.start(BGM);
			// MD = BGM.getData();
			// loop = new ContinuousAudioDataStream(MD);

		} catch (FileNotFoundException e) {
			System.out.print(e.toString());
		} catch (IOException error) {
			System.out.print(error.toString());
		}
		MGP.start(loop);
	}

	public static void musicStop() {
		// don't try and do things with a null object!
		if (BGM != null) {
			AudioPlayer.player.stop(BGM);
		}
		System.out.println("music stopped");
	}

	public static void title() throws IOException, InterruptedException {
		if (FileHandler.checkCorrupt()) {
			titleCorrupt();
		} else {
			ImageIcon title = new ImageIcon("C:\\Simulator\\titlegif.gif");

			musicStart("C:\\Simulator\\theme.wav");

			JLayeredPane panel = new JLayeredPane();
			ImageIcon bg = new ImageIcon("c:\\Simulator\\bg.jpg");
			JLabel back = new JLabel(bg);
			back.setSize(1400, 900);

			panel.setLayout(null);
			panel.setSize(1400, 900);

			JLabel name = new JLabel(title);
			name.setBounds(800, 25, 588, 495);

			JButton newGame, loadGame, quit;
			newGame = new JButton("NEW GAME");
			newGame.setBounds(70, 600, 250, 40);
			newGame.setBackground(Color.WHITE);
			newGame.setFocusable(false);
			newGame.setFont(h3);
			newGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
					newGame();
				}
			});
			loadGame = new JButton("LOAD GAME");
			loadGame.setBounds(70, 660, 250, 40);
			loadGame.setBackground(Color.WHITE);
			loadGame.setFocusable(false);
			loadGame.setFont(h3);
			loadGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
					loadScreen();
				}
			});
			quit = new JButton("QUIT GAME");
			quit.setBounds(70, 720, 250, 40);
			quit.setBackground(Color.WHITE);
			quit.setFocusable(false);
			quit.setFont(h3);
			quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			panel.add(newGame);
			panel.add(loadGame);
			panel.add(quit);
			panel.add(name);
			panel.add(back);
			panel.moveToBack(back);

			jfrm.getContentPane().add(panel);

			def();

			jfrm.setVisible(true);
		}

	}

	public static void titleCorrupt() throws IOException, InterruptedException {
		ImageIcon title = new ImageIcon("C:\\Simulator\\titlegif.gif");

		musicStart("C:\\Simulator\\themecorrupt.wav");

		ImageIcon bg = new ImageIcon("C:\\Simulator\\bgcorrupt.gif");
		JLabel lab = new JLabel(bg);
		lab.setSize(1400, 900);

		JLayeredPane panel = new JLayeredPane();
		panel.setLayout(null);
		panel.setSize(1400, 900);

		JLabel name = new JLabel(title);
		name.setBounds(800, 25, 588, 495);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				Display.blackScreen("we missed y   ou.", "^sg%^kend.&6aHAsganNN", "Come with Us. ^&q");
			}
		});
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				Display.blackScreen("we missed y   ou.", "^sg%^kend.&6aHAsganNN", "Come with Us. ^&q");
			}
		});
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(lab);
		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(name);

		panel.moveToBack(lab);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);

	}

	public static void routeCheck() {
		if (Integer.parseInt(data[4]) > Integer.parseInt(data[5])) {
			if (Integer.parseInt(data[4]) > Integer.parseInt(data[6])) {
				if (Integer.parseInt(data[4]) > Integer.parseInt(data[7])) {
					data[8] = "long";
				}
			}
		} else if (Integer.parseInt(data[5]) > Integer.parseInt(data[4])) {
			if (Integer.parseInt(data[5]) > Integer.parseInt(data[6])) {
				if (Integer.parseInt(data[5]) > Integer.parseInt(data[7])) {
					data[8] = "yes";
				}
			}
		} else if (Integer.parseInt(data[6]) > Integer.parseInt(data[4])) {
			if (Integer.parseInt(data[6]) > Integer.parseInt(data[5])) {
				if (Integer.parseInt(data[6]) > Integer.parseInt(data[7])) {
					data[8] = "carl";
				}
			}
		} else if (Integer.parseInt(data[7]) > Integer.parseInt(data[4])) {
			if (Integer.parseInt(data[7]) > Integer.parseInt(data[5])) {
				if (Integer.parseInt(data[7]) > Integer.parseInt(data[6])) {
					data[8] = "mandv";
				}
			}
		}else {
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			try {
				Display.inGame("houseinv.png", "mandv_angry.png", "VITA", "What have you done?", "", "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void dayTransition(int day) {
		def();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());

		JLabel text = new JLabel("Day " + day);
		text.setFont(h2);
		text.setForeground(Color.WHITE);
		text.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(text);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (data[3]) {
				case "24":
					try {
						data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
						inGame("schooloutside.jpg", "", "11:50AM",
								"School got out early today. You’re very happy to leave and enjoy your lunch somewhere ",
								"on the town. You’re not sure what you want to eat yet, but you’re very hungry.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					break;
				case "70":
					routeCheck();
					if (data[8].equals("long")) {
						data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
						try {
							inGame("house.png", "", "9:00AM",
									"You’ve just stepped out of the house, ready to go pick up some things to make lunch at the",
									"market. You never really get mail, but you notice the red flag standing up at the box. As you",
									"open the mailbox, you pull out a cream colored letter with " + data[1]
											+ " written on it.");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (data[8].equals("yes")) {
						data[3] = Integer.toString(74);
						try {
							inGame("apartment.jpg", "", "9:00AM",
									"You spend your morning finishing up some homework on your computer and eating a healthy breakfast",
									"of yogurt and peaches. You notice a notification appear on the bottom of your screen from an ",
									"unknown user. Curiously, you decide to click on the message.");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (data[8].equals("carl")) {
						data[3] = Integer.toString(77);
						try {
							inGame("apartment.jpg", "", "9:00AM",
									"You wake up to the sound of your phone buzzing. The sky is still dark out, and you can hear crickets",
									"outside your window. Your clock reads 2:18 AM. You pick up the phone and are greeted with the sound",
									"of Carl’s voice.");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (data[8].equals("mandv")) {
						data[3] = Integer.toString(80);
						try {
							inGame("apartment.jpg", "", "*ph )/%@54",
									"You wake up at around 7 in the morning. You’ve never been a morning person, but something tells you ",
									"to get up. You slump out of bed and head to the door of your apartment to grab the newspaper lounging",
									"outside. As you open the door, you jerk back when faced with Mort and Vita.");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});

		jfrm.add(panel);

		jfrm.setVisible(true);
	}

	public static void blackScreen(String line1, String line2, String line3) {

		def();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());

		JLabel text = new JLabel("<html>" + line1 + "<br>" + line2 + "<br>" + line3 + "</html>");
		text.setFont(h3);
		text.setForeground(Color.white);
		text.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(text);

		jfrm.getContentPane().add(panel);
		jfrm.getContentPane().setBackground(Color.BLACK);
		jfrm.setVisible(true);

		if (line2.contains("end.")) {
			panel.setBackground(Color.RED);
			text.setForeground(Color.BLACK);
		}

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (data[3]) {
				case "0":
					try {
						data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
						inGame("schoolclassroom.jpg", "", "3:01PM",
								"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
								"not looking forward to going home. The weatherman didn’t say anything about it",
								"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					break;
				case "100":
					try {
						data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
						inGame("apartment.jpg", "", "*ph )/%@54",
								"You wake up at around 7 in the morning. You’ve never been a morning person, but something tells you ",
								"to get up. You slump out of bed and head to the door of your apartment to grab the newspaper lounging",
								"outside. As you open the door, you jerk back when faced with Mort and Vita.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "101":
					try {
						data[3] = Integer.toString(109);
						inGame("apartment.jpg", "", "*ph )/%@54",
								"You wake up at around 7 in the morning. You’ve never been a morning person, but something tells you ",
								"to get up. You slump out of bed and head to the door of your apartment to grab the newspaper lounging",
								"outside. As you open the door, you jerk back when faced with Mort and Vita.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

	}

	// display save game screen
	public static void saveScreen() {
		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("LUV MI");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// save game as label
		JLabel lbl = new JLabel("SAVE GAME AS");
		lbl.setFont(h2);
		lbl.setForeground(Color.WHITE);

		// save icon display
		Icon icon = new ImageIcon("C:\\Simulator\\saveicon.jpg");
		JLabel photo = new JLabel(icon);

		// text field for file name specification
		// CHANGE: display confirm dialog if filename already exits in folder
		JTextField fileName = new JTextField(30);
		fileName.setFont(h3);

		// save button
		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(h3);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFocusable(false);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(lbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(fileName, c);
		fileName.setPreferredSize(new Dimension(10, 30));
		c.gridx = 1;
		c.gridy = 3;
		pane.add(saveButton, c);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					data[0] = fileName.getText();
					FileHandler.save(fileName.getText(), data);
				} catch (IOException e1) {
					System.out.println("Save failed.");
				}
				clear();
				try {
					clear();
					title();
				} catch (IOException | InterruptedException e1) {
					System.out.println("Failed.");
				}
			}
		});

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

		jfrm.setVisible(true);
	}

	// display load game screen
	public static void loadScreen() {
		boolean loaded = false;

		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("LUV MI");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// load game label
		JLabel lbl = new JLabel("LOAD GAME FILE");
		lbl.setFont(h2);
		lbl.setForeground(Color.WHITE);

		// load icon display
		Icon icon = new ImageIcon("C:\\Simulator\\saveicon.jpg");
		JLabel photo = new JLabel(icon);

		// text field for file name specification
		// CHANGE: display error if file doesn't exist in folder
		JTextField fileName = new JTextField(30);
		fileName.setFont(h3);

		// load button
		JButton loadButton = new JButton("LOAD");
		loadButton.setFont(h3);
		loadButton.setBackground(Color.WHITE);
		loadButton.setFocusable(false);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(lbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(fileName, c);
		fileName.setPreferredSize(new Dimension(10, 30));
		c.gridx = 1;
		c.gridy = 3;
		pane.add(loadButton, c);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clear();
					data = FileHandler.load(fileName.getText());
					FileHandler.direct(data);
				} catch (IOException e1) {
					System.out.println("Load failed.");
				}
			}
		});

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

		jfrm.setVisible(true);
	}

	public static void newGame() {
		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("HELLO. WELCOME.");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// name text field
		JTextField name = new JTextField(30);
		name.setFont(h3);

		// gender buttons
		JRadioButton male = new JRadioButton("MALE");
		male.setFont(h3);
		male.setOpaque(false);
		JRadioButton female = new JRadioButton("FEMALE");
		female.setFont(h3);
		female.setOpaque(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);

		// start button
		JButton saveButton = new JButton("START");
		saveButton.setFont(h3);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFocusable(false);

		JLabel nameLbl = new JLabel("ENTER NAME");
		nameLbl.setFont(h2);
		nameLbl.setForeground(Color.white);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(nameLbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(name, c);
		name.setPreferredSize(new Dimension(10, 30));

		JPanel button = new JPanel();
		button.setBackground(Color.black);
		button.setLayout(new FlowLayout());
		saveButton.setHorizontalAlignment(JButton.CENTER);
		button.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data[1] = name.getText();
				if (male.isSelected()) {
					data[2] = "male";
				} else if (female.isSelected()) {
					data[2] = "female";
				}
				clear();
				saveScreen();
			}
		});

		JPanel genders = new JPanel();
		genders.setBackground(Color.black);
		genders.setLayout(new FlowLayout());
		male.setHorizontalAlignment(JRadioButton.CENTER);
		male.setForeground(Color.white);
		female.setHorizontalAlignment(JRadioButton.CENTER);
		female.setForeground(Color.white);
		genders.add(male);
		genders.add(female);

		jfrm.setLayout(new GridLayout(4, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(pane);
		jfrm.add(genders);
		jfrm.add(button);

		jfrm.setVisible(true);
	}

	public static void inGame(String background, String charimg, String charname, String line1, String line2,
			String line3) throws IOException {

		JLayeredPane pane = new JLayeredPane();
		pane.setPreferredSize(new Dimension(1400, 900));

		JLabel textbg = new JLabel(new ImageIcon("C:\\Simulator\\textbg.png"));
		JLabel bg = new JLabel(new ImageIcon("C:\\Simulator\\" + background));
		JLabel chara = new JLabel(new ImageIcon("C:\\Simulator\\" + charimg));
		JLabel frame = new JLabel(new ImageIcon("C:\\Simulator\\gamebgt.png"));
		JLabel charaname = new JLabel(charname);
		charaname.setFont(h4);
		JLabel text1 = new JLabel(line1);
		text1.setFont(dia);
		JLabel text2 = new JLabel(line2);
		text2.setFont(dia);
		JLabel text3 = new JLabel(line3);
		text3.setFont(dia);

		pane.add(bg, 0);
		bg.setBounds(0, 0, 1394, 866);
		pane.add(chara, 1);
		chara.setBounds(100, 50, 500, 600);
		frame.setBounds(0, 0, 1394, 866);
		textbg.setBounds(15, 500, 1356, 295);
		pane.add(textbg, 2);
		pane.add(frame, 2);
		pane.add(charaname, 3);
		charaname.setBounds(100, 513, 200, 50);
		charaname.setForeground(Color.white);
		pane.add(text1, 3);
		text1.setBounds(70, 615, 1300, 30);
		text1.setForeground(Color.white);
		pane.add(text2, 3);
		text2.setBounds(70, 645, 1300, 30);
		text2.setForeground(Color.white);
		pane.add(text3, 3);
		text3.setBounds(70, 675, 1300, 30);
		text3.setForeground(Color.white);
		pane.setLayout(null);

		// if (charimg.contains("yes")) {
		// chara.setBounds(0, 0, 800, 1000);
		// }
		// if (charimg.contains("carl")) {
		// chara.setBounds(100, 50, 878, 825);
		// }
		// if (charimg.contains("long")) {
		// chara.setBounds(0, 0, 941, 1063);
		// }
		// if (charimg.contains("mandv")) {
		// chara.setBounds(100, 50, 879, 1113);
		// }

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 815, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("EXIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					FileHandler.save(data[0], data);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					title();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		textbg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 1:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("schoolclassroom.jpg", "", "3:01PM",
								"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
								"not looking forward to going home. The weatherman didn’t say anything about it",
								"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
								"Continue out of the classroom and find an umbrella somewhere else.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 4:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 2));
					try {
						response("schoolclassroom.jpg", "'Thank you!'", "'I'll make sure to return it tomorrow.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 5:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
								"Continue out of the classroom and find an umbrella somewhere else.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 7:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolcafeteria.jpg", "'I'm sorry, is this yours?'",
								"Shrug and leave to go home with the umbrella.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 9:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("townstreet.jpg", "", "3:10PM",
								"You begin your walk home, taking in the sights of the quiet town around you. Despite having",
								"lived here for only two months, it feels like home already and you smile to yourself.",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 10:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("townstreet.jpg", "carl_happy.png", "CARL",
								"Excuse me, but do you know the way to Miyazaki High School? I’m a transfer student from Kyoto",
								"and these mountain roads got me turned around.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 11:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("townstreet.jpg",
								"'Of course, go down this road and take a left after the bridge. It’s right there.'",
								"'Ask someone else, I'm in a rush.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 13:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "", "3:30PM",
								"Home… finally. You take a deep breath and smile at the sight of your house after a long day of",
								"school.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 14:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "VITA", "Is this where you live?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 15:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "MORT", "We did not know you were our neighbor.", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 16:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'Yes, you two are in my history class, right?'", "'Do I know you?'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 18:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'I'll see you tomorrow then!'",
								"'Come over to study sometime. It was nice seeing you.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 20:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'Sorry, I still don't remember...'",
								"'Oh, yes! I'll see you in class tomorrow!'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 22:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "", "3:44PM",
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
					dayTransition(1);
					break;
				case 25:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schooloutside.jpg", "Eat a light meal at a cafe in the heart of town.",
								"Eat at the new ramen place in the metro station.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 27:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("cafeinside.png", "Approach them and help pay for their meal.",
								"Ignore them and finish your meal.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 29:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("cafeoutside.png", "long_happy.png", "12:34PM",
								"You end up sitting with the tall boy, talking about school and enjoying your meals. You chat ",
								"outside for a moment before you leave.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 30:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("cafeoutside.png", "long_happy.png", "LONG",
								"Thank you again for your help, you were lovely company.  I’d love to hang out with you another ",
								"time, my treat!", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 31:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("cafeoutside.png", "Agree with them and exchange numbers.",
								"Keep it professional and explain you were just being nice.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 33:
					data[3] = Integer.toString(43);
					try {
						inGame("cafeoutside.png", "long_blush.png", "LONG", "I-I’ll see you around then!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 34:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("ramen.jpg", "Ask if they mind having company for lunch.",
								"Sit towards the back of the small restaurant.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 36:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("ramen.jpg", "yes_sad.png", "12:12PM",
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
						response("ramen.jpg", "Ask them if there is something wrong.",
								"Ignore their behavior and continue talking.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 39:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("ramen.jpg", "yes_blush.png", "12:16PM",
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
						inGame("ramen.jpg", "yes_blush.png", "YES",
								"Thank you f-for being so kind! Not many people treat me like that anymore… Would ",
								"you like to go out to eat again another time?", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 41:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("ramen.jpg", "Tell them you would love to spend more time with them.",
								"Turn their offer down.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 43:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("park.jpg", "carl_happy.png", "1:03PM",
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
						response("park.jpg", "Ask the classmate if they would mind if you sat there.",
								"Shrug and walk off to the other corner of the park.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 46:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("park.jpg", "carl_happy.png", "1:07PM",
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
						inGame("park.jpg", "carl_happy.png", "CARL",
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
						inGame("park.jpg", "carl_happy.png", "1:10PM",
								"You notice that CARL has stray peanuts on his cheek.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 49:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("park.jpg", "Tell him he has peanuts on his cheek",
								"Wipe the peanuts off his cheek for him.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 51:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("park.jpg", "carl_happy.png", "CARL",
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
						response("park.jpg", "Offer him the walnuts in your bag.", "Roll your eyes.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 54:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("park.jpg", "carl_sad.png", "CARL",
								"Actually... I'm feeling a bit sick now... Can I make this up to you a different time?",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 55:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("park.jpg", "Agree to hang out another time.", "Let him down nicely.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 57:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "Hello " + data[1] + ".", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 58:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "VITA", "Nice of you to drop by.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 59:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "What brings you here?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 60:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("parkcorner.jpg", "Just stopping by.", "Change your mind and head home.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 62:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "Come, take a seat.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 63:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("parkcorner.jpg", "Decline and be on your way.", "Sit with them.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 65:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "MORT", "We have business to attend to.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 66:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("parkcorner.jpg", "Exclaim you don't want them to go.", "Shrug and say goodbye.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 68:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "", "8:15PM",
								"After a long day out on the town, you finally reach home. It’s only 8pm, but you decide on an early night.",
								"Something tells you tomorrow is going to be a big day.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 69:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					dayTransition(2);
					break;
				case 71:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					event("letter.jpg");
					break;
				case 74:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("phone.jpg", "yes_blush.png", "9:01AM",
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
						response("phone.jpg", "Reply immediately and agree to go out on a date with Yes.",
								"Leave him on read.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 77:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("apartment.jpg", "carl_blush.png", "CARL",
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
						response("apartment.jpg", "Agree to go out on a date with Carl.", "Turn him down.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 80:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "MORT", "Hello " + data[1] + ".", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 81:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_blush.png", "VITA", "We are glad you've chosen us.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 82:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "MORT", "You've made the right choice.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 83:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "VITA", "You will not regret this.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 84:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "MORT",
								"You don't really have a choice anymore, do you?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 85:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "But why would you want another choice?", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 86:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "M&V", "You will not be mistreated. Let us in please.",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 87:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("houseinv.png", "Let them in.", "Let them in.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 101:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "Why did you choose them?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 102:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "What did we do wrong?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 103:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "Were we not good enough?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 104:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "We don't want you with them.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 105:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "You can't be with them.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 106:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "M&V", "Please, come with us.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 107:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("houseinv.png", "Go with them.", "Go with them.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 109:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "What have you done?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 110:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "Were we not good enough?", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 111:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "You didn't even chose them.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 112:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "You chose nobody.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 113:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "VITA", "We do not settle for 'nobody.'", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 114:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "MORT", "You will be with us.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 115:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("houseinv.png", "mandv_angry.png", "M&V", "We will be with you.", "", "");
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
				}
			}
		});

		pane.add(newGame, 3);
		pane.add(loadGame, 3);
		pane.add(quit, 3);
		pane.moveToFront(newGame);
		pane.moveToFront(loadGame);
		pane.moveToFront(quit);
		pane.moveToBack(chara);
		pane.moveToBack(bg);

		def();

		jfrm.getContentPane().add(pane);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 900);
	}

	public static JButton responseButton(String text, int location) {
		JButton button = new JButton(text);
		switch (location) {
		case 1:
			button.setBounds(350, 270, 700, 35);
			break;
		case 2:
			button.setBounds(350, 370, 700, 35);
			break;
		case 3:
			button.setBounds(350, 470, 700, 35);
			break;
		}
		button.setBackground(Color.WHITE);
		button.setFocusable(false);
		button.setFont(h3);

		return button;
	}

	public static void badEnding() throws IOException {
		FileHandler.makeCorrupt();
		FileHandler.save(data[0], data);
		if (data[3].equals("99")) {
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			blackScreen("", "proceed?", "");
		} else if (data[3].equals("100")) {
			data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
			blackScreen("", "proceed?", "");
		}
	}

	public static void event(String background) {
		JLayeredPane pane = new JLayeredPane();
		pane.setPreferredSize(new Dimension(1400, 900));

		JLabel bg = new JLabel(new ImageIcon("C:\\Simulator\\" + background));
		JLabel frame = new JLabel(new ImageIcon("C:\\Simulator\\gamebgt.png"));

		pane.add(bg, 0);
		bg.setBounds(0, 0, 1394, 866);
		frame.setBounds(0, 0, 1394, 866);
		pane.add(frame, 1);
		pane.setLayout(null);

		bg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 72:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						Display.response("house.png", "Respond to Long's letter.",
								"Ignore the letter and head to the store.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 815, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("EXIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					FileHandler.save(data[0], data);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					title();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		pane.add(newGame, 3);
		pane.add(loadGame, 3);
		pane.add(quit, 3);
		pane.moveToFront(newGame);
		pane.moveToFront(loadGame);
		pane.moveToFront(quit);
		pane.moveToBack(bg);

		def();

		jfrm.getContentPane().add(pane);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 900);
	}

	public static void response(String background, String res1, String res2) throws IOException {
		JLayeredPane pane = new JLayeredPane();
		pane.setPreferredSize(new Dimension(1400, 900));

		JLabel bg = new JLabel(new ImageIcon("C:\\Simulator\\" + background));
		JLabel frame = new JLabel(new ImageIcon("C:\\Simulator\\gamebgt.png"));
		JButton r1 = new JButton(res1);
		JButton r2 = new JButton(res2);

		pane.add(bg, 0);
		bg.setBounds(0, 0, 1394, 866);
		frame.setBounds(0, 0, 1394, 866);
		pane.add(frame, 1);
		pane.add(r1, 2);
		r1.setBounds(150, 350, 1080, 50);
		r1.setBackground(Color.black);
		r1.setForeground(Color.WHITE);
		r1.setFocusable(false);
		r1.setFont(h3);
		pane.add(r2, 2);
		r2.setBounds(150, 450, 1080, 50);
		r2.setBackground(Color.black);
		r2.setForeground(Color.WHITE);
		r2.setFocusable(false);
		r2.setFont(h3);
		pane.setLayout(null);

		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 3:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("schoolclassroom.jpg", "yes_happy.png", "3:02PM",
								"Wha… Oh! Yeah. Umbrella. Uh, give me a second. Er… uh… got it!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;

				case 6:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) + 1));
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You exit the building with a smile, holding the boy’s umbrella over your head.", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 8:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"He shakes his head and exits the room. You smile to yourself and leave with the",
								"umbrella in hand, stepping out into the rain.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 12:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 1));
						inGame("townstreet.jpg", "carl_happy.png", "CARL", "Thank you so much!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 17:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "It is nice you remember.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 19:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "Yes. Tomorrow.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 21:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "Unfortunate...", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 26:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("cafeinside.png", "long_normal.png", "12:03PM",
								"You order a small soda and some eggs with rice. In line, you notice one of your classmates in",
								"line, fumbling with their wallet. You realize they cannot pay for the meal they ordered.",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 28:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) + 1));
						inGame("cafeinside.png", "long_blush.png", "LONG",
								"Oh, you really didn’t have to… thank you so much!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 32:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) + 3));
						inGame("cafeoutside.png", "long_blush.png", "12:35PM",
								"The boy excitedly pulls out his phone to exchange numbers with you. Your hand brushes against his",
								"when grabbing his phone, and an evident blush is present on his face. ", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 35:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("ramen.jpg", "yes_happy.png", "YES",
								"That would be nice... Oh... I would have paid for your meal if you were going to deal with my company…",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 38:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("ramen.jpg", "yes_sad.png", "YES",
								"Oh… can you tell? I’m sorry i’m just.. Really nervous… you’re just really nice to talk to and I don’t",
								"want to ruin anything… ", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 42:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 3));
						inGame("ramen.jpg", "yes_happy.png", "YES",
								"That’s great!! I’ll see you around school then and maybe we can plan something! Bye!",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 45:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 1));
						inGame("park.jpg", "carl_happy.png", "CARL", "Ohhmh- mmhsorry! Yeah, of course!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 50:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 0));
						inGame("park.jpg", "carl_happy.png", "CARL",
								"Oh, do I? Sorry about that! Didn’t mean to make you uncomfortable…", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 53:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 1));
						inGame("park.jpg", "carl_happy.png", "CARL",
								"You’re so sweet! Even though I may eat these walnuts now, nothing can stop me from eating",
								"peanuts in the future!", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 56:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 3));
						inGame("park.jpg", "carl_happy.png", "CARL", "Great, I'll see you around then!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 61:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("parkcorner.jpg", "mandv_happy.png", "VITA", "There is no need to lie to us.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 64:
					data[3] = Integer.toString(68);
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("parkcorner.jpg", "mandv_happy.png", "MORT",
								"That is alright. We will be seeing you again soon.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 67:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 3));
						inGame("parkcorner.jpg", "mandv_blush.png", "MORT",
								"Do not worry. We will be seeing you again soon.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 73:
					data[3] = Integer.toString(99);
					try {
						badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 76:
					data[3] = Integer.toString(99);
					try {
						badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 79:
					data[3] = Integer.toString(99);
					try {
						badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 88:
					blackScreen("", "end.", "");
					break;
				case 108:
					Display.blackScreen("", "end.", "");
					break;
				case 117:
					Display.blackScreen("", "end.", "");
					break;
				}
			}
		});

		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 3:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 4));
					try {
						inGame("schoolcafeteria.jpg", "long_normal.png", "3:03PM",
								"You see a disposable umbrella leaning against the wall and go to take it. Upon",
								"looking around, you notice someone watching you.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 6:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You exit the building with a smile, holding the boy’s umbrella over your head.", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 8:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You take the umbrella in hand and step out into the rain, ready to go home.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 12:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 0));
						inGame("townstreet.jpg", "carl_angry.png", "CARL", "Whatever, I don't need your help!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 17:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "History class.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 19:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "It was nice seeing you as well. :)", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 21:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "Yes. Tomorrow. :)", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 26:
					data[3] = Integer.toString(34);
					try {
						inGame("ramen.jpg", "yes_happy.png", "12:03PM",
								"You place an order for a bowl of their famous Tonkotsu Ramen and turn around to find a seat. You notice",
								"one of your classmates sitting alone near the door.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 28:
					data[3] = Integer.toString(43);
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) + 0));
						inGame("cafeinside.png", "", "12:34PM",
								"You finish your meal in peace, and return your plate to the cafe counter. With a contented sigh, you exit the cafe",
								"and take in the bustling town." + "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 32:
					data[3] = Integer.toString(43);
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) - 1));
						inGame("cafeoutside.png", "long_sad.png", "LONG",
								"Oh… I.. understand. Thanks anyways. Have a nice day.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 35:
					data[3] = Integer.toString(43);
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 0));
						inGame("ramen.jpg", "", "12:34PM",
								"The ramen is good and you find yourself finishing your meal much earlier than you’d thought you would.",
								"After returning the bowl to the bar, you step outside into the town.\r\n" + "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 38:
					data[3] = Integer.toString(43);
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 0));
						inGame("ramen.jpg", "yes_happy.png", "YES",
								"You continue your meal with your classmate awkwardly, trying to ignore the eerie silence they bring. After lunch, you",
								"quietly say your goodbyes and make your way into the city.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 42:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) - 1));
						inGame("ramen.jpg", "yes_sad.png", "YES",
								"Oh.. I understand. I’m sorry for intruding. I probably made you feel really weird. Im sorry. I’ll go now.",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 45:
					data[3] = Integer.toString(57);
					try {
						inGame("parkcorner.jpg", "mandv_happy.png", "1:03PM",
								"This corner of the park is dark. Trees press up against the gate and hedges prevent any light ",
								"from getting in. Under the tree, you see two of your history classmates sitting back to back, ",
								"looking up at the leaves. As you approach, they turn their heads towards you.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 50:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 1));
						inGame("park.jpg", "carl_blush.png", "CARL",
								"O-Oh! Just… peanuts… T-thank you for getting that for me!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 53:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 0));
						inGame("park.jpg", "carl_sad.png", "CARL",
								"Oh.. If that’s how you feel, that’s okay. I think i’m going to head home now. Goodbye.",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 56:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) - 1));
						inGame("park.jpg", "carl_sad.png", "CARL",
								"Oh, thats alright.. I understand. Peanuts aren't for everyone. Cya then.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 61:
					data[3] = Integer.toString(68);
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("parkcorner.jpg", "mandv_happy.png", "VITA",
								"How peculiar. Right when we were introduced.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 64:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 3));
						inGame("parkcorner.jpg", "mandv_happy.png", "VITA", "Thank you for joining us.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 67:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("parkcorner.jpg", "mandv_happy.png", "VITA", "Farewell.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 73:
					data[3] = Integer.toString(100);
					try {
						Display.badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 76:
					data[3] = Integer.toString(100);
					try {
						Display.badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 79:
					data[3] = Integer.toString(100);
					try {
						badEnding();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 88:
					blackScreen("", "end.", "");
					break;
				case 108:
					Display.blackScreen("", "end.", "");
					break;
				case 117:
					Display.blackScreen("", "end.", "");
					break;
				}
			}
		});

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 815, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("EXIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					FileHandler.save(data[0], data);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					title();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		pane.add(newGame, 3);
		pane.add(loadGame, 3);
		pane.add(quit, 3);
		pane.moveToFront(newGame);
		pane.moveToFront(loadGame);
		pane.moveToFront(quit);
		pane.moveToBack(bg);

		def();

		jfrm.getContentPane().add(pane);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 900);
	}

	// clear frame contents
	public static void clear() {
		musicStop();
		System.out.println("cleared");
		jfrm.getContentPane().revalidate();
		jfrm.getContentPane().removeAll();
		jfrm.getContentPane().repaint();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		title();
		// blackScreen("Welcome to Urashina, a place full of unique opportunities and
		// characters eager to meet you. ",
		// "As a new student at Miyazaki High School, you should take your time to
		// explore this unusual",
		// "town and all that it has to offer. Good luck, and have fun!");
	}
}
