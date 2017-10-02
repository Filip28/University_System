package szarek.filip.panels;

import szarek.filip.dao.RegisterDaoImpl;
import szarek.filip.dao.StudentDaoImpl;
import szarek.filip.dao.UniversityDaoImpl;
import szarek.filip.domain.Register;
import szarek.filip.domain.Student;
import szarek.filip.domain.University;
import szarek.filip.models.JComboboxCustomModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FinallPanel extends JPanel {

    //all Btns
    private JButton btnLeft = new JButton("<<<");
    private JButton btnRight = new JButton(">>>");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnAdd = new JButton("Add");

    //Student

    private JTextField tfId = new JTextField(3);
    private JLabel lNameStudent = new JLabel("Name");
    private JLabel lSurnameStudent = new JLabel("Surname");
    private JLabel lBirthDateStudent = new JLabel("Birthdate");
    private JLabel lAddressStudent = new JLabel("Address");
    private JLabel lEmailStudent = new JLabel("Email");
    private JLabel lPhoneNumberStudent = new JLabel("Phone number");


    private JTextField tfNameStudent = new JTextField(20);
    private JTextField tfSurnameStudent = new JTextField(20);
    private JTextField tfBirthdateStudent = new JTextField(20);
    private JTextField tfAddressStudent = new JTextField(20);
    private JTextField tfEmailStudent = new JTextField(20);
    private JTextField tfPhoneNumberStudent = new JTextField(20);

    private StudentDaoImpl studentDao = StudentDaoImpl.getInstance();
    private java.util.List<Student> students;
    private int idxStudent;

    //Student 2

    private JTextField tfId2 = new JTextField(3);
    private JLabel lNameStudent2 = new JLabel("Name");
    private JLabel lSurnameStudent2 = new JLabel("Surname");
    private JLabel lBirthDateStudent2 = new JLabel("Birthdate");
    private JLabel lAddressStudent2 = new JLabel("Address");
    private JLabel lEmailStudent2 = new JLabel("Email");
    private JLabel lPhoneNumberStudent2 = new JLabel("Phone number");


    private JTextField tfNameStudent2 = new JTextField(20);
    private JTextField tfSurnameStudent2 = new JTextField(20);
    private JTextField tfBirthdateStudent2 = new JTextField(20);
    private JTextField tfAddressStudent2 = new JTextField(20);
    private JTextField tfEmailStudent2 = new JTextField(20);
    private JTextField tfPhoneNumberStudent2 = new JTextField(20);

    private StudentDaoImpl studentDao2 = StudentDaoImpl.getInstance();
    private java.util.List<Student> students2;
    private int idxStudent2;


    //University
    private JLabel lNameUniversity = new JLabel("Name:");
    private JLabel lAdressUniversity = new JLabel("Adress:");
    private JLabel lSetYearUniversity = new JLabel("Year of creation:");
    private JLabel lNameOfDeanUniversity = new JLabel("Dean name:");
    private JLabel lDirectionOfStudyUniversity = new JLabel("Direction:");


    private JTextField tfNameUniversity = new JTextField(20);
    private JTextField tfAdressUniversity = new JTextField(20);
    private JTextField tfSetYearUniversity = new JTextField(20);
    private JTextField tfNameOfDeanUniversity = new JTextField(20);
    private JTextField tfDirectionOfStudyUniversity = new JTextField(20);

    private UniversityDaoImpl universityDao = UniversityDaoImpl.getInstance();
    private java.util.List<University> universities;
    private int idxUniversity;

    //University 2

    private JLabel lNameUniversity2 = new JLabel("Name:");
    private JLabel lAdressUniversity2 = new JLabel("Adress:");
    private JLabel lSetYearUniversity2 = new JLabel("Year of creation:");
    private JLabel lNameOfDeanUniversity2 = new JLabel("Dean name:");
    private JLabel lDirectionOfStudyUniversity2 = new JLabel("Direction:");


    private JTextField tfNameUniversity2 = new JTextField(20);
    private JTextField tfAdressUniversity2 = new JTextField(20);
    private JTextField tfSetYearUniversity2 = new JTextField(20);
    private JTextField tfNameOfDeanUniversity2 = new JTextField(20);
    private JTextField tfDirectionOfStudyUniversity2 = new JTextField(20);

    private UniversityDaoImpl universityDao2 = UniversityDaoImpl.getInstance();
    private java.util.List<University> universities2;
    private int idxUniversity2;

    //Register
    private JLabel lRegisterDate = new JLabel("Register Date:");

    private JTextField tfRegisterDate = new JTextField(20);

    private RegisterDaoImpl registerDao = RegisterDaoImpl.getInstance();
    private java.util.List<Register> registers;
    private int idxRegister;

    //Register 2
    private JLabel lRegisterDate2 = new JLabel("Register Date:");

    private JTextField tfRegisterDate2 = new JTextField(20);
    private java.util.List<Register> registers2;
    private int idxRegister2;

    //comboBox
    private JComboboxCustomModel<Student> cbStudentModel = new JComboboxCustomModel<>(studentDao.getAll());
    private JComboBox cbStudent = new JComboBox<>(cbStudentModel);

    private JComboboxCustomModel<University> cbUniversityModel = new JComboboxCustomModel<>(universityDao.getAll());
    private JComboBox cbUniversity = new JComboBox(cbUniversityModel);
    private JLabel lStudents = new JLabel("Students");
    private JLabel lUniversities = new JLabel("Universities");

    public FinallPanel(){

        super( new GridBagLayout());

        JPanel panelNavigation = new JPanel(new GridBagLayout());
        GridBagConstraints gbcNavigation = new GridBagConstraints();

        gbcNavigation.insets = new Insets(3,5,3,10);


        cbStudent.addActionListener(e -> {
            String nameSurname = (String)cbStudentModel.getSelectedItem();
            if (nameSurname.matches("[A-Z][a-z]+ [A-Z][a-z]+"))
            {
                String[] elements = nameSurname.split(" ");
                Student s = Student.getStudentWithNameAndSurname(studentDao.getAll(), elements[0], elements[1]);
                idxStudent2 = s.getId();
                tfNameStudent2.setText(s.getName());
                tfSurnameStudent2.setText(s.getSurname());
                tfBirthdateStudent2.setText(String.valueOf(s.getBirthDate()));
                tfAddressStudent2.setText(s.getAddress());
                tfEmailStudent2.setText(s.getEmail());
                tfPhoneNumberStudent2.setText(s.getPhoneNumber());
            }
            fillRegisterDateField(idxStudent2, tfRegisterDate2);
        });

        cbUniversity.addActionListener(e -> {
            String nameUniversity = (String)cbUniversityModel.getSelectedItem();

            if (!nameUniversity.isEmpty()){
                String element = nameUniversity;
                University u = University.getUniversityInformation(universityDao.getAll(), element);

                idxUniversity2 = u.getId();
                tfNameUniversity2.setText(u.getName());
                tfAdressUniversity2.setText(u.getAdress());
                tfSetYearUniversity2.setText(String.valueOf(u.getSetYear()));
                tfNameOfDeanUniversity2.setText(u.getDeanName());
                tfDirectionOfStudyUniversity2.setText(u.getDirection());
            }
            fillRegisterDateField(idxStudent2, tfRegisterDate2);

        });

        gbcNavigation.gridx = 0;
        gbcNavigation.gridy = 0;
        panelNavigation.add(btnLeft,gbcNavigation);
        btnLeft.setFont(new Font("Arial",Font.BOLD, 20));
        btnLeft.addActionListener(b -> {
        --idxStudent;
        if (idxStudent < 0){
            idxStudent = students.size() - 1;
        }
            fillAll();
        });

        gbcNavigation.gridx = 1;
        gbcNavigation.gridy = 0;
        tfId.setEditable(false);
        panelNavigation.add(tfId,gbcNavigation);
        tfId.setHorizontalAlignment(JTextField.CENTER);
        tfId.setFont(new Font("Arial",Font.BOLD, 20));

        gbcNavigation.gridx = 2;
        gbcNavigation.gridy = 0;
        panelNavigation.add(btnRight,gbcNavigation);
        btnRight.setFont(new Font("Arial",Font.BOLD, 20));
        btnRight.addActionListener(b -> {
            ++idxStudent;
            if (idxStudent >= students.size()){
                idxStudent = 0;
            }
            fillAll();
        });

        //Panel Student

        JPanel panelFieldStudent = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFieldsStudent = new GridBagConstraints();

        gbcPanelFieldsStudent.insets = new Insets(3,5,3,10);
//        panelFieldStudent.setBorder(BorderFactory.createLineBorder(Color.red, 7));
        panelFieldStudent.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),
                "Students",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 35)));


        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 0;
        lNameStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(lNameStudent,gbcPanelFieldsStudent);


        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 0;
        tfNameStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfNameStudent,gbcPanelFieldsStudent);


        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 1;
        lSurnameStudent.setFont(new Font("Arial", Font.PLAIN,20));
        panelFieldStudent.add(lSurnameStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 1;
        tfSurnameStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfSurnameStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 2;
        lBirthDateStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(lBirthDateStudent, gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 2;
        tfBirthdateStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfBirthdateStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 3;
        lAddressStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(lAddressStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 3;
        tfAddressStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfAddressStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 4;
        lEmailStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(lEmailStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 4;
        tfEmailStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfEmailStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 0;
        gbcPanelFieldsStudent.gridy = 5;
        lPhoneNumberStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(lPhoneNumberStudent,gbcPanelFieldsStudent);

        gbcPanelFieldsStudent.gridx = 1;
        gbcPanelFieldsStudent.gridy = 5;
        tfPhoneNumberStudent.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent.add(tfPhoneNumberStudent,gbcPanelFieldsStudent);

        // Panel student 2

        JPanel panelFieldStudent2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFieldsStudent2 = new GridBagConstraints();


        gbcPanelFieldsStudent2.insets = new Insets(3,5,3,10);

        panelFieldStudent2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),
                "Student",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 35)));


        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 0;
        lNameStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(lNameStudent2,gbcPanelFieldsStudent2);


        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 0;
        tfNameStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfNameStudent2,gbcPanelFieldsStudent2);


        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 1;
        lSurnameStudent2.setFont(new Font("Arial", Font.PLAIN,20));
        panelFieldStudent2.add(lSurnameStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 1;
        tfSurnameStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfSurnameStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 2;
        lBirthDateStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(lBirthDateStudent2, gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 2;
        tfBirthdateStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfBirthdateStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 3;
        lAddressStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(lAddressStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 3;
        tfAddressStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfAddressStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 4;
        lEmailStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(lEmailStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 4;
        tfEmailStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfEmailStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 0;
        gbcPanelFieldsStudent2.gridy = 5;
        lPhoneNumberStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(lPhoneNumberStudent2,gbcPanelFieldsStudent2);

        gbcPanelFieldsStudent2.gridx = 1;
        gbcPanelFieldsStudent2.gridy = 5;
        tfPhoneNumberStudent2.setFont(new Font("Arial", Font.PLAIN, 20));
        panelFieldStudent2.add(tfPhoneNumberStudent2,gbcPanelFieldsStudent2);


        //University Panel

        JPanel panelFieldUniversity = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFieldsUniversity = new GridBagConstraints();

        gbcPanelFieldsUniversity.insets = new Insets(3,5,3,10);
        panelFieldUniversity.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),
                "Universities",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 35)));

        gbcPanelFieldsUniversity.gridx = 0;
        gbcPanelFieldsUniversity.gridy = 0;
        panelFieldUniversity.add(lNameUniversity, gbcPanelFieldsUniversity);
        lNameUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 1;
        gbcPanelFieldsUniversity.gridy = 0;
        panelFieldUniversity.add(tfNameUniversity, gbcPanelFieldsUniversity);
        tfNameUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 0;
        gbcPanelFieldsUniversity.gridy = 1;
        panelFieldUniversity.add(lAdressUniversity, gbcPanelFieldsUniversity);
        lAdressUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 1;
        gbcPanelFieldsUniversity.gridy = 1;
        panelFieldUniversity.add(tfAdressUniversity, gbcPanelFieldsUniversity);
        tfAdressUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 0;
        gbcPanelFieldsUniversity.gridy = 2;
        panelFieldUniversity.add(lSetYearUniversity, gbcPanelFieldsUniversity);
        lSetYearUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 1;
        gbcPanelFieldsUniversity.gridy = 2;
        panelFieldUniversity.add(tfSetYearUniversity, gbcPanelFieldsUniversity);
        tfSetYearUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 0;
        gbcPanelFieldsUniversity.gridy = 3;
        panelFieldUniversity.add(lNameOfDeanUniversity, gbcPanelFieldsUniversity);
        lNameOfDeanUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 1;
        gbcPanelFieldsUniversity.gridy = 3;
        panelFieldUniversity.add(tfNameOfDeanUniversity, gbcPanelFieldsUniversity);
        tfNameOfDeanUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 0;
        gbcPanelFieldsUniversity.gridy = 4;
        panelFieldUniversity.add(lDirectionOfStudyUniversity, gbcPanelFieldsUniversity);
        lDirectionOfStudyUniversity.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity.gridx = 1;
        gbcPanelFieldsUniversity.gridy = 4;
        panelFieldUniversity.add(tfDirectionOfStudyUniversity, gbcPanelFieldsUniversity);
        tfDirectionOfStudyUniversity.setFont(new Font("Arial", Font.PLAIN,20));


        //University Panel 2

        JPanel panelFieldUniversity2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFieldsUniversity2 = new GridBagConstraints();

        gbcPanelFieldsUniversity2.insets = new Insets(3,5,3,10);
        panelFieldUniversity2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,3),
                "Universities",
                TitledBorder.LEFT,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 35)));

        gbcPanelFieldsUniversity2.gridx = 0;
        gbcPanelFieldsUniversity2.gridy = 0;
        panelFieldUniversity2.add(lNameUniversity2, gbcPanelFieldsUniversity2);
        lNameUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 1;
        gbcPanelFieldsUniversity2.gridy = 0;
        panelFieldUniversity2.add(tfNameUniversity2, gbcPanelFieldsUniversity2);
        tfNameUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 0;
        gbcPanelFieldsUniversity2.gridy = 1;
        panelFieldUniversity2.add(lAdressUniversity2, gbcPanelFieldsUniversity2);
        lAdressUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 1;
        gbcPanelFieldsUniversity2.gridy = 1;
        panelFieldUniversity2.add(tfAdressUniversity2, gbcPanelFieldsUniversity2);
        tfAdressUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 0;
        gbcPanelFieldsUniversity2.gridy = 2;
        panelFieldUniversity2.add(lSetYearUniversity2, gbcPanelFieldsUniversity2);
        lSetYearUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 1;
        gbcPanelFieldsUniversity2.gridy = 2;
        panelFieldUniversity2.add(tfSetYearUniversity2, gbcPanelFieldsUniversity2);
        tfSetYearUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 0;
        gbcPanelFieldsUniversity2.gridy = 3;
        panelFieldUniversity2.add(lNameOfDeanUniversity2, gbcPanelFieldsUniversity2);
        lNameOfDeanUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 1;
        gbcPanelFieldsUniversity2.gridy = 3;
        panelFieldUniversity2.add(tfNameOfDeanUniversity2, gbcPanelFieldsUniversity2);
        tfNameOfDeanUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 0;
        gbcPanelFieldsUniversity2.gridy = 4;
        panelFieldUniversity2.add(lDirectionOfStudyUniversity2, gbcPanelFieldsUniversity2);
        lDirectionOfStudyUniversity2.setFont(new Font("Arial", Font.PLAIN,20));

        gbcPanelFieldsUniversity2.gridx = 1;
        gbcPanelFieldsUniversity2.gridy = 4;
        panelFieldUniversity2.add(tfDirectionOfStudyUniversity2, gbcPanelFieldsUniversity2);
        tfDirectionOfStudyUniversity2.setFont(new Font("Arial", Font.PLAIN,20));


        //Delete Panel

        JPanel panellDelete = new JPanel(new GridBagLayout());
        GridBagConstraints gbcDelete = new GridBagConstraints();

        gbcDelete.gridx = 0;
        gbcDelete.gridy = 0;
        btnDelete.setFont(new Font("Arial", Font.BOLD,20));
        btnDelete.addActionListener(d -> {
            deleteStudent();
        });
        panellDelete.add(btnDelete,gbcDelete);

        // ComboBoxStudent

        JPanel comboBoxStudents = new JPanel(new GridBagLayout());
        GridBagConstraints gbcComboBoxStudents = new GridBagConstraints();

        gbcComboBoxStudents.insets = new Insets(3,5,3,10);

        gbcComboBoxStudents.gridx = 0;
        gbcComboBoxStudents.gridy = 0;
        lStudents.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxStudents.add(lStudents,gbcComboBoxStudents);


        gbcComboBoxStudents.gridx = 1;
        gbcComboBoxStudents.gridy = 0;
        cbStudent.setFont(new Font("Arial", Font.PLAIN,20));
        gbcComboBoxStudents.insets = new Insets(3,5,3,10);
        comboBoxStudents.add(cbStudent,gbcComboBoxStudents);


        //ComboBoxStudentUniversity

        JPanel comboBoxUniversity = new JPanel(new GridBagLayout());
        GridBagConstraints gbcComboBoxUniversity = new GridBagConstraints();

        gbcComboBoxUniversity.insets = new Insets(3,5,3,10);

        gbcComboBoxUniversity.gridx = 0;
        gbcComboBoxUniversity.gridy = 0;
        lUniversities.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxUniversity.add(lUniversities,gbcComboBoxUniversity);


        gbcComboBoxUniversity.gridx = 1;
        gbcComboBoxUniversity.gridy = 0;
        cbUniversity.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxUniversity.add(cbUniversity,gbcComboBoxUniversity);


        //Register Date

        JPanel panelRegister = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRegister = new GridBagConstraints();

        gbcRegister.insets = new Insets(3,5,3,10);

        gbcRegister.gridx = 0;
        gbcRegister.gridy = 0;
        lRegisterDate.setFont(new Font("Arial", Font.PLAIN,20));
        panelRegister.add(lRegisterDate,gbcRegister);

        gbcRegister.gridx = 1;
        gbcRegister.gridy = 0;
        tfRegisterDate.setFont(new Font("Arial", Font.PLAIN,20));
        panelRegister.add(tfRegisterDate,gbcRegister);

        //Register Date 2

        JPanel panelRegister2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRegister2 = new GridBagConstraints();

        gbcRegister2.insets = new Insets(3,5,3,10);

        gbcRegister2.gridx = 0;
        gbcRegister2.gridy = 0;
        lRegisterDate2.setFont(new Font("Arial", Font.PLAIN,20));
        panelRegister2.add(lRegisterDate2,gbcRegister2);

        gbcRegister2.gridx = 1;
        gbcRegister2.gridy = 0;
        tfRegisterDate2.setFont(new Font("Arial", Font.PLAIN,20));
        panelRegister2.add(tfRegisterDate2,gbcRegister2);

        //Add panel

        JPanel panelAdd = new JPanel(new GridBagLayout());
        GridBagConstraints gbcAdd = new GridBagConstraints();



        gbcAdd.gridx = 0;
        gbcAdd.gridy = 0;
        btnAdd.setFont(new Font("Arial", Font.BOLD,20));
        panelAdd.add(btnAdd,gbcAdd);
        btnAdd.addActionListener(e -> {
            addStudent();
            addStudentToRegister();
            fillAll();
        });

        //Settings for all panel using GBC

        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.insets = new Insets(15,500,10,-35);
        add(panelNavigation,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        gbcMain.insets = new Insets(0,-100,15,0);
        add(panelFieldStudent,gbcMain);
        
        gbcMain.gridx = 1;
        gbcMain.gridy = 1;
        gbcMain.insets = new Insets(0,-100,60,20);
        add(panelFieldUniversity,gbcMain);

        gbcMain.gridx = 1;
        gbcMain.gridy = 2;
        gbcMain.insets = new Insets(-55,-70,30,40);
        add(panelRegister,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        gbcMain.insets = new Insets(0,335,0,-200);
        gbcMain.anchor = GridBagConstraints.CENTER;
        add(panellDelete,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 4;
        gbcMain.insets = new Insets(0,0,0,300);
        add(comboBoxStudents,gbcMain);

        gbcMain.gridx = 1;
        gbcMain.gridy = 4;
        gbcMain.insets = new Insets(0,0,0,250);
        add(comboBoxUniversity,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 5;
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.insets = new Insets(40,0,0,100);
        add(panelFieldStudent2,gbcMain);


        gbcMain.gridx = 1;
        gbcMain.gridy = 5;
        gbcMain.anchor = GridBagConstraints.WEST;
        gbcMain.insets = new Insets(0,0,0,0);
        add(panelFieldUniversity2,gbcMain);


        gbcMain.gridx = 1;
        gbcMain.gridy = 6;
        gbcMain.insets = new Insets(-40,25,100,0);
        add(panelRegister2,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 7;
        gbcMain.anchor = GridBagConstraints.LINE_END;
        gbcMain.insets = new Insets(-60,-10,10,40);
        add(panelAdd,gbcMain);

        students = studentDao.getAll();
        idxStudent = 0;
        universities = universityDao.getAll();
        idxUniversity = 0;
        registers = registerDao.getAll();
        idxRegister = 0;
        fillAll();


    }

    private void fillStudentsToFields()
    {

        Student student = students.get(idxStudent);
        tfId.setText(String.valueOf(student.getId()));
        tfPhoneNumberStudent.setText(String.valueOf(student.getPhoneNumber()));
        tfEmailStudent.setText(String.valueOf(student.getEmail()));
        tfAddressStudent.setText(String.valueOf(student.getAddress()));
        tfSurnameStudent.setText(String.valueOf(student.getSurname()));
        tfNameStudent.setText(String.valueOf(student.getName()));
        tfBirthdateStudent.setText(String.valueOf(student.getBirthDate()));

    }




    private void fillUniversityWithStudent(){
        Register register = registers.get(idxStudent);
        University university = universities.get(register.getUniversityId()-1);
        tfNameUniversity.setText(String.valueOf(university.getName()));
        tfAdressUniversity.setText(String.valueOf(university.getAdress()));
        tfSetYearUniversity.setText(String.valueOf(university.getSetYear()));
        tfNameOfDeanUniversity.setText(String.valueOf(university.getDeanName()));
        tfDirectionOfStudyUniversity.setText(String.valueOf(university.getDirection()));

    }

    private void fillRegisterDateField(int id, JTextField panel){
        Register register = registers.get(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        panel.setText(register.getRegisterDate().format(formatter));

    }

    private void fillAll(){

        fillStudentsToFields();
        fillUniversityWithStudent();
        fillRegisterDateField(idxStudent,tfRegisterDate);
        fillStudentsToFields();
    }

    private void deleteStudent(){
        int idNumberStudent = Integer.parseInt(tfId.getText());
        studentDao.delete(idNumberStudent);
        students = studentDao.getAll();
        idxStudent = students.size() - 1;

        int idNumberRegister = Integer.parseInt(String.valueOf(idxRegister));
        registerDao.delete(idNumberRegister);
        registers = registerDao.getAll();
        idxRegister = registers.size() - 1;
        fillAll();
    }

    private Student addStudent(){
        Student student = new Student();

        if (!tfNameStudent2.getText().isEmpty())
        {
            student.setName(tfNameStudent2.getText());
        }
        if (!tfSurnameStudent2.getText().isEmpty())
        {
            student.setSurname(tfSurnameStudent2.getText());
        }
        if (!tfAddressStudent2.getText().isEmpty()){
            student.setAddress(tfAddressStudent2.getText());
        }
        if (!tfBirthdateStudent2.getText().isEmpty()){
            student.setBirthDate(LocalDate.parse(tfBirthdateStudent2.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        if (!tfEmailStudent2.getText().isEmpty()){
            student.setEmail(tfEmailStudent2.getText());
        }
        if (!tfPhoneNumberStudent2.getText().isEmpty()){
            student.setPhoneNumber(tfPhoneNumberStudent2.getText());
        }

        return student;
    }

    private Register addStudentToRegister(){
        Register register = new Register();

        register.setStudentId(idxStudent2);
        register.setUniversityId(idxUniversity2);
        register.setRegisterDate(LocalDate.parse(tfRegisterDate2.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        return register;
    }



}
