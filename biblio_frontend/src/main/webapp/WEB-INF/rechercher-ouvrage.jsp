<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Rechercher ouvrage</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <form:form method="POST" modelAttribute="ouvrage" action="rechercher-ouvrage">
                <form:input type="text" path="nom" class="form-control form-control-sm mb-3" placeholder="Nom"
                            autofocus="true"/>
                <form:input type="text" path="auteur" class="form-control form-control-sm mb-3" placeholder="Auteur"
                            autofocus="true"/>
                <form:input type="text" path="isbn" class="form-control form-control-sm mb-3" placeholder="Isbn"
                            autofocus="true"/>

                <input type="submit" class="btn btn-success" value="Rechercher"/>
                <input type="reset" class="btn btn-danger" value="Reset"/>
                <a class="btn btn-warning" href="http://localhost:8080/">Cancel</a>
            </form:form>
        </div>
    </div>
</div>
</body>