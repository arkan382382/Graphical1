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
        JFrame frame = new ActionFrame();
        EventQueue.invokeLater(()->{


            frame.setVisible(true);
        });

        System.out.println("size: " + frame.getWidth() + " " + frame.getHeight());

    }
}

