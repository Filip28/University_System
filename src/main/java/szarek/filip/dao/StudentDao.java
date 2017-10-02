package szarek.filip.dao;

import szarek.filip.domain.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 04.05.2017.
 */
public interface StudentDao {
    void add(Student student);
    void delete(int id);
    Optional<Student> getById(int id);
    List<Student> getAll();
    void update(Student student);


}
