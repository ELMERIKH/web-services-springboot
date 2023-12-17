# web-services-springboot
Service Client (customer-serivce) :

Gère les fonctionnalités liées aux Customers.
Pourrait inclure des fonctionnalités telles que les informations sur les clients Username and emails ,passwords.

Service d'Inventaire(Inventory-service) :

Gère les fonctionnalités liées à l'inventaire.
S'occupe du suivi des stocks, de la gestion des stocks, etc.

service de configuration:

s'occupe de la configuration et le mapping des variables gloables ent non gloables de configuration presentents  dans l'application

service Gateaway:

service de routage et le filtrage des demandes API

Service de Commande (Orders-service):

Gère les fonctionnalités liées aux commandes.
Responsable du traitement des commandes, de l'historique des commandes, etc.
Service de Facturation :

Intègration de Consul pour la découverte des services
Utilise Consul Config pour la configuration dynamique.
Gère les fonctionnalités de facturation et de facturation.


Composants Spring Cloud :

Découverte Consul :

Utilisé pour l'enregistrement et la découverte des services.
Permet aux microservices de se localiser et de communiquer dynamiquement.

Spring Cloud Config :

Gestion centralisée de la configuration pour les microservices.
Permet des mises à jour de configuration dynamiques sans redémarrer les services.

Spring Cloud Gateway :

Sert de passerelle API pour le routage et le filtrage des demandes.
Gère l'équilibrage de charge, l'authentification et d'autres préoccupations transversales.

Composants Additionnels :

Frontend Angular :

Fournit une interface utilisateur pour interagir avec les microservices.
Communique avec les services backend via des appels API.


Flux de Travail :
Les microservices s'enregistrent auprès de Consul pour la découverte de services.
Spring Cloud Config fournit une gestion centralisée de la configuration.
Spring Cloud Gateway agit comme un point d'entrée pour les demandes externes.
Le service de facturation utilise à la fois Consul Config et Vault pour la gestion de la configuration et des secrets.
Le frontend Angular communique avec les microservices backend via des appels API.
