package szarek.filip.panels;


import szarek.filip.dao.UniversityDaoImpl;
import szarek.filip.domain.University;

import javax.swing.*;
import java.awt.*;

public class InsertPanelUniversity extends JPanel{


    //labels
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

    private JButton btnAdd = new JButton("Add");
    private JButton btnCancel = new JButton("Cancel");

    private UniversityDaoImpl universityDao = UniversityDaoImpl.getInstance();
    private java.util.List<University> universities;
    private int idx;

    private PanelUniversity panelUniversity;


    public InsertPanelUniversity(PanelUniversity panelUniversity){

        super(new GridBagLayout());

        this.panelUniversity = panelUniversity;

        JPanel panelFields = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelFields = new GridBagConstraints();


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

        gbcPanelOperations.insets = new Insets(10,10,4,10);


        gbcPanelOperations.gridx = 0;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnAdd, gbcPanelOperations);
        btnAdd.setFont(new Font("Arial", Font.PLAIN,20));
        btnAdd.addActionListener(e -> {
            universityDao.add(getUniversityFromFields());
            panelUniversity.refreshAfterInsert();
        });

        gbcPanelOperations.gridx = 1;
        gbcPanelOperations.gridy = 0;
        panelOperations.add(btnCancel, gbcPanelOperations);
        btnCancel.setFont(new Font("Arial", Font.PLAIN,20));



        //-------------------------------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelFields, gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
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

    private University getUniversityFromFields(){
        University university = new University();
        if (!tfName.getText().isEmpty()){
            university.setName(tfName.getText());
        }
        if (!tfAdress.getText().isEmpty()){
            university.setAdress(tfAdress.getText());
        }
        if (!tfSetYear.getText().isEmpty()){
            university.setSetYear(Integer.valueOf(tfSetYear.getText()));
        }
        if (!tfNameOfDean.getText().isEmpty()){
            university.setDeanName(tfNameOfDean.getText());
        }
        if (!tfDirectionOfStudy.getText().isEmpty()){
            university.setDirection(tfDirectionOfStudy.getText());
        }
        return university;
    }
}
