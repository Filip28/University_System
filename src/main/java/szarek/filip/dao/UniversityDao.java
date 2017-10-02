package szarek.filip.dao;

import szarek.filip.domain.University;

import java.util.List;
import java.util.Optional;

/**
 * Created by Filip on 05.05.2017.
 */
public interface UniversityDao {
    void add(University university);
    void update(University university);
    void delete(int id);
    Optional<University> getById(int id);
    List<University> getAll();

}
