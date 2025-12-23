package com.sparrow.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B {
    public void sinkCaller3(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String query = "select * from account where name = '" + name + "'";
            
            Y sub = new Y();

            sub.sinkCallee3(query);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}