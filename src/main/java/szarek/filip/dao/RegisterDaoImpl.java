package szarek.filip.dao;

import szarek.filip.domain.Register;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 05.05.2017.
 */
public class RegisterDaoImpl implements RegisterDao {

    private static RegisterDaoImpl instance = null;
    public RegisterDaoImpl(){};
    public static RegisterDaoImpl getInstance(){
        if (instance == null){
            instance = new RegisterDaoImpl();
        }
        return instance;
    };



    private DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void add(Register register) {
        try {

            String sql = "insert into Register " +
                    "(studentId,universityId,registerDate)" +
                    "VALUES (?, ?, ?)";

            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,register.getStudentId());
            ps.setInt(2,register.getUniversityId());
            ps.setDate(3, Date.valueOf(register.getRegisterDate()));

            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Register register) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<Register> getById(int id) {
        Optional<Register> op = Optional.ofNullable(null);

        try {
            String sql = "SELECT  * from Register where id = ?";

            PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Register register = new Register(
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4).toLocalDate()
                );
                register.setId(rs.getInt(1));
                op = Optional.of(register);
            }

            ps.execute();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return op;
    }

    @Override
    public List<Register> getAll() {

        List<Register> registers = null;

        String sql = "select * from Register";

        try {
            ResultSet rs = dbConnection.getStatement().executeQuery(sql);
            registers = new ArrayList<>();
            while (rs.next()){
                Register r = new Register(rs.getInt(2),rs.getInt(3),rs.getDate(4).toLocalDate());
                r.setId(rs.getInt(1));
                registers.add(r);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return registers;
    }
}
