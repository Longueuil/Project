<%@page import="java.util.List"%>
<%@page import="model.dto.TeacherV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teachers</title>
    </head>
    <body>
        <jsp:include page="headerT.jsp">
            <jsp:param name="subTitle" value="Teachers"/>
        </jsp:include>
        
        
        <myTags:PrintTeachers teachers="${requestScope.teachers}"/>
    </body>
</html>
