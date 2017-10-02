package szarek.filip.dao;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Filip on 04.05.2017.
 */
public class DBConnection {

    private Connection connection;
    private Statement statement;
    private static final String DRIVER_NAME = "org.sqlite.JDBC";
    private static final String DATABASE_NAME = "jdbc:sqlite:SystemUniwersytecki.db";

    private DBConnection(){


        try {
            Class.forName(DRIVER_NAME);
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            connection = DriverManager.getConnection(DATABASE_NAME,config.toProperties());
            statement = connection.createStatement();
            createTables();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------

    private static DBConnection instance = null;

    public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    //------------------------------------------
    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    //-------------------------------------------
    private void createTables(){
        try {
            String sqlStudent = "create table if not exists Student (" +
                    "id integer primary key autoincrement, " +
                    "name varchar(50) not null, " +
                    "surname varchar(50) not null, " +
                    "dateOfBirth Date not null, " +
                    "adress varchar(50) not null, " +
                    "email varchar(50) not null, " +
                    "phoneNumber varchar(50) not null " +
                    ");";


            String sqlUniversity = "create table if not exists University (" +
                    "id integer PRIMARY key autoincrement," +
                    "name VARCHAR (50) not null," +
                    "adress VARCHAR (50) not NULL," +
                    "setYear integer not null," +
                    "deanName VARCHAR (50) not null," +
                    "direction VARCHAR (50) not null" +
                    ");";

            String sqlRegister = "CREATE TABLE if not EXISTS Register (" +
                    "id INTEGER PRIMARY key autoincrement," +
                    "studentId integer not null," +
                    "universityId integer not null," +
                    "registerDate date not null," +
                    "FOREIGN key (studentId) REFERENCES Student(id) on DELETE cascade on UPDATE CASCADE," +
                    "FOREIGN key (universityId) REFERENCES University(id) on DELETE CASCADE on UPDATE CASCADE " +
                    ");";


            statement.execute(sqlStudent);
            statement.execute(sqlUniversity);
            statement.execute(sqlRegister);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
