import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JButton {
    public Rules(String title) {
        super(title);
        setActionCommand("?"); 
        this.setFocusable(false);
        this.setFont(new Font("Roboto", Font.PLAIN,20));
        setPreferredSize(new Dimension(50, 50));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TitleFrame titleFrame = TitleFrame.getInstance();
                JOptionPane.showMessageDialog(titleFrame.getComponent(0), "Nhập vào các từ tiếng Anh có độ dài bằng con số ở bên trái và ấn ENTER.\nTừ đã nhập rồi sẽ không được tính điểm.");
            }
        });
    }
}
