package services;

import dao.SelectClass;
import models.Classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClassesService {
    public static ArrayList<Classes> listDP = new ArrayList<>();

    public ClassesService() {
        try {
            listDP = (ArrayList<Classes>) SelectClass.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
