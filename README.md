# SAE33

Description du projet:

J'avais comme projet de creer un objet connnecté en utilisant le matériel suivant : Kit de chez Adeept comprenant énormément de composants.
Je suis donc parti sur l'idée de faire une plante avec 3 capteurs qui permettrait de suivre l'état de la plante avec comme contrainte la réalisation d'un serveur java.

## Dépendances

Les dépendances à installer sont :jSerialComm-2.9.3.jar, jssc-2.9.4.jar,mckoidb.jar, mysql-connector-java-8.0.30.jar, protobuf-java-3.19.4.jar, rs-java-lang-0.1.5.jar et rxtx-2.2.2.jar.
Tout ça est à intégrer dans le Classpath de VisualStudioCode : Ctrl + Maj + p , rechercher "Java: Configure Classpath" puis les ajouter.

## Installation

Il faut installer le projet sur votre PC, une fois cela fait créer la base de donnée avec le fichier sae33.sql dans le dossier public.


## Utilisation

Tout d'abord brancher l'Arduino au PC, regarder quel port est utilisé (Si le port utilisé n'est pas COM3 changer la valeur port dans le fichier Serveur.java). Ensuite lancer VisualStudioCode ouvrir le projet, ouvrer un nouveau terminal, lancer le serveur javascript avec la commande suivante : npx nodemon .\serveur.js, puis aller sur le fichier Serveur.java afin de lancer ce programme pour récupérer les données voulus. Pour visualiser le site où sont envoyés les données, ouvrer un moteur de recherche puis taper dans la barre de recherche: http://localhost:8080.


