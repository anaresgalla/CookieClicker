import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class CookieClicker extends JFrame {
    public CookieClicker(){
        super("Cookie Clicker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 800));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents(){
        SpringLayout springLayout = new SpringLayout();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(springLayout);

        // 1.Banner
        JLabel bannerImg = loadImage("resources/banner.png", true, 450, 100);

        jPanel.add(bannerImg);
        springLayout.putConstraint(SpringLayout.WEST, bannerImg, 65, SpringLayout.WEST, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, bannerImg, 25, SpringLayout.NORTH, jPanel);

        // 2.Cookie Button
        JButton cookieButton = createImageButton("resources/cookie.png");

        jPanel.add(cookieButton);
        springLayout.putConstraint(SpringLayout.WEST, cookieButton, 95, SpringLayout.WEST, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, cookieButton, 175, SpringLayout.NORTH, jPanel);

        this.getContentPane().add(jPanel);
    }

    private JLabel loadImage(String fileName, boolean isResized, int targetWidth, int targetHeight){
        BufferedImage image;
        JLabel imageContainer;
        try{
            InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            image = ImageIO.read(inputStream);
            if(isResized){
                image = resizeImage(image, targetWidth, targetHeight);
            }
            imageContainer = new JLabel(new ImageIcon(image));
            return imageContainer;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }

    private BufferedImage resizeImage(BufferedImage image, int targetWidth, int targetHeight){
        BufferedImage newImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.drawImage(image, 0,0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return newImage;
    }

    private JButton createImageButton(String fileName){
        JButton button;
        try{
            InputStream inputStream = this.getClass().getResourceAsStream(fileName);
            Image image = ImageIO.read(inputStream);
            button = new JButton(new ImageIcon(image));
            return button;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }
}
