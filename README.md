# WS-Project
## Introduction
Cet API permet de couvrir tous les besoins possibles sur un modèle deBibliothèque – Livre

## Overview
* La bibliothèque aura pour propriétés :
	Un nom (String), une adresse (String), une année de construction (Int), une collection de livres (Livre)

* Le livre aura pour propriétés :
	Un nom (String), une date de parution (Date), un ISBN (String) et un auteur (String)

* Les méthodes HTTP utilisées

    * GET : Récupération d’une ressource ou d’une collection.
	* POST : Création d’une ressource.
	* PUT : Remplacement d’une ressource .
	* DELETE : Suppression d’une ressource ou d’une collection.
	
    Plus exactement :
    La méthode POST peut servir à modifier une ressource mais ce n’est pas recommandé.
    La méthode PUT peut servir à créer une ressource si on en connaît l’identifiant par avance par exemple. La seule contrainte sur la méthode PUT est qu’elle doit être idempotente. Le nombre d’exécution d’une même requête ne doit pas impacter le résultat.

## Authentication
Cet API est sécurisé par un mécanisme d’authentification par des "tokens".
Les “tokens” doivent être transmis dans le “header” X-Auth-Token
`X-Auth-Token: access_token`

URL de demande de token :
http://localhost:8080/wsproject/api/login
    
avec:
 `username = "admin"` et `password = "password"`
    


## Error Codes
L'API utilise ces codes de status pour résumer le résultat de l’opération :

 * 200 : OK
 * 201 : Created
 * 204 : No Content (delete)
 * 400 : Bad Request
 * 401 : Unauthorized
 * 403 : Forbidden
 * 404 : Not Found
 * 405 : Method not allowed
 * 500 : Internal Server Error

## Documentation and Test (collection Postman)

https://documenter.getpostman.com/view/2287531/ws-rest-test-collection/77h84Xi
