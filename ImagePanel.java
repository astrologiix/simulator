import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JComponent{
	private Image image;
	
    public ImagePanel(Image image) {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    
						// use of it
//    public static void main(String[] args) throws IOException {
//    	BufferedImage myImage = ImageIO.read(new File("C:\\boys.png"));
//		JFrame jfrm = new JFrame("Image pane");
//		jfrm.setContentPane(new ImagePanel(myImage));
//		jfrm.setSize(myImage.getWidth(), myImage.getHeight() + 50);
//		jfrm.setVisible(true);
//    }


}
