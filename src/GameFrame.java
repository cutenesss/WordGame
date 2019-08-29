import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


//class EndGame implements Runnable
//{
//    private GameFrame game;
//    public EndGame(GameFrame t)
//    {
//        game = t;
//    }
//    @Override
//    public void run()
//    {
//        while (!GameFrame.timeout)
//        {
//            try
//            {   
//                System.out.println("timeout: " + GameFrame.timeout);
//                Thread.sleep(696);
//            } catch (InterruptedException ex)
//            {
//            }
//        }
//        System.out.println("timeout: " + GameFrame.timeout);
//        game.dispose();
//    }
//}

public class GameFrame extends JFrame {
    private RandomNumberLabel randomNumberLabel = new RandomNumberLabel();
    private static JLabel topEmptyLabel;
    public static int score = 0;
    public static boolean timeout = false;
    
    
    public GameFrame(String title) throws IOException, SQLException {
        super(title);
        JPanel panel = new ImagePanel("image\\bg.jpg");
        panel.setLayout(new BorderLayout());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        //
        InputTextField inputTextField = new InputTextField(randomNumberLabel.getGeneratedNumber());
        
        Counter counter = new Counter(new JLabel(), inputTextField);
        JPanel topInnerPanel = new JPanel(new BorderLayout());
        topInnerPanel.setOpaque(false);
        topInnerPanel.add(randomNumberLabel, BorderLayout.WEST);
        topInnerPanel.add(counter.getLabel(), BorderLayout.CENTER);

        JPanel centerInnerPanel = new JPanel(new BorderLayout());
        centerInnerPanel.setOpaque(false);
        topEmptyLabel = new JLabel();
        topEmptyLabel.setHorizontalAlignment(JLabel.CENTER);
        topEmptyLabel.setFont(new Font("Roboto", Font.PLAIN, 30));
        topEmptyLabel.setText("");
        JPanel innerInnerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerInnerPanel.setOpaque(false);
        innerInnerPanel.add(inputTextField);

        topEmptyLabel.setPreferredSize(new Dimension(300, 300));
        centerInnerPanel.add(topEmptyLabel, BorderLayout.NORTH);
        centerInnerPanel.add(innerInnerPanel, BorderLayout.CENTER);
        panel.add(topInnerPanel, BorderLayout.NORTH);
        panel.add(centerInnerPanel, BorderLayout.CENTER);

        this.add(panel);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(screensize.width / 2 - this.getSize().width / 2,
                screensize.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        
        counter.start();
        
        if(timeout == true){
            this.dispose();
            RePlayFrame rePlayFrame = new RePlayFrame("Game");
            rePlayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension screenSize = toolkit.getScreenSize();
            rePlayFrame.pack();
            rePlayFrame.setLocation(screenSize.width / 2 - rePlayFrame.getSize().width / 2,
                    screenSize.height / 2 - rePlayFrame.getSize().height / 2);
            rePlayFrame.setVisible(true);
        } 
    }
    
    public static void setStatusOK()
    {
        topEmptyLabel.setForeground(Color.GREEN);
        topEmptyLabel.setText("OK");
    }
    public static void setStatusWrong()
    {
        topEmptyLabel.setForeground(Color.RED);
        topEmptyLabel.setText("WRONG");
    }
    public static void setStatusRp()
    {
        topEmptyLabel.setForeground(Color.MAGENTA);
        topEmptyLabel.setText("REPEATED");
    }
    public static void setStatus(String s)
{
        topEmptyLabel.setText(s);
    }
}
