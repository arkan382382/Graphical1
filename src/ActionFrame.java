import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;

    public ActionFrame(){
        setSize(WIDTH, HEIGHT);
        buttonPanel = new JPanel();

        Action yellowAction = new ColorAction("Żółty", new ImageIcon("D:\\zrodlo\\yellow.gif"), Color.yellow);
        Action blueAction = new ColorAction("Niebieski", new ImageIcon("D:\\zrodlo\\blue.gif"), Color.blue);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("D:\\zrodlo\\red.gif"), Color.red);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");

        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction{
        public ColorAction(String name, Icon icon, Color c){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Ustaw kolor panelu na " + name.toLowerCase());
            putValue("color", c);
        }
        public void actionPerformed(ActionEvent event){
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
