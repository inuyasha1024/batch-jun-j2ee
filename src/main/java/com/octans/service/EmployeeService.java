package com.octans.service;

import com.octans.dao.EmployeeDao;
import com.octans.entity.Employee;

import java.sql.SQLException;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployeeById(String id){
        try {
            return employeeDao.getEmployeeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteEmployeeById(String id) throws SQLException {
        employeeDao.deleteEmployeeById(id);
    }
}
