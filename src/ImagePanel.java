import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(String imagePath) {
        ImageIcon ImgIcon = new ImageIcon(imagePath);
        img = ImgIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0 ,0,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 600);
    }

}
