
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Prints a list of teachers" pageEncoding="UTF-8"%>
<%@attribute name="teachers" required="true" type="java.util.List"%>

<table border="1">
    <tr>
        
        <th>Teacher ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th>City</th>
        <th>Country</th>
        <th>Phone number</th>
        <th>Salary</th>
        <th>Username</th>
        <th>Password</th>
        <th>Update</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.TEACHER_ID}</td>
            <td>${teacher.FIRST_NAME}</td>
            <td>${teacher.LAST_NAME}</td>
            <td>${teacher.ADDRESS}</td>
            <td>${teacher.CITY}</td>
            <td>${teacher.COUNTRY}</td>
            <td>${teacher.PHONE_NUMBER}</td>
            <td>${teacher.SALARY}</td>
            <td>${teacher.USERNAME}</td>
            <td>${teacher.PASSWORD}</td>
            <td><a href="Admin/teachers/updateTeacher.html">Edit</a></td>
            <td><a href="Admin/teachers/deleteTeacher.html">Delete</a></td>
            
        </tr>
        
        
    </c:forEach>
        

</table>
<br><br>
<a href="Admin/teachers/addTeacher.html">Add New Teacher</a> 