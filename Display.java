import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Display {
	static String[] data = { "fileName", "player name", "gender", "0" };

	// title font
	static Font h1 = new Font("courier", Font.PLAIN, 100);
	// heading font
	static Font h2 = new Font("courier", Font.PLAIN, 40);
	// button font
	static Font h3 = new Font("courier", Font.PLAIN, 17);

	static JFrame jfrm = new JFrame("Game Title");
	static ImageIcon icon = new ImageIcon("C:\\Simulator\\icon.png");

	public static void def() {
		jfrm.setIconImage(icon.getImage());
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void title() throws IOException {
		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\bg.jpg"));
		panel.setLayout(null);

		JLabel name = new JLabel("LUV MI");
		name.setBounds(850, 30, 600, 200);
		name.setFont(h1);
		name.setForeground(Color.BLACK);

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

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);
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
					FileHandler.save(fileName.getText(), data);
				} catch (IOException e1) {
					System.out.println("Save failed.");
				}
				clear();
				try {
					clear();
					inGame();
				} catch (IOException e1) {
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
					FileHandler.load(fileName.getText());
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
				if(male.isSelected()) {
					data[2] = "male";
				}else if(female.isSelected()) {
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

	public static void inGame() throws IOException {

		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\gamebg.png"));
		panel.setLayout(null);

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
		quit = new JButton("QUIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				System.exit(0);
			}
		});

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);

		def();

		jfrm.getContentPane().add(panel);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 901);
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

	public static void response() throws IOException {
		def();

		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\gamebg.png"));
		panel.setLayout(null);

		JButton r1, r2, r3;
		r1 = responseButton("help me", 1);
		r2 = responseButton("im dying", 2);
		r3 = responseButton("this is too much", 3);

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
		quit = new JButton("QUIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				System.exit(0);
			}
		});
		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(r1);
		panel.add(r2);
		panel.add(r3);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);
		jfrm.setSize(1400, 901);
	}

	// clear frame contents
	public static void clear() {
		jfrm.getContentPane().revalidate();
		jfrm.getContentPane().removeAll();
		jfrm.getContentPane().repaint();
	}

	public static void main(String[] args) throws IOException {
		inGame();
	}
}