import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Display {
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
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void title() throws IOException {
		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\bg.jpg"));
		panel.setLayout(null);

		JLabel name = new JLabel("GAME TITLE");
		name.setBounds(670, 30, 600, 200);
		name.setFont(h1);
		name.setForeground(Color.BLACK);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

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
		JLabel empty = new JLabel("GAME TITLE");
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
		JLabel empty = new JLabel("GAME TITLE");
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
		JButton saveButton = new JButton("LOAD");
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

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

		jfrm.setVisible(true);
	}

	public static void inGame() throws IOException {
		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\gamebg.png"));
		panel.setLayout(null);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 812, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 812, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT");
		quit.setBounds(329, 812, 140, 35);import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Display {
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
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void title() throws IOException {
		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\bg.jpg"));
		panel.setLayout(null);

		JLabel name = new JLabel("GAME TITLE");
		name.setBounds(670, 30, 600, 200);
		name.setFont(h1);
		name.setForeground(Color.BLACK);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

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
		JLabel empty = new JLabel("GAME TITLE");
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
		JLabel empty = new JLabel("GAME TITLE");
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
		JButton saveButton = new JButton("LOAD");
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

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

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
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);
		jfrm.setSize(1400, 901);
	}

	public static JButton responseButton(String text, int location) {
		JButton button = new JButton(text);
		switch(location) {
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
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

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
		jfrm.removeAll();
		jfrm.repaint();
		jfrm.revalidate();
	}

	public static void main(String[] args) throws IOException {
		response();
	}
}

		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);
	}

	public static JButton responseButton(String text, int location) {
		JButton button = new JButton(text);
		switch(location) {
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
		BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\gamebg.png"));
		panel.setLayout(null);

		JButton r1, r2, r3;
		r1 = responseButton("help me", 1);
		r2 = responseButton("im dying", 2);
		r3 = responseButton("this is too much", 3);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 812, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 812, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		quit = new JButton("QUIT");
		quit.setBounds(329, 812, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(r1);
		panel.add(r2);
		panel.add(r3);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);
	}

	// clear frame contents
	public static void clear() {
		jfrm.removeAll();
		jfrm.repaint();
		jfrm.revalidate();
	}

	public static void main(String[] args) throws IOException {
		response();
	}
}
