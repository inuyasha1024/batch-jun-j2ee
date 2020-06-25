package com.octans.controller;

import com.octans.entity.Employee;
import com.octans.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetEmployeeController extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeService.getEmployeeById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee.jsp");
        dispatcher.forward(request,response);
    }
}
