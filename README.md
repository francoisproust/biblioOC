# MyERP
[![Build Status](https://travis-ci.com/francoisproust/biblioOC.svg?branch=main)](https://travis-ci.com/francoisproust/biblioOC)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=francoisproust_biblioOC&metric=alert_status)](https://sonarcloud.io/dashboard?id=francoisproust_biblioOC)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=francoisproust_biblioOC&metric=coverage)](https://sonarcloud.io/dashboard?id=francoisproust_biblioOC)

## Contexte
Ce projet a été développé en 2020 dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms.

Il regroupe les 3 modules du projet 7 : Développez le nouveau système d’information de la bibliothèque d’une grande ville (Front / API / Batch).
Les modules sont indépendants, packagés par Maven et disposent d'une documentation via leur fichier README.md respectif.
 
release 1.0.0 :
Mise en place d'un site permettant aux usagers de BibliOC de consulter le catalogue, consulter leurs prêts et renouveler cette période une fois. 
Mise en place d'un batch de mail de relance pour les retards de restitution de livres.

release 1.1.0
Ajout d'un fonctionnalite de réservation des ouvrages (https://github.com/francoisproust/biblioOC/issues/1)

## Installation et déploiement
1.Configuration

Chaque module est indépendant et dispose de sa propre configuration (se référer à leur readme pour plus d'information).

Cependant les modules front (bibliocweb) et batch (bibliocbatch) necessitent que le module API (bibliocapi) soit actif.
De plus, les modules API et batch necessitent qu'un serveur SMTP soit parametré. La configuration du serveur SMTP doit être renseignée dans les fichiers src\resources\application.properties du module correspondant.
Le repo est configuré pour l'utilisation d'un serveur SMTP local fakeSMTP (http://nilhcem.com/FakeSMTP/)

L'application est configurée par défaut pour packager : 
le module API sur l'adresse http://localhost:9090/ 
le module front sur l'adresse http://localhost:8080/

2.Déploiement

  * création des packages via la commande à la racine du repository :
  
        mvn clean package

  * lancement du serveur SMTP (ici fakeSMTP)
    
        java -jar fakeSMTP\fakeSMTP-2.0.jar -s
    
  * lancement de l'API
    
        java -jar bibliocapi\target\bibliocapi-1.1.0.war

  * lancement du site WEB
    
        java -jar bibliocweb\target\bibliocweb-1.1.0.war
          
3.Accès - Utilisation

  * Accès au site WEB
  
Le site est accessible par http://localhost:8080/

* Accès à l'API
    
L'API est exposée via l'URL : http://localhost:9090/ 