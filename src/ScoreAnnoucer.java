import javax.swing.*;
import java.awt.*;

public class ScoreAnnoucer extends JLabel {
    public ScoreAnnoucer(){
        super();
        this.setText("Số điểm người chơi đạt được:<br> "+ GameFrame.score );
        this.setFont(new Font("Roboto", Font.PLAIN, 20));
        this.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(350,50));
        this.setHorizontalTextPosition(CENTER);
    }
}