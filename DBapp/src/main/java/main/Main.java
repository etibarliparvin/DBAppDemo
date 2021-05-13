package main;

import business.abstracts.StudentsService;
import business.concretes.StudentManager;
import core.concretes.MyConnectionServiceAdapter;
import dataAccess.concretes.StudentDaoManager;
import entity.concretes.Students;

public class Main {
    public static void main(String[] args) {
        StudentsService studentsService = new StudentManager(new StudentDaoManager(new MyConnectionServiceAdapter()));
        System.out.println(studentsService.getById(1));
    }
}
