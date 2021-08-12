package dao;

import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCRUD {
    static Connection connection;

    static {
        try {
            connection = Connect.getConnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Student student) throws SQLException, ClassNotFoundException {


        String create = "insert into personal values(?,?,?,?,?,?,?)";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setInt(1, student.getId());
        prep.setString(2, student.getName());
        prep.setString(3, student.getDate());
        prep.setString(4, student.getAddress());
        prep.setString(5, student.getPhone());
        prep.setString(6, student.getEmail());
        prep.setInt(7, student.getId_dp());
        prep.execute();
    }
    public static void update(Student student) throws SQLException, ClassNotFoundException {

        String create = "update personal " +
                "set name = ?, date = ?, address = ?, phone = ?, email = ?, dp_id = ? " +
                "where id = ?";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setString(1, student.getName());
        prep.setString(2, student.getDate());
        prep.setString(3, student.getAddress());
        prep.setString(4, student.getPhone());
        prep.setString(5, student.getEmail());
        prep.setInt(6, student.getId_dp());
        prep.setInt(7, student.getId());
        prep.execute();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = connection.prepareStatement("delete from personal where id =?");
        prep.setInt(1,id);
        prep.execute();

    }
}
