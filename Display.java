import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Display {
	public static void title() throws IOException {
		//title font
		Font f = new Font("courier", Font.PLAIN, 100);
		//button font
		Font s = new Font("courier", Font.PLAIN, 17);

        BackgroundImg panel = new BackgroundImg(Toolkit.getDefaultToolkit().getImage("C:\\Simulator\\bg.jpg"));
        panel.setLayout(null);

        JLabel name = new JLabel("GAME TITLE");
        name.setBounds(670, 30, 600, 200);
        name.setFont(f);
        name.setForeground(Color.BLACK);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(s);
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(s);
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(s);

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(name);

		JFrame jfrm = new JFrame("Game Title");
		jfrm.getContentPane().add(panel);

		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//jfrm.setContentPane(new ImagePanel(myImage));

		jfrm.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		title();
	}
}
