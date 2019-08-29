import javax.swing.*;
import java.awt.*;

public class Counter extends Thread
{

    JLabel jlabel;
    InputTextField x;

    public JLabel getLabel()
    {
        return jlabel;
    }

    int n = 15;

    Counter(JLabel j, InputTextField t)
    {
        jlabel = j;
        jlabel.setPreferredSize(new Dimension(100, 100));
        jlabel.setFont(new Font("Roboto", Font.PLAIN, 40));
        jlabel.setForeground(Color.BLACK);
        jlabel.setHorizontalAlignment(JLabel.RIGHT);
        jlabel.setText("Time left: " + Integer.toString(n));
        x = t;
    }

    @Override
    public void run()
    {
        try
        {
            GameFrame.setStatus("Let's go");

            while (n >= 0)
            {
                jlabel.setText("Time left: " + Integer.toString(n));
                --n;
                Thread.sleep(1000);
            }
            GameFrame.timeout = true;
            System.out.println(GameFrame.timeout);
        } catch (InterruptedException ex)
        {
        }
    }
}
