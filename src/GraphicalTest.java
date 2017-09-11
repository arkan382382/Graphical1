import javafx.embed.swing.JFXPanel;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by arkan on 10.09.2017.
 */
public class GraphicalTest {
    public static void main(String[] argc) {
        EventQueue.invokeLater(()->
                {
                    Toolkit x = Toolkit.getDefaultToolkit();
                    Dimension tmp = x.getScreenSize();
                    JFrame frame = new DrawFrame();
                    frame.setTitle("Title!!");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize((int)tmp.getWidth()/2,(int)tmp.getHeight()/2);
                }
        );
    }
}
class DrawFrame extends JFrame{
    public DrawFrame(){
        add(new DrawComponent());
        pack();
    }
}
class DrawComponent extends JComponent{
    int DEFAULT_WIDTH = 400;
    int DEFAULT_HEIGHT = 400;
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        double leftX=100;
        double topY=100;
        double width = 200;
        double height = 150;
        Ellipse2D elipse = new Ellipse2D.Double(leftX, topY, 200, 200);
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.setPaint(Color.blue);
        g2.draw(rect);
        g2.setPaint(Color.RED);
        g2.fill(elipse);
    }
    public Dimension getPreferedSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}