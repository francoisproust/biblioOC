<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Mon profil</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
        <meta name="viewport" content="width=device-width,initial-scale=1" />
        <a href="<%=request.getContextPath()+response.encodeURL("/")%>">Accueil</a>
        <a href="<%=request.getContextPath()+response.encodeURL("/rechercher-ouvrage")%>">Rechercher Ouvrage</a>
    </head>
    </head>
    <body>
        <p>
            <U>Mes informations personnelles:</U></br>
            Nom : ${usager.nom} </br>
            Prénom : ${usager.prenom} </br>
            Identifiant : ${usager.identifiant} </br>
            Email:  ${usager.email} </br>
        </p>
        <p>
            <U>Mes Exemplaires empruntés:</U></br>
            <table class="table">
                <tr>
                    <td>Nom de l'ouvrage</td>
                    <td>Nom de l'auteur</td>
                    <td>Date de l'emprunt</td>
                    <td>Date de retour</td>
                    <td>Prolonger l'emprunt</td>
                </tr>
                <c:forEach items="${exemplaires}" var="exemplaires">
                    <tr>
                        <td>${exemplaires.ouvrage.nom}</td>
                        <td>${exemplaires.ouvrage.auteur}</td>
                        <td><fmt:formatDate value ="${exemplaires.dateDebut}" pattern="dd MMMMM yyyy" /></td>
                        <td><fmt:formatDate value ="${exemplaires.dateFin}"  pattern="dd MMMMM yyyy" /></td>
                        <td>
                            <c:if test="${exemplaires.prolongation == false}">
                                <a href="<%=request.getContextPath()+response.encodeURL("/prolonger")%>/${exemplaires.exemplaireId}">prolonger</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </p>
    </body>
</html>