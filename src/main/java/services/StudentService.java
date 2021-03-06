package services;

import dao.SelectStudent;
import dao.StudentCRUD;
import models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    public static ArrayList<Student> list = new ArrayList<>();

    public StudentService() {
        try {
            list = (ArrayList<Student>) SelectStudent.seclect();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void save(Student student) throws SQLException, ClassNotFoundException {
        StudentCRUD.insert(student);
        list.add(student);
    }

    public void edit(Student student) throws SQLException, ClassNotFoundException {
        StudentCRUD.update(student);
    }

    public void delete(int index) throws SQLException, ClassNotFoundException {
        StudentCRUD.delete(list.get(index).getId());
        list.remove(index);
    }

    public Student findById(int index){
        return list.get(index);
    }
}
