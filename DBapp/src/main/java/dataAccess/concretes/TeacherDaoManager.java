package dataAccess.concretes;

import core.abstracts.MyConnectionService;
import dataAccess.abstracts.TeacherDao;
import entity.concretes.Students;
import entity.concretes.Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoManager implements TeacherDao {

    private MyConnectionService myConnectionService;

    public TeacherDaoManager(MyConnectionService myConnectionService) {
        this.myConnectionService = myConnectionService;
    }

    private Teachers getTeacher(ResultSet resultSet) throws Exception {
        int id = resultSet.getInt("teacher_id");
        String name = resultSet.getString("teacher_name");
        String surname = resultSet.getString("teacher_surname");
        int age = resultSet.getInt("teacher_age");
        return new Teachers(id, name, surname, age);
    }

    @Override
    public boolean add(Teachers teachers) {
        try (Connection c = myConnectionService.connect()) {
            String query = "insert into teachers (teacher_name, teacher_surname, teacher_age) values(?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, teachers.getTeacherName());
            ps.setString(2, teachers.getTeacherSurname());
            ps.setInt(3, teachers.getTeacherAge());
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Teachers teachers) {
        try (Connection c = myConnectionService.connect()) {
            String query = "update teachers set teacher_name = ?, teacher_surname = ?, teacher_age = ? where teacher_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, teachers.getTeacherName());
            ps.setString(2, teachers.getTeacherSurname());
            ps.setInt(3, teachers.getTeacherAge());
            ps.setInt(4, teachers.getTeacherId());
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Integer id) {
        try (Connection c = myConnectionService.connect()) {
            String query = "delete from teachers where teacher_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Teachers getById(Integer id) {
        try (Connection c = myConnectionService.connect()) {
            String query = "select * from teachers where teacher_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            Teachers teachers = null;
            if (rs.next()) {
                teachers = getTeacher(rs);
            }
            return teachers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Teachers> getAll() {
        try (Connection c = myConnectionService.connect()) {
            String query = "select * from teachers";
            PreparedStatement ps = c.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            List<Teachers> teachers = new ArrayList<>();
            while (rs.next()) {
                teachers.add(getTeacher(rs));
            }
            return teachers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
