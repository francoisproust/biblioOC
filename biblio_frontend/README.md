# biblio_frontend


## Contexte
Ce projet a été développé en 2020 dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms et correspond à la partie WEB du projet 7.
Ce site permet aux usagers de consulter le catalogue de consulter leurs prêts de BibliOC.


## Pré-requis
Version de java : 11 (jdk utilisé : jdk11.0.7)
Maven 3.6
biblio_backend (https://github.com/francoisproust/biblio_backend)

## Installation et déploiement
1.Configuration

L'application est livrée pour se connecter à l'api en localhost sur le port 9090 (interface BibliocapiProxy.java).
A modifier si l'API est déployée sur un autre endpoint.

2.Déploiement
  * application standalone intégrant un conteneur web (grace à SpringBoot)
  
        mvn clean spring-boot:run
        
3.Accès

L'application est accessible par http://localhost:8080/
l'application via le JDD fourni contient deux comptes (arsene et francois, mot de passe : password) 
