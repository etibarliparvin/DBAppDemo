package entity.concretes;

import entity.abstracts.Entity;

public class Teachers implements Entity {
    private Integer teacherId;
    private String teacherName;
    private String teacherSurname;
    private int teacherAge;

    public Teachers(Integer teacherId, String teacherName, String teacherSurname, int teacherAge) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherAge = teacherAge;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public Teachers setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teachers setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public Teachers setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
        return this;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public Teachers setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
        return this;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSurname='" + teacherSurname + '\'' +
                ", teacherAge=" + teacherAge +
                '}';
    }
}
