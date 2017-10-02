package szarek.filip.panels;


import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import szarek.filip.dao.DBConnection;
import szarek.filip.dao.StudentDao;
import szarek.filip.dao.StudentDaoImpl;
import szarek.filip.domain.Student;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.sun.javafx.fxml.expression.Expression.add;

public class UpdatePanelStudent extends JPanel {

    private JLabel lId = new JLabel("id");
    private JLabel lName = new JLabel("Name");
    private JLabel lSurname = new JLabel("Surname");
    private JLabel lBirthDate = new JLabel("Birthdate");
    private JLabel lAddress = new JLabel("Address");
    private JLabel lEmail = new JLabel("Email");
    private JLabel lPhoneNumber = new JLabel("Phone number");


    private JTextField tfId = new JTextField(3);
    private JTextField tfName = new JTextField(30);
    private JTextField tfSurname = new JTextField(30);
    private JTextField tfBirthDate = new JTextField(30);
    private JTextField tfAddress = new JTextField(30);
    private JTextField tfEmail = new JTextField(30);
    private JTextField tfPhoneNumber = new JTextField(30);

    private JButton btnUpdate = new JButton("Update");
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnLeft = new JButton("<<<");
    private JButton btnRight = new JButton(">>>");

    private StudentDaoImpl studentDao = StudentDaoImpl.getInstance();
    private java.util.List<Student> students;
    private int idx;

    private PanelStudent panelStudent;


    public UpdatePanelStudent(PanelStudent panelStudent){

        super(new GridBagLayout());
        this.panelStudent = panelStudent;
      /*  UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        dpBirthDate = new JDatePickerImpl(datePanel);*/

        JPanel panelNavigation = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelNavigation = new GridBagConstraints();

        gbcPanelNavigation.gridx = 0; //kolumna
        gbcPanelNavigation.gridy = 0; //wiersz
        gbcPanelNavigation.ipadx = 40;
        panelNavigation.add(btnLeft, gbcPanelNavigation);
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
        tfId.setEditable(false);
        tfId.setBackground(Color.green);
        tfId.setForeground(Color.red);
        tfId.setHorizontalAlignment(JTextField.CENTER);
        panelNavigation.add(tfId, gbcPanelNavigation);

        gbcPanelNavigation.gridx = 2;
        gbcPanelNavigation.gridy = 0;
        gbcPanelNavigation.ipadx = 40;
        gbcPanelNavigation.insets = new Insets(0, 0, 0, 0);
        panelNavigation.add(btnRight, gbcPanelNavigation);
        btnRight.addActionListener(e -> {
            ++idx;
            if (idx >= students.size()){
                idx = 0;
            }
            fillStudentsFields();
        });

        //-------------------------------------------------------------

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();



        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 1;
        panelFields.add(lName, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 1;
        panelFields.add(tfName, gbcPanelFields);
        tfName.setToolTipText("Enter your name");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 2;
        panelFields.add(lSurname, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 2;
        panelFields.add(tfSurname, gbcPanelFields);
        tfSurname.setToolTipText("Enter your surname");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 3;
        panelFields.add(lBirthDate, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 3;
        panelFields.add(tfBirthDate, gbcPanelFields);

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 4;
        panelFields.add(lAddress, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 4;
        panelFields.add(tfAddress, gbcPanelFields);
        tfAddress.setToolTipText("Enter your address");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 5;
        panelFields.add(lEmail, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 5;
        panelFields.add(tfEmail, gbcPanelFields);
        tfEmail.setToolTipText("Enter your email");

        gbcPanelFields.gridx = 0;
        gbcPanelFields.gridy = 6;
        panelFields.add(lPhoneNumber, gbcPanelFields);

        gbcPanelFields.gridx = 1;
        gbcPanelFields.gridy = 6;
        panelFields.add(tfPhoneNumber, gbcPanelFields);
        tfPhoneNumber.setToolTipText("Enter your phone number");

        //++++++++++++++++++++++++++++++++++++++++

        JPanel panelOperations = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelOperations = new GridBagConstraints();

        gbcPanelOperations.gridx = 0;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnUpdate, gbcPanelOperations);
        btnUpdate.addActionListener(e -> {
            updateStudent();
            panelStudent.refreshAfterUpdate();
        });

        gbcPanelOperations.gridx = 1;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnCancel, gbcPanelOperations);
        btnCancel.addActionListener(e -> {

        });

        //+++++++++++++++++++++++++++++++++++++++++++++++++

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
        tfBirthDate.setText(String.valueOf(student.getBirthDate()));
    }

    private void updateStudent(){

        StudentDaoImpl.getInstance().update(getStudentFromFields());
        panelStudent.refreshAfterUpdate();
    }

    private Student getStudentFromFields(){


        Student student =  new Student(
                tfName.getText(),
                tfSurname.getText(),
                LocalDate.parse(tfBirthDate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                tfAddress.getText(),
                tfEmail.getText(),
                tfPhoneNumber.getText()
        );
        student.setId(Integer.parseInt(tfId.getText()));
        return student;
    }

}
