package szarek.filip.panels;

import szarek.filip.dao.StudentDaoImpl;
import szarek.filip.domain.Student;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Filip on 03.05.2017.
 */
public class PanelStudent extends JPanel {
    //buttons
    private JButton btnLeft = new JButton("<<<");
    private JButton btnRight = new JButton(">>>");
    private JButton btnInsert = new JButton("Insert");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnUpdate = new JButton("Update");

    //labels
    private JLabel lName = new JLabel("Name");
    private JLabel lSurname = new JLabel("Surname");
    //http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
    private JLabel lBirthDate = new JLabel("Birthdate");
    private JLabel lAddress = new JLabel("Address");
    private JLabel lEmail = new JLabel("Email");
    private JLabel lPhoneNumber = new JLabel("Phone number");

    //text fields
    private JTextField tfId = new JTextField(3);
    private JTextField tfName = new JTextField(20);
    private JTextField tfSurname = new JTextField(20);
    private JTextField tfBirthdate = new JTextField(20);
    private JTextField tfAddress = new JTextField(20);
    private JTextField tfEmail = new JTextField(20);
    private JTextField tfPhoneNumber = new JTextField(20);

    //czesc bazodanowa
    private StudentDaoImpl studentDao = StudentDaoImpl.getInstance();
    private java.util.List<Student> students;
    private int idx;


    public PanelStudent()
    {
        super(new GridBagLayout());


        JPanel panelNavigation = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelNavigation = new GridBagConstraints();
        //panelNavigation.setFont(new Font("Arial", Font.PLAIN, 40));
        gbcPanelNavigation.gridx = 0; //kolumna
        gbcPanelNavigation.gridy = 0; //wiersz
        gbcPanelNavigation.ipadx = 40;
        panelNavigation.add(btnLeft, gbcPanelNavigation);
        btnLeft.setFont(new Font("Arial", Font.BOLD, 20));
        btnLeft.addActionListener(e -> {
            --idx;
            if (idx < 0)
            {
                idx = students.size() - 1;
            }
            fillStudentsFields();
        });


        gbcPanelNavigation.gridx = 1;
        gbcPanelNavigation.gridy = 0;
        gbcPanelNavigation.ipadx = 0;
        gbcPanelNavigation.insets = new Insets(5, 20, 5, 20);
        tfId.setFont(new Font("Arial", Font.PLAIN, 20));
        tfId.setHorizontalAlignment(JTextField.CENTER);
        tfId.setForeground(Color.green);
        //tfId.setForeground(new Color(14, 11, 255));
        //tfId.setBackground(Color.BLACK);
        tfId.setEditable(false);
        panelNavigation.add(tfId, gbcPanelNavigation);

        gbcPanelNavigation.gridx = 2;
        gbcPanelNavigation.gridy = 0;
        gbcPanelNavigation.ipadx = 40;
        gbcPanelNavigation.insets = new Insets(0, 0, 0, 0);
        panelNavigation.add(btnRight, gbcPanelNavigation);
        btnRight.setFont(new Font("Arial", Font.BOLD, 20));
        btnRight.addActionListener(e -> {
            ++idx;
            if (idx >= students.size()){
                idx = 0;
            }
            fillStudentsFields();
        });
        //btnRight.setFont(new Font("Arial", Font.PLAIN, 20));

        //-------------------------------------------------------------
        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();

        /*panelFields.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.PINK,3,true),
                "FIELDS",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Courirer New", Font.ITALIC, 20),
                Color.RED
        ));*/
        panelFields.setBorder(BorderFactory.createLineBorder(Color.red,7));

        gbcPanelFields.insets = new Insets(3,5,3,10);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        lName.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFields.add(lName, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        panelFields.add(tfName, gbcPanelFields);
        tfName.setFont(new Font("Arial", Font.PLAIN, 20));


        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        panelFields.add(lSurname, gbcPanelFields);
        lSurname.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        panelFields.add(tfSurname, gbcPanelFields);
        tfSurname.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        panelFields.add(lBirthDate, gbcPanelFields);
        lBirthDate.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        tfBirthdate.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFields.add(tfBirthdate, gbcPanelFields);


        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        panelFields.add(lAddress, gbcPanelFields);
        lAddress.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        panelFields.add(tfAddress, gbcPanelFields);
        tfAddress.setFont(new Font("Arial", Font.PLAIN, 20));


        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        panelFields.add(lEmail, gbcPanelFields);
        lEmail.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        panelFields.add(tfEmail, gbcPanelFields);
        tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        panelFields.add(lPhoneNumber, gbcPanelFields);
        lPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        panelFields.add(tfPhoneNumber, gbcPanelFields);
        tfPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 20));

        //-------------------------------------------------------------
        JPanel panelOperations = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelOperations = new GridBagConstraints();

        gbcPanelOperations.insets = new Insets(4,10,4,10);

        gbcPanelOperations.gridx = 0;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnInsert, gbcPanelOperations);
        btnInsert.setFont(new Font("Arial", Font.PLAIN, 20));
        btnInsert.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Tutaj bedzie panel od wstawiania nowego studenta");
            createInsertWindow();
        });

        gbcPanelOperations.gridx = 1;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnDelete, gbcPanelOperations);
        btnDelete.setFont(new Font("Arial", Font.PLAIN, 20));
        btnDelete.addActionListener(e -> {
            deleteAndRefreshStudents();
        });

        gbcPanelOperations.gridx = 2;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnUpdate, gbcPanelOperations);
        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUpdate.addActionListener(x ->{
            createUpdateWindow();
        });

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

        students = studentDao.getAll();
        idx = 0;
        fillStudentsFields();

//        System.out.println("ID --------> " + System.identityHashCode(studentDao));
    }

    public void fillStudentsFields()
    {
        Student student = students.get(idx);
        tfId.setText(String.valueOf(student.getId()));
        tfPhoneNumber.setText(String.valueOf(student.getPhoneNumber()));
        tfEmail.setText(String.valueOf(student.getEmail()));
        tfAddress.setText(String.valueOf(student.getAddress()));
        tfSurname.setText(String.valueOf(student.getSurname()));
        tfName.setText(String.valueOf(student.getName()));
        tfBirthdate.setText(String.valueOf(student.getBirthDate()));
    }


    public void createInsertWindow(){

        InsertPanelStudent panel = new InsertPanelStudent(this);

        JFrame frame = new JFrame("Add Student");
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
    public void createUpdateWindow(){

        UpdatePanelStudent panel = new UpdatePanelStudent(this);

        JFrame frame = new JFrame("Update Student");
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

    public void refreshAfterInsert()
    {
        students = studentDao.getAll();
        idx = students.size() - 1;
        fillStudentsFields();
    }

    public void refreshAfterUpdate(){
        students = studentDao.getAll();
        fillStudentsFields();

    }
    private void deleteAndRefreshStudents(){
        int idNumber = Integer.parseInt(tfId.getText());
        studentDao.delete(idNumber);
        students = studentDao.getAll();
        idx = students.size()-1;
        fillStudentsFields();
    }

}
