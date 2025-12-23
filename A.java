package com.sparrow.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A {
    public void sinkCaller1(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String query = "select * from account where name = '" + name + "'";
            
            X sub = new X();
            
            sub.sinkCallee1(query);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    public void sinkCaller2(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String query = "select * from account where name = '" + name + "'";
            
            Y sub = new Y();

            sub.sinkCallee2(query);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}