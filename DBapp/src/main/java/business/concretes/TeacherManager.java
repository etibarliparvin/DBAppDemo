package business.concretes;

import business.abstracts.TeacherService;
import dataAccess.abstracts.TeacherDao;
import entity.concretes.Teachers;

import java.util.List;

public class TeacherManager implements TeacherService {

    private TeacherDao teacherDao;

    public TeacherManager(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public boolean add(Teachers teachers) {
        teacherDao.add(teachers);
        return true;
    }

    @Override
    public boolean update(Teachers teachers) {
        teacherDao.update(teachers);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        teacherDao.remove(id);
        return true;
    }

    @Override
    public Teachers getById(Integer id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<Teachers> getAll() {
        return teacherDao.getAll();
    }
}
