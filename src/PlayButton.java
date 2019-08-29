import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PlayButton extends JButton implements ActionListener {
    
    public PlayButton(String title) {
        super(title);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension(100, 50));
        setActionCommand("Play");
        this.setFont(new Font("Roboto", Font.PLAIN, 22));
        addActionListener(this);
        this.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TitleFrame titleFrame = TitleFrame.getInstance();
        titleFrame.dispose();
        GameFrame gameFrame;
        try
        {
            gameFrame = new GameFrame("Game");
        } catch (IOException | SQLException ex)
        {
        }
        
    }
}
