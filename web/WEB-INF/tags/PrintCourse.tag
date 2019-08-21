
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Prints a list of teachers" pageEncoding="UTF-8"%>
<%@attribute name="courses" required="true" type="java.util.List"%>

<table border="1">
    <tr>
        
        <th>Course ID</th>
        <th>Course name</th>
        <th>Teacher username</th>
        <th>Student username</th>
        <th>Credits</th>
        <th>Edit</th>
        <th>Delete</th>
        
        
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.COURSE_ID}</td>
            <td>${course.COURSE_NAME}</td>
            <td>${course.TEACHER_USERNAME}</td>
            <td>${course.STUDENT_USERNAME}</td>
            <td>${course.CREDIT}</td>
            <td><a href="Admin/course/updateCourse.html">Edit</a></td>
            <td><a href="Admin/course/deleteCourse.html">Delete</a></td>
            
        </tr>
        
    </c:forEach>
        


</table>
<br><br>
<a href="Admin/course/addCourse.html">Add New Course</a> 