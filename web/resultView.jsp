<%@page import="java.util.List"%>
<%@page import="model.dto.ResultV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <jsp:include page="headerC.jsp">
            <jsp:param name="subTitle" value="Results"/>
        </jsp:include>
        
        
        <myTags:PrintResults results="${requestScope.results}"/>
    </body>
</html>
