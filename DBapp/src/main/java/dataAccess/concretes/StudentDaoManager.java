package dataAccess.concretes;

import core.abstracts.MyConnectionService;
import dataAccess.abstracts.StudentDao;
import entity.concretes.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoManager implements StudentDao {

    private MyConnectionService myConnectionService;

    public StudentDaoManager(MyConnectionService myConnectionService) {
        this.myConnectionService = myConnectionService;
    }

    private Students getStudent(ResultSet resultSet) throws Exception {
        int id = resultSet.getInt("student_id");
        String name = resultSet.getString("student_name");
        String surname = resultSet.getString("student_surname");
        int age = resultSet.getInt("student_age");
        return new Students(id, name, surname, age);
    }

    @Override
    public boolean add(Students students) {
        try (Connection c = myConnectionService.connect()) {
            String query = "insert into students (student_name, student_surname, student_age) values(?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, students.getStudentName());
            ps.setString(2, students.getStudentSurname());
            ps.setInt(3, students.getStudentAge());
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Students students) {
        try (Connection c = myConnectionService.connect()) {
            String query = "update students set student_name = ?, student_surname = ?, student_age = ? where student_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, students.getStudentName());
            ps.setString(2, students.getStudentSurname());
            ps.setInt(3, students.getStudentAge());
            ps.setInt(4, students.getStudentId());
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Integer id) {
        try (Connection c = myConnectionService.connect()) {
            String query = "delete from students where student_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Students getById(Integer id) {
        try (Connection c = myConnectionService.connect()) {
            String query = "select * from students where student_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            Students students = null;
            if (rs.next()) {
                students = getStudent(rs);
            }
            return students;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Students> getAll() {
        try (Connection c = myConnectionService.connect()) {
            String query = "select * from students";
            PreparedStatement ps = c.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            List<Students> students = new ArrayList<>();
            while (rs.next()) {
                students.add(getStudent(rs));
            }
            return students;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
