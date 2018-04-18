import javax.swing.*;
import java.awt.*;


public class BackgroundImg extends JPanel
{
    private Image img;


  public BackgroundImg (String img)
  {
      this(new ImageIcon(img).getImage());
  }


  public BackgroundImg (Image img)
  {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    //setLayout(null);
  }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    g.drawImage(img, 0, 0, null);
    }
}
