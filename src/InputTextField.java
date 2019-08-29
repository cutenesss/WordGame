
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;

class Remove implements Runnable
{

    Remove()
    {
    }

    ;
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(699);
            GameFrame.setStatus("");
        } catch (InterruptedException ex)
        {
        }
    }
}

public class InputTextField extends JTextField
{

    private final int fixedLength;

    public InputTextField(int fixedLength) throws IOException, SQLException
    {
        super();

        this.fixedLength = fixedLength;
        System.out.println("fixlength " + fixedLength);
        this.setPreferredSize(new Dimension(300, 40));
        this.setFont(new Font("Roboto", Font.PLAIN, 22));

        Connection conn = DriverManager.getConnection("jdbc:sqlite:words.db");
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `words` WHERE `len`=? AND `item`=?");
        HashSet<String> hs = new HashSet<>();
        
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent keyEvent)
            {
                if (keyEvent.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    String text = getText();
                    System.out.println("text " + text.length());
                    if (text.length() == fixedLength)
                    {
                        if (hs.contains(text))
                        {
                            System.out.println("Repeated");
                            GameFrame.setStatusRp();
                        } else
                        {
                            try
                            {
                                ps.setInt(1, fixedLength);
                                ps.setString(2, text);

                                ResultSet rs = ps.executeQuery();
                                if (rs.next())
                                {   
                                    System.out.println("OK");
                                    GameFrame.setStatusOK();
                                    hs.add(text);
                                    ++GameFrame.score;
                                } else
                                {
                                    System.out.println("NO");
                                    GameFrame.setStatusWrong();
                                }
                            } catch (SQLException ex)
                            {
                            }
                        }
                    }
                    else
                    {
                        GameFrame.setStatusWrong();
                    }
                    new Thread(new Remove()).start();
                    setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent)
            {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent)
            {
            }
        });
    }
}
