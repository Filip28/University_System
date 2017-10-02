package szarek.filip.panels;

import szarek.filip.dao.StudentDaoImpl;
import szarek.filip.domain.Student;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class InsertPanelStudent extends JPanel{

    private JLabel lName = new JLabel("Name");
    private JLabel lSurname = new JLabel("Surname");
    private JLabel lBirthDate = new JLabel("Birthdate");
    private JLabel lAddress = new JLabel("Address");
    private JLabel lEmail = new JLabel("Email");
    private JLabel lPhoneNumber = new JLabel("Phone number");

    private JTextField tfName = new JTextField(30);
    private JTextField tfSurname = new JTextField(30);
    private JTextField tfBirthdate = new JTextField(30);
    private JTextField tfAddress = new JTextField(30);
    private JTextField tfEmail = new JTextField(30);
    private JTextField tfPhoneNumber = new JTextField(30);

    private JButton btnAdd = new JButton("Add");
    private JButton btnCancel = new JButton("Cancel");

    private StudentDaoImpl studentDao = StudentDaoImpl.getInstance();
    private java.util.List<Student> students;
    private int idx;

    private PanelStudent panelStudent;

    public InsertPanelStudent(PanelStudent panelStudent){

        super(new GridBagLayout());

        this.panelStudent = panelStudent;

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 0;
        panelFields.add(lName, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 0;
        panelFields.add(tfName, gbcPanelFields);
        tfName.setToolTipText("Enter your name");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        panelFields.add(lSurname, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        panelFields.add(tfSurname, gbcPanelFields);
        tfSurname.setToolTipText("Enter your surname");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        panelFields.add(lBirthDate, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        panelFields.add(tfBirthdate, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        panelFields.add(lAddress, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        panelFields.add(tfAddress, gbcPanelFields);
        tfAddress.setToolTipText("Enter your address");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        panelFields.add(lEmail, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        panelFields.add(tfEmail, gbcPanelFields);
        tfEmail.setToolTipText("Enter your email");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        panelFields.add(lPhoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        panelFields.add(tfPhoneNumber, gbcPanelFields);
        tfPhoneNumber.setToolTipText("Enter your phone number");

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++

        JPanel panelOperations = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelOperations = new GridBagConstraints();

        gbcPanelOperations.gridx = 0;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnAdd, gbcPanelOperations);
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAdd.addActionListener(e -> {
            studentDao.add(getStudentsFromFields());
            panelStudent.refreshAfterInsert();
        });

        gbcPanelOperations.gridx = 1;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnCancel, gbcPanelOperations);
        btnCancel.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCancel.addActionListener(e -> {

        });

       //+++++++++++++++++++++++++++++++++++++++

        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelFields, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelOperations, gbcMain);

//        System.out.println("ID --------> " + System.identityHashCode(studentDao));
    }

    private Student getStudentsFromFields(){
        Student student = new Student();

        if (!tfName.getText().isEmpty())
        {
            student.setName(tfName.getText());
        }
        if (!tfSurname.getText().isEmpty())
        {
            student.setSurname(tfSurname.getText());
        }
        if (!tfAddress.getText().isEmpty()){
            student.setAddress(tfAddress.getText());
        }
        if (!tfBirthdate.getText().isEmpty()){
            student.setBirthDate(LocalDate.parse(tfBirthdate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        if (!tfEmail.getText().isEmpty()){
            student.setEmail(tfEmail.getText());
        }
        if (!tfPhoneNumber.getText().isEmpty()){
            student.setPhoneNumber(tfPhoneNumber.getText());
        }
        return student;
    }
}
