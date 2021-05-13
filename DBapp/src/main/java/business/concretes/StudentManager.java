package business.concretes;

import business.abstracts.StudentsService;
import dataAccess.abstracts.StudentDao;
import entity.concretes.Students;

import java.util.List;

public class StudentManager implements StudentsService {

    private StudentDao studentDao;

    public StudentManager(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public boolean add(Students students) {
        studentDao.add(students);
        return true;
    }

    @Override
    public boolean update(Students students) {
        studentDao.update(students);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        studentDao.remove(id);
        return true;
    }

    @Override
    public Students getById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Students> getAll() {
        return studentDao.getAll();
    }
}
