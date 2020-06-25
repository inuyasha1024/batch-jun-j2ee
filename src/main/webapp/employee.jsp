<%@ page import="com.octans.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    <table align="center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Job</th>
            <th>Manager</th>
            <th>Salary</th>
            <th>HireDate</th>
            <th>DeptID</th>
        </tr>
        <tr>
            <% Employee employee = (Employee) request.getAttribute("employee");%>
            <th><%=employee.getEmpid()%></th>
            <th><%=employee.getName()%></th>
            <th><%=employee.getJob()%></th>
            <th><%=employee.getManager()%></th>
            <th><%=employee.getSalary()%></th>
            <th><%=employee.getHiredate()%></th>
            <th><%=employee.getDeptid()%></th>
        </tr>
    </table>
</body>
</html>
