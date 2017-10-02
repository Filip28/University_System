package szarek.filip.dao;

import szarek.filip.domain.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 04.05.2017.
 */
public class StudentDaoImpl implements StudentDao{

    private static StudentDaoImpl instance = null;
    private StudentDaoImpl(){};
    public static StudentDaoImpl getInstance(){
        if (instance == null){
            instance = new StudentDaoImpl();
        }
        return instance;
    };

    private DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void add(Student student) {

        try {
            String sql = " insert into Student" +
                    "(name,surname,dateOfBirth, adress, email, phoneNumber)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setString(2,student.getSurname());
            ps.setDate(3, Date.valueOf(student.getBirthDate()));
            ps.setString(4,student.getAddress());
            ps.setString(5,student.getEmail());
            ps.setString(6,student.getPhoneNumber());

            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int id) {

        try {
            String deleteSQL = "delete from Student where id = ?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(deleteSQL);
            ps.setInt(1,id);

            ps.execute();
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            String updateSQL = "update Student set name = ?, surname = ?, dateOfBirth = ?, adress = ?, email = ?, phoneNumber = ? where id = ?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(updateSQL);
            ps.setString(1,student.getName());
            ps.setString(2,student.getSurname());
            ps.setDate(3, Date.valueOf(student.getBirthDate()));
            ps.setString(4,student.getAddress());
            ps.setString(5,student.getEmail());
            ps.setString(6,student.getPhoneNumber());
            ps.setInt(7,student.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Student> getById(int id) {
        Optional<Student> op = Optional.ofNullable(null);

        try {
            String sql = "select  * from Student where id = ?";
            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Student student = new Student(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                student.setId(rs.getInt(1));
                op = Optional.of(student);
            }

        }
        catch (SQLException e ){
            e.printStackTrace();
        }

        return op;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = null;

        String sql = "select * from Student";

        try {
            ResultSet rs = dbConnection.getStatement().executeQuery(sql);
            students = new ArrayList<>();
            while (rs.next()){
                Student s = new Student(rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(),rs.getString(5),rs.getString(6),rs.getString(7));
                s.setId(rs.getInt(1));
                students.add(s);
            }

        }
        catch (SQLException e ){
            e.printStackTrace();
        }
        return students;
    }




}
