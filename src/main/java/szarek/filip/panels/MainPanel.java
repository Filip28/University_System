package szarek.filip.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Filip on 10.05.2017.
 */
public class MainPanel extends JPanel {
    private PanelStudent panelStudent = new PanelStudent();
    private PanelUniversity panelUniversity = new PanelUniversity();

    private static final String PANEL_STUDENT = "PANEL_STUDENT";
    private static final String PANEL_UNIVERSITY = "PANEL_UNIVERSITY";

    public MainPanel()
    {
        super(new CardLayout());
        add(panelStudent, PANEL_STUDENT);
        add(panelUniversity, PANEL_UNIVERSITY);
    }

    public JMenuBar createMenu()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Panele");
        menu.setFont(new Font("Arial", Font.PLAIN, 20));
        JMenuItem menuItemStudent = new JMenuItem("Student");
        menuItemStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        //menuItemStudent.setIcon();
        //menuItemStudent.setAccelerator();
        //menuItemStudent.setMnemonic();
        JMenuItem menuItemUniversity = new JMenuItem("University");
        menuItemUniversity.setFont(new Font("Arial", Font.PLAIN, 20));

        menu.add(menuItemStudent);
        menu.addSeparator();
        menu.add(menuItemUniversity);
        menuBar.add(menu);


        menuItemStudent.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_STUDENT);

        });

        menuItemUniversity.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_UNIVERSITY);

        });

        return menuBar;
    }

}
