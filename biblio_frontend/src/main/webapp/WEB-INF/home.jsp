<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Les Bibliotheques d'OC</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
        <meta name="viewport" content="width=device-width,initial-scale=1" />
        <a href="<%=request.getContextPath()+response.encodeURL("/login")%>">Se connecter</a>
        <a href="<%=request.getContextPath()+response.encodeURL("/creation-compte")%>">Créer un compte</a>
        <a href="<%=request.getContextPath()+response.encodeURL("/mon-profil")%>">Mon compte</a>
    </head>
    <body>
        <br>
            Bienvenue sur le site des bibliothèques d'OC</br>
            Rechercher un ouvrage : <a href="<%=request.getContextPath()+response.encodeURL("/rechercher-ouvrage")%>">ici</a>
        </p>
    </body>
</html>