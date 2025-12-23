package com.sparrow.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Y {
    private Statement stmt;
    private ResultSet rs;
    
    public Y() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@ip:1521:ora9", "john", password);
            this.stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public void sinkCallee2(String query) {
        stmt.execute(query);
    }
    
    public void sinkCallee3(String query) {
        stmt.execute(query);
    }
    
    public void sinkCaller4(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String query = "select * from account where name = '" + name + "'";
            
            K sub = new K();

            sub.sinkCallee4(query);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}