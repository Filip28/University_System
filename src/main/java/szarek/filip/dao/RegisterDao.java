package szarek.filip.dao;

import szarek.filip.domain.Register;

import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 05.05.2017.
 */
public interface RegisterDao {
    void add(Register register);
    void update(Register register);
    void delete(int id);
    Optional<Register> getById(int id);
    List<Register> getAll();

}
