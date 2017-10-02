package szarek.filip.panels;


import szarek.filip.dao.UniversityDaoImpl;
import szarek.filip.domain.University;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Filip on 04.05.2017.
 */
public class PanelUniversity extends JPanel {

    private JButton btnLeft = new JButton("<<<");
    private JButton btnRight = new JButton(">>>");
    private JButton btnInsert = new JButton("Insert");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnUpdate = new JButton("Update");


    private JLabel lName = new JLabel("Name:");
    private JLabel lAdress = new JLabel("Adress:");
    private JLabel lSetYear = new JLabel("Year of creation:");
    private JLabel lNameOfDean = new JLabel("Dean name:");
    private JLabel lDirectionOfStudy = new JLabel("Direction:");

    private JTextField tfId = new JTextField(3);
    private JTextField tfName = new JTextField(20);
    private JTextField tfAdress = new JTextField(20);
    private JTextField tfSetYear = new JTextField(20);
    private JTextField tfNameOfDean = new JTextField(20);
    private JTextField tfDirectionOfStudy = new JTextField(20);

    private UniversityDaoImpl universityDao = UniversityDaoImpl.getInstance();
    private java.util.List<University> universities;
    private int idx;

    public PanelUniversity(){

        super(new GridBagLayout());


        JPanel panelNavigation = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelNavigation = new GridBagConstraints();

        gbcPanelNavigation.gridx = 0; //kolumna
        gbcPanelNavigation.gridy = 0; //wiersz
        gbcPanelNavigation.ipadx = 40;
        panelNavigation.add(btnLeft, gbcPanelNavigation);
        btnLeft.setFont(new Font("Arial", Font.BOLD,20));
        btnLeft.addActionListener( e -> {
            --idx;
            if (idx < 0){
                idx = universities.size() - 1;
            }
            fillUniversityFromFields();
        });

        gbcPanelNavigation.gridx = 1;
        gbcPanelNavigation.gridy = 0;
        gbcPanelNavigation.ipadx = 0;
        gbcPanelNavigation.insets = new Insets(5, 20, 5, 20);
        tfId.setFont(new Font("Arial", Font.PLAIN,20));
        tfId.setEditable(false);
        tfId.setForeground(Color.green);
        tfId.setHorizontalAlignment(JTextField.CENTER);
        panelNavigation.add(tfId, gbcPanelNavigation);



        gbcPanelNavigation.gridx = 2;
        gbcPanelNavigation.gridy = 0;
        gbcPanelNavigation.ipadx = 40;
        gbcPanelNavigation.insets = new Insets(0, 0, 0, 0);
        panelNavigation.add(btnRight, gbcPanelNavigation);
        btnRight.setFont(new Font("Arial", Font.BOLD,20));

        btnRight.addActionListener(e -> {
            ++idx;
            if (idx >= universities.size()){
                idx = 0;
            }
            fillUniversityFromFields();
        });

        //-----------------------------------------------------

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();

        panelFields.setBorder(BorderFactory.createLineBorder(Color.red, 7));
        gbcPanelFields.insets = new Insets(3,5,3,10);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        panelFields.add(lName, gbcPanelFields);
        lName.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        panelFields.add(tfName, gbcPanelFields);
        tfName.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        panelFields.add(lAdress, gbcPanelFields);
        lAdress.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        panelFields.add(tfAdress, gbcPanelFields);
        tfAdress.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        panelFields.add(lSetYear, gbcPanelFields);
        lSetYear.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        panelFields.add(tfSetYear, gbcPanelFields);
        tfSetYear.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        panelFields.add(lNameOfDean, gbcPanelFields);
        lNameOfDean.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        panelFields.add(tfNameOfDean, gbcPanelFields);
        tfNameOfDean.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        panelFields.add(lDirectionOfStudy, gbcPanelFields);
        lDirectionOfStudy.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        panelFields.add(tfDirectionOfStudy, gbcPanelFields);
        tfDirectionOfStudy.setFont(new Font("Arial", Font.PLAIN,20));

        //na stacku to  miało dizałać tak zeby ustawialo font od razu dla wszystkich jtf ale nie dziala, sprawdzielem
        /*Font mainFont = new Font("Arial", Font.PLAIN,20);
        for (Component comp : getComponents()){
            if (comp instanceof JTextField){
                ((JTextField)comp).setFont(mainFont);
            }
        }*/


        //-------------------------------------------------------------
        JPanel panelOperations = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelOperations = new GridBagConstraints();

        gbcPanelOperations.insets = new Insets(7,10,4,10);


        gbcPanelOperations.gridx = 0;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnInsert, gbcPanelOperations);
        btnInsert.setFont(new Font("Arial", Font.PLAIN,20));
        btnInsert.addActionListener(e -> {
            createInsertWindow();
        });

        gbcPanelOperations.gridx = 1;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnDelete, gbcPanelOperations);
        btnDelete.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelOperations.gridx = 2;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnUpdate, gbcPanelOperations);
        btnUpdate.setFont(new Font("Arial", Font.PLAIN,20));


        //-------------------------------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelNavigation, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelFields, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        add(panelOperations, gbcMain);

        universities = universityDao.getAll();
        idx = 0;
        fillUniversityFromFields();

    }

    public void fillUniversityFromFields(){

        University university = universities.get(idx);
        tfId.setText(String.valueOf(university.getId()));
        tfName.setText(String.valueOf(university.getName()));
        tfAdress.setText(String.valueOf(university.getAdress()));
        tfSetYear.setText(String.valueOf(university.getSetYear()));
        tfNameOfDean.setText(String.valueOf(university.getDeanName()));
        tfDirectionOfStudy.setText(String.valueOf(university.getDirection()));
    }


    public void createInsertWindow(){

        InsertPanelUniversity panel = new InsertPanelUniversity(this);

        JFrame frame = new JFrame("Add University");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setResizable(false);
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

        frame.pack();
    }
    public void refreshAfterInsert(){
        universities = universityDao.getAll();
        idx = universities.size() - 1;
        fillUniversityFromFields();
    }
}
