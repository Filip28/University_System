package szarek.filip.panels;

import javax.swing.*;

/**
 * Created by Filip on 03.05.2017.
 */
public class ExamplePanel extends JPanel {

    private JButton btn1 = new JButton("BUTTON 1");
    private JTextField tf1 = new JTextField("Default text", 100);
    private JLabel l1 = new JLabel("Tekst");
    private JCheckBox cb1 = new JCheckBox("CB 1");
    private JCheckBox cb2 = new JCheckBox("CB 2");
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton rb1 = new JRadioButton("RB 1");
    private JRadioButton rb2 = new JRadioButton("RB 2");

    public ExamplePanel()
    {
        bg.add(rb1);
        bg.add(rb2);
        add(btn1);
        add(tf1);
        add(l1);
        add(cb1);
        add(cb2);
        add(rb1);
        add(rb2);
    }

}
