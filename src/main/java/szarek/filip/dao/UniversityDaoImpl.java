package szarek.filip.dao;

import szarek.filip.domain.University;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 05.05.2017.
 */
public class UniversityDaoImpl implements UniversityDao {


    private static UniversityDaoImpl instance = null;
    private UniversityDaoImpl(){};
    public static UniversityDaoImpl getInstance(){
        if (instance == null){
            instance = new UniversityDaoImpl();
        }
        return instance;
    }

    private DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void add(University university) {

        try {
            String sql = "insert into University" +
                    "(name, adress, setYear, deanName, direction)" +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setString(1,university.getName());
            ps.setString(2,university.getAdress());
            ps.setInt(3,university.getSetYear());
            ps.setString(4,university.getDeanName());
            ps.setString(5,university.getDirection());

            ps.execute();

        }
        catch (SQLException e ){
            e.printStackTrace();
        }

    }

    @Override
    public void update(University university) {

        try {
            String sqlUpdate = "UPDATE University SET name = ?, adress = ?, setYear = ?, deanName = ?, direction = ? WHERE id = ?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sqlUpdate);
            ps.setString(1,university.getName());
            ps.setString(2,university.getAdress());
            ps.setInt(3,university.getSetYear());
            ps.setString(4,university.getDeanName());
            ps.setString(5,university.getDirection());
            ps.setInt(6,university.getId());

            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sqlDelete = "SELECT FROM University WHERE id = ?";
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(sqlDelete);
            ps.setInt(1,id);

            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<University> getById(int id) {
        Optional<University> op = Optional.ofNullable(null);

        try {
            String sql = "select * from University where id = ?";

            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){

                University university = new University(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                        );
                university.setId(rs.getInt(1));
                op = Optional.of(university);
            }

        }
        catch (SQLException e ){
            e.printStackTrace();
        }


        return op;
    }

    @Override
    public List<University> getAll() {
        List<University> universities = null;

        String sql = "select * from University";

        try {

            ResultSet rs = dbConnection.getStatement().executeQuery(sql);
            universities = new ArrayList<>();
            while (rs.next()){
                University university = new University(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                university.setId(1);
                universities.add(university);
            }
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
        return universities;
    }
}
