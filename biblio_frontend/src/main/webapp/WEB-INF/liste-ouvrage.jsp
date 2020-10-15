<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des ouvrages des Bibliotheques OC</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <a href="<%=request.getContextPath()+response.encodeURL("/")%>">Accueil</a>
</head>
<body>
<p>
<table class="table">
    <tr>
        <td>Nom de l'ouvrage</td>
        <td>Quantité disponible</td>
        <td>Date de retour prévu</td>
        <td>reserver</td>
    </tr>
    <c:forEach items="${resultatExemplaire}" var="resultatExemplaire">
        <tr>
            <td>${resultatExemplaire.nom}</td>
            <td>${resultatExemplaire.nombreDispo}</td>
            <td><fmt:formatDate value ="${resultatExemplaire.dateDeRetourPrevu}"  type = "date"/></td>
            <td>
                <c:if test="${resultatExemplaire.nombreResaPossibles - resultatExemplaire.nombreResaFaites >0}">
                    <a href="<%=request.getContextPath()+response.encodeURL("/reserver")%>/${resultatExemplaire.ouvrageId}">ici</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</p>

</body>