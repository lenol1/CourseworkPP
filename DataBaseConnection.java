package com.example.demo2.Db;

import com.example.demo2.Objects.Toy;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection {
    protected static final String dbhost = "localhost";
    protected static final String dbport = "3306";
    protected static final String dbuser = "root";
    protected static final String dbpassword = "123456";
    protected static final String dbname = "toys";


    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname+
                "?characterEncoding=utf8",dbuser,dbpassword);
        return con;
    }

    public static List<Toy> FillToyList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String query = "SELECT TypeName,ToyName,Cost,SizeCategory,Number FROM toys.toysinfo ti " +
                "join toys.toy_type tt on ti.TypeId = tt.TypeId";
        List<Toy> toys = new ArrayList<>();
        try (PreparedStatement prst = getDbConnection().prepareStatement(query)) {
            try (ResultSet rs = prst.executeQuery()){
                while (rs.next()) {
                    Toy toy = new Toy(rs.getString("TypeName"),
                            rs.getString("ToyName"), rs.getDouble("Cost"),
                            rs.getString("SizeCategory"),rs.getInt("Number"));
                    toys.add(toy);
                }
                getDbConnection().close();
                return toys;
            }
        }
    }

}
