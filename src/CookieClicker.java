import javax.swing.*;
import java.awt.*;

public class CookieClicker extends JFrame {
    public CookieClicker(){
        super("Cookie Clicker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 800));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
