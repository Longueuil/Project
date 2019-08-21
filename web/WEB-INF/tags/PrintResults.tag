
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Prints results" pageEncoding="UTF-8"%>
<%@attribute name="results" required="true" type="java.util.List"%>

<table border="1">
    <tr>
        
        <th>Mark</th>
        <th>Teacher username</th>
        <th>Student username</th>
        <th>Course name</th>
        <th>Edit</th>
        <th>Delete</th>
        
        
    </tr>
    <c:forEach var="result" items="${results}">
        <tr>
            <td>${result.MARK}</td>
            <td>${result.TEACHER_USERNAME}</td>
            <td>${result.STUDENT_USERNAME}</td>
            <td>${result.COURSE_NAME}</td>
            <td><a href="Admin/results/updateResult.html">Edit</a></td>
            <td><a href="Admin/results/deleteResult.html">Delete</a></td>
            
        </tr>
        
    </c:forEach>

        

</table>
<br><br>
<a href="Admin/results/addResult.html">Add New Result</a> 