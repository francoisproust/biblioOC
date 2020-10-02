# biblio_backend

## Contexte
Ce projet a été développé en 2020 dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms et correspond à la partie API du projet 7.
Cette API permet d'exposer les informatinos concernant le catalogues et la gestion des prêts d'une bibliothèque.

## Pré-requis
Version de java : 11 (jdk utilisé : jdk11.0.7)
Maven 3.6

## Installation et déploiement
1.Configuration
une base PostgresSQL (pré-installation nécessaire) à paramétrer et peupler
Les paramètres de connection à la base sont à modifier dans le fichier src\resources\application-prod.properties (spring.datasource.url, spring.datasource.username et spring.datasource.password)

2.Déploiement
  * application standalone intégrant un conteneur web (grace à SpringBoot)
  
        mvn clean spring-boot:run

3.Accès
Le backend est accessible via l'url http://localhost:9090/
