import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Display {
	//title font
	static Font h1 = new Font("courier", Font.PLAIN, 100);
	//heading font
	static Font h2 = new Font("courier", Font.PLAIN, 40);
	//button font
	static Font h3 = new Font("courier", Font.PLAIN, 17);

	static JFrame jfrm = new JFrame("Game Title");
	static ImageIcon icon = new ImageIcon("C:\\Simulator\\icon.png");

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

		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setIconImage(icon.getImage());

		jfrm.setVisible(true);
	}

	//display save game screen
	public static void saveScreen() {
		//make basic background and window
		jfrm.setIconImage(icon.getImage());
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.getContentPane().setBackground(Color.BLACK);

		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel empty = new JLabel("GAME TITLE");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		JLabel lbl = new JLabel("SAVE GAME AS");
		lbl.setFont(h2);
		lbl.setForeground(Color.WHITE);

		Icon icon = new ImageIcon("C:\\Simulator\\saveicon.jpg");
		JLabel photo = new JLabel(icon);

		JTextField fileName = new JTextField(30);
		fileName.setFont(h3);

		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(h3);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFocusable(false);

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

	//clear frame contents
	public static void clear() {
		jfrm.removeAll();
		jfrm.repaint();
		jfrm.revalidate();
	}

	public static void main(String[] args) throws IOException {
		saveScreen();
	}
}
