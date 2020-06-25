package com.octans.controller;

import com.octans.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployeeController extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            employeeService.deleteEmployeeById(id);
            req.setAttribute("result","success");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("result","failed");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/delete.jsp");
        requestDispatcher.forward(req,resp);
    }
}
