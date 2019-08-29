import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomNumberLabel extends JLabel {
    public RandomNumberLabel() {
        super();
        this.generateRandomNumber();
        this.setFont(new Font("Serif", Font.PLAIN, 100));
        this.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(100, 100));
        this.setHorizontalTextPosition(CENTER);
    }

    public void generateRandomNumber() {
        Random random = new Random();
        int x = random.nextInt(6);
        System.out.println("random origin " + x);
        this.setText(Integer.toString(x+2));
    }

    public int getGeneratedNumber(){
        return Integer.valueOf(getText());
    }
}
