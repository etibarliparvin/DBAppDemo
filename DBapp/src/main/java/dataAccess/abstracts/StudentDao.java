package dataAccess.abstracts;

import entity.concretes.Students;

import java.util.List;

public interface StudentDao {
    boolean add(Students students);

    boolean update(Students students);

    boolean remove(Integer id);

    Students getById(Integer id);

    List<Students> getAll();
}
