# OPower

Ce projet est une application J2EE simple. Le modèle métier est le suivant :
- Des objets Person (personne) ayant comme attributs un nom, un prénom, un email et une liste de maisons.
- Des objets Home (maison) ayant comme attributs un nombre de pièces, une taille, une liste de chauffages et une liste d'appareil électronique.
- Des objets Heater (chauffage) ayant comme attributs un nom et une consommation électrique.
- Des objets ElectroniceDevice (appareil électronique) ayant les mêmes attributs que Heater. Il n'existe aucune relation d'héritage entre ces deux classes.

Ces objets sont persistés par l'intermédiaire de classes respectives DAO proposant les actions de bases que sont :
- Create pour créer un objet en bdd
- RetrieveById pour récupérer un objet à partir de son ID
- RetrieveAll pour récupérer tous les objets d'une classe donnée
- Update pour mettre à jour un objet
- Delete et DeleteById pour supprimer un objet
les numéro d'ID sont spécifiques à chaque classe, c'est à dire que deux objets de classe différentes peuvent avoir le même numéro d'ID. 
Enfin, chacune des classes métiers dispose d'une classe Rest permettant d'effectuer par une requête Http les actions précédemment décrites. Ces services sont simplifiés puisqu'elles ne renvoient aucune réponse spécifique (sauf pour les requêtes Get évidemment). Les objets Heater et ElectroniceDevice ne traitent pas les requêtes PUT ni DELETE.
La création d'objet par service Rest n'utilise que les attributs simples. L'ajout d'objet se fait par l'intermédiaire des requêtes PUT

Pour la configuration, la base de donnée utilisée est de type HSQL, et la persistence se fait par l'intermédiaire d'Hibernate.


Après avoir cloné le projet, il faut le compiler simplement par "mvn clean install". Il faut ensuite lancer la BDD HSQL. Pour vérifier l'état de la base, on peut se connecter à l'adresse jdbc:hsqldb:hsql://localhost/ avec le nom d'utilisateur sa et aucun mot de passe par un logiciel dédié. 
Enfin, on lance l'application par la commande "mvn tomcat7:run". Les requêtes sont à envoyer à l'adresse localhost:8080/rest/...
J'ai proposé une ébauche d'interface Web avec AngularJS pour manipuler les données par navigateur. Mais cette interface reste une ébauche, non fonctionnelle, mes compétences en Javascript et AngularJS étant trop jeunes. Cependant, les services Rest peuvent quand même être testés par l'intermédiaire d'un client isolé dédié.
L'architecture Rest est la suivante : 
- pour accéder aux objets, il faut envoyer une requête GET à localhost:8080/rest/<objet voulu>/<all pour avoir tous les objets, ID pour un objet ID en particulier>
- pour créer un objet, il faut envoyer une requête POST à localhost:8080/rest/<objet voulu> avec l'header Content-type = application/x-www-form-urlencoded et les données sous la forme des résultats d'un formulaire (certains client Rest propose facilement cette représentation)
- pour modifier un objet, il faut envoyer une requête PUT à localhost:8080/rest/<objet voulu> en passant l'id de l'objet à modifier dans les données, pas dans le chemin
- pour supprimer un objet, il faut envoyer une requête DELETE à localhost:8080/rest/<objet voulu>/id pour supprimer l'objet id

En dehors de l'interface web incomplète, les requêtes DELETE ne fonctionnent pas ni la requête retrieveAll<ElectroniceDevice>
