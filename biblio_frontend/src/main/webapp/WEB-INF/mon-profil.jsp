<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                        <td><fmt:formatDate value ="${exemplaires.dateDebut}"  type = "date" /></td>
                        <td><fmt:formatDate value ="${exemplaires.dateFin}"  type = "date" /></td>
                        <td>
                            <c:if test="${exemplaires.prolongation == false}">
                                <c:if test="${datedujour le exemplaires.dateFin}">
                                    <a href="<%=request.getContextPath()+response.encodeURL("/prolonger")%>/${exemplaires.exemplaireId}">prolonger</a>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </p>
        <p>
            <U>Mes réservations demandées:</U></br>
            <table class="table">
                <tr>
                    <td>Nom de l'ouvrage</td>
                    <td>Date du prochain retour</td>
                    <td>Rang dans la liste d'attente</td>
                    <td>Annuler</td>
                </tr>
                <tr>
                    <c:forEach items="${mesreservations}" var="mesreservations">
                        <td>${mesreservations.nomOuvrage}</td>
                        <td><fmt:formatDate value ="${mesreservations.dateDeRetour}"  type = "date"/></td>
                        <td>${mesreservations.rang}</td>
                        <td>
                            <a href="<%=request.getContextPath()+response.encodeURL("/annuler-reservation")%>/${mesreservations.reservationId}">ici</a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </p>
    </body>
</html>