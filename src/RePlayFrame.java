import javax.swing.*;
import java.awt.*;

public class RePlayFrame extends JFrame {
    public RePlayFrame(String title) {
        super(title);
        JPanel jp = new ImagePanel("image\\bg.jpg");
        jp.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,0,20,0);
        constraints.gridx = constraints.gridy = 0;
        ScoreAnnoucer scoreAnnoucer = new ScoreAnnoucer();
        jp.add(scoreAnnoucer,constraints);
        PlayButton play = new PlayButton("Play");
        Rules rules = new Rules("?");
        constraints.gridy = 1;
        jp.add(play, constraints);
        constraints.gridy = 2;
        jp.add(rules, constraints);
        this.setResizable(false);
        this.add(jp);
        this.pack();
    }
}


