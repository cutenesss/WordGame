import javax.swing.*;
import java.awt.*;

public class TitleFrame extends JFrame {
    private static TitleFrame instance = new TitleFrame("Game");

    private TitleFrame(String title) {
        super(title);
        setResizable(false);
    }

    public static TitleFrame getInstance() {
        return instance;
    }

    public void setup() {
        JPanel jp = new ImagePanel("image\\bg.jpg");
        jp.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = constraints.gridy = 0;
        constraints.insets = new Insets(0,0,20,0);
        
        PlayButton play = new PlayButton("Play");
        Rules rules = new Rules("?");
        jp.add(play, constraints);
        constraints.gridy = 1;
        jp.add(rules, constraints);
        add(jp);
        pack();
    }
}
