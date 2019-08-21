
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Prints a list of students" pageEncoding="UTF-8"%>
<%@attribute name="students" required="true" type="java.util.List"%>

<table border="1">
    <tr>
        
        <th>Student ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th>City</th>
        <th>Country</th>
        <th>Phone number</th>
        <th>Course ID</th>
        <th>Teacher username</th>
        <th>Student username</th>
        <th>Password</th>
        <th>Update</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.STUDENT_ID}</td>
            <td>${student.FIRST_NAME}</td>
            <td>${student.LAST_NAME}</td>
            <td>${student.ADDRESS}</td>
            <td>${student.CITY}</td>
            <td>${student.COUNTRY}</td>
            <td>${student.PHONE_NUMBER}</td>
            <td>${student.COURSE_ID}</td>
            <td>${student.TEACHER_USERNAME}</td>
            <td>${student.USERNAME}</td>
            <td>${student.PASSWORD}</td>
            <td><a href="Admin/students/updateStudent.html">Edit</a></td>
            <td><a href="Admin/students/deleteStudent.html">Delete</a></td>
            
        </tr>
       
    </c:forEach>

       

</table>
<br>
<a href="Admin/students/addStudent.html">Add New User</a> 