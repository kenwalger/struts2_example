package com.kenwalger.jivetest.view;

import com.kenwalger.jivetest.model.Entry;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken on 5/14/2015.
 */
public class EntryAction extends ActionSupport {

    private static final long serialVersionUID = 9149826260758390091L;
    private Entry entry;
    private List<Entry> entryList;
    private Long id;
    private String OS;
    private String osVersion;
    private String notes;
    private Date created;

    private List<String> entries;


    /**
     *  Constants for database connection settings
     * */

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/jive_ssei_test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";


    /**
    * Executes the data input transaction
    * */

    public String execute() {
        String ret = SUCCESS;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e){
            System.err.println("Exception : Add MySQL JDBC Driver in your classpath");
            System.err.println(e.getMessage());
            ret = ERROR;
        }

        System.out.println("MySQL JDBC Drive Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check console.");
            System.err.println(e.getMessage());
            ret = ERROR;
        }

        if (connection == null) {
            System.out.println("Connection Failed!");
        } else {
            System.out.println("Connection established!");
        }

        try {
            String sql = "INSERT INTO entries (OS, osVersion, notes, created) VALUES(?,?,?, CURRENT_TIMESTAMP)";
            if (connection != null) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, getOs());
                ps.setString(2, getOsVersion());
                ps.setString(3, getNotes());
                ps.executeUpdate();



                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    ret = ERROR;
                }
            }
        }
        return ret;
    }


    /**
     * Form validation.
     * */

    public void validate() {
        if (OS == null || OS.trim().equals("")) {
            addFieldError("OS", "The OS is required.");
        }
        if (osVersion == null || osVersion.trim().equals("")) {
            addFieldError("osVersion", "The OS Version is required.");
        }
    }


    /**
     * Getters and Setters
     * */

    public Entry getEntry() {
        return entry;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public Long getId() {
        return id;
    }
    public String getOs() {
        return OS;
    }
    public String getOsVersion(){
        return osVersion;
    }
    public String getNotes() { return notes; }
    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setOS(String OS) {
        this.OS = OS;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }


    /**
     * Get all of the database entries
     * */

    public ArrayList<Entry> getAllEntries() {
        ArrayList<Entry> entries = new ArrayList<>();
        Entry entry;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e){
            System.err.println("Exception : Add MySQL JDBC Driver in your classpath");
            System.err.println(e.getMessage());
        }

        System.out.println("MySQL JDBC Drive Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check console.");
            System.err.println(e.getMessage());
        }
        if (connection == null) {
            System.out.println("Connection Failed!");
        } else {
            System.out.println("Connection established!");
        }

        try {
            String sql = "SELECT * FROM entries";
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while(resultSet.next()) {

                    entry = new Entry();
                    entry.setOs(resultSet.getString("OS"));
                    entry.setOsVersion(resultSet.getString("osVersion"));
                    entry.setNotes(resultSet.getString("notes"));

                    entries.add(entry);
                }

                resultSet.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return entries;
    }
}
