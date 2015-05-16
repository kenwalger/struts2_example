package com.kenwalger.jivetest.util;

/**
 * Created by Ken on 5/15/2015.
 */

import com.kenwalger.jivetest.view.EntryAction;

import java.sql.*;

public class EntryDao {

    public static int save(EntryAction r) {
        int status = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:3306:xe","system","oracle");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO entries VALUES(?,?,?,?,?)");
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
