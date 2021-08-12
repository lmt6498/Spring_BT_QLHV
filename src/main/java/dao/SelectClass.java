package dao;

import models.Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectClass {
    static String select = "select * from department";
    public static List<Classes> select() throws SQLException, ClassNotFoundException {
        ArrayList<Classes> listDP = new ArrayList<>();
        Connection connection = Connect.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id_pb"));
            String name = resultSet.getString("name_pb");

            listDP.add(new Classes(id,name));
        }
        return listDP;
    }
}
