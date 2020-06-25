package com.octans.dao;

import com.octans.entity.Employee;
import com.octans.utils.DatabaseConnection;

import java.sql.*;

public class EmployeeDao {

    public Employee getEmployeeById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DatabaseConnection.getConnection();
            String sql = "select * from employee where empid = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            resultSet=statement.executeQuery();
            Employee employee = new Employee();
            while(resultSet.next()){
                employee.setEmpid(resultSet.getInt("empid"));
                employee.setName(resultSet.getString("name"));
                employee.setJob(resultSet.getString("job"));
                employee.setHiredate(resultSet.getString("hiredate"));
                employee.setManager(resultSet.getString("manager"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDeptid(resultSet.getString("deptid"));
            }
            return employee;

        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally {
            if (connection !=null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }

        }
    }

    public void deleteEmployeeById(String id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = null;
        try {

//        ResultSet resultSet = null;
            String sql = "delete from employee where empid = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.execute();
        }finally {
            if (connection !=null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        }


    }

    public static void main(String[] args) throws SQLException {
        Employee employee = new EmployeeDao().getEmployeeById("7369");
        System.out.println(employee);
    }
}
