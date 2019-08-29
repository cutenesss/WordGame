import org.pushingpixels.substance.api.skin.SubstanceCeruleanLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class RunClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { 
                try {
                    UIManager.setLookAndFeel(new SubstanceCeruleanLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TitleFrame myUI = TitleFrame.getInstance();
                myUI.setup();
                myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension screenSize = toolkit.getScreenSize();
                myUI.pack();
                myUI.setLocation(screenSize.width / 2 - myUI.getSize().width / 2,
                        screenSize.height / 2 - myUI.getSize().height / 2);
                myUI.setVisible(true);
            }
        });
    }
}
