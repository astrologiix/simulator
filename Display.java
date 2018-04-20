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

	// unfinished, doens't work
	public static void inGame() {

		JPanel panel = new JPanel();
		JPanel top = new JPanel();
		top.setBounds(10, 10, 1370, 800);
		top.setBackground(Color.white);
		panel.setBackground(Color.black);
		// BackgroundImg panel = new BackgroundImg("C:\\Simulator\\gamebg.png");
		panel.setLayout(null);

		JButton sButton = new JButton("save");
		sButton.setBounds(0, 811, 80, 35);
		sButton.setBackground(Color.WHITE);
		sButton.setFocusable(false);
		sButton.setFont(h3);
		JButton lButton = new JButton("load");
		sButton.setBounds(50, 809, 80, 35);
		lButton.setBackground(Color.WHITE);
		lButton.setFocusable(false);
		lButton.setFont(h3);
		JButton mButton = new JButton("menu");
		sButton.setBounds(150, 809, 80, 35);
		mButton.setBackground(Color.WHITE);
		mButton.setFocusable(false);
		mButton.setFont(h3);
		JButton qButton = new JButton("quit");
		sButton.setBounds(200, 809, 80, 35);
		qButton.setBackground(Color.WHITE);
		qButton.setFocusable(false);
		qButton.setFont(h3);

		panel.add(top);
		panel.add(sButton);
		panel.add(lButton);
		panel.add(mButton);
		panel.add(qButton);

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
		loadScreen();
	}
}
