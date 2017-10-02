package szarek.filip;

import szarek.filip.dao.*;
import szarek.filip.domain.Register;
import szarek.filip.domain.Student;
import szarek.filip.domain.University;
import szarek.filip.panels.FinallPanel;
import szarek.filip.panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void createNewWindow()
    {
        //tworzymy panel, ktory umiescimy w okienku
//        MainPanel panel = new MainPanel();
        FinallPanel panel = new FinallPanel();
        panel.setVisible(true);





        JFrame frame = new JFrame("System Uniwersytecki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zamyka sie wszystko lacznie z innymi okienkami aplikacji
        //ladujemy panel do okna
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setResizable(false); //moge rozciagac panel
        //frame.setJMenuBar(panel.createMenu());
        frame.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.pack(); //dopasowuje rozmiar okna do jego zawartosci

        Locale l1 = new Locale("en", "EN");
        Locale.setDefault(l1);

    }
    public static void main( String[] args )
    {

        javax.swing.SwingUtilities.invokeLater(
                /*new Runnable() {
                    public void run() {

                    }
                }*/
                () -> {
                    createNewWindow();
                }
        );




    }
}
