package com.kenwalger.jivetest.util;

/**
 * Created by Ken on 5/15/2015.
 */

import com.kenwalger.jivetest.view.EntryAction;

import java.sql.*;


public class EntryDao {

    public static int saveData(EntryAction r) {
        int status = 0;
        Connection connection = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/jive_ssei_test";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "root");
            String sql = "INSERT INTO entries VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, r.getId());
            ps.setString(2, r.getOS());
            ps.setString(3, r.getOsVersion());
            ps.setString(4, r.getNotes());
            ps.setDate(5, r.getCreated());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } return status;
    }
}
