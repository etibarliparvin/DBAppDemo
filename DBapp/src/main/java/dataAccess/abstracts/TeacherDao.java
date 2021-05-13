package dataAccess.abstracts;

import entity.concretes.Teachers;

import java.util.List;

public interface TeacherDao {
    boolean add(Teachers teachers);

    boolean update(Teachers teachers);

    boolean remove(Integer id);

    Teachers getById(Integer id);

    List<Teachers> getAll();
}
