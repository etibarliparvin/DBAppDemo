package entity.concretes;

import entity.abstracts.Entity;

public class Students implements Entity {
    private Integer studentId;
    private String studentName;
    private String studentSurname;
    private int studentAge;

    public Students() {
    }

    public Students(Integer studentId, String studentName, String studentSurname, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentAge = studentAge;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Students setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Students setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public Students setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
        return this;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public Students setStudentAge(int studentAge) {
        this.studentAge = studentAge;
        return this;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
