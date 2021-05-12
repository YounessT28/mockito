# Gestion Etablissement


## Pré-requis
Version java : 15.0.2

## Utilisation
Clonez le projet
> git clone https://github.com/YounessT28/mockito.git

Depuis Intellij, lancez la commande
> mvn clean package tomcat7:run

A noter que la base de données est stocké sur un serveur distant gratuit et met un peu de temps à répondre donc soyez patient :blush:

## Fonctionnalités

### Nous retrouvons toutes les fonctionnalités que nous avions sur l'application

- Ajouter un étudiant
    - Vous avez la possibilité de créer un étudiant en remplissant les champs correspondant
- Gérer les étudiants
    - Vous pouvez modifier sélectionner un étudiant en particulier pour modifier ses informations, après avoir sélectionné l'étudiant les champs se mettent automatiquement à jours.
    - Vous pouvez également supprimer l'élève [Attention, si l'élève est associé à un cours, il ne pourras être supprimé]
- Gérer les cours
    - Cette page contient deux sections, la première permet de créer un cours en indiquant le nom et le nombre d'heures, la seconde permet d'associer un étudiant à un cours.
- Gérer les notes
    - Vous pouvez ajouter une note à un élève dans une des matière qui existe.
- Statistiques
    - Vous pouvez visualiser au format graph les moyennes des élèves.
- Liste des étudiants
    - Vous pouvez visualiser les informations des étudiants sous forme de tableau.
    - Vous pouvez également avoir le choix de modifier ou supprimer un élève en particulier [A condition que l'élève ne soit pas associé à un cours pour la suppression].

## Améliorations à faire
- Message d'informations 
    - Par manque de temps, les messages d'informations sont basique. On pourrais l'améliorer en mettant le message en bas a droite tel une notification.
- Dissocier un étudiant à un cours
    - Pouvoir dissocier un étudiant à un cours permettrait par la suite de supprimer ce dernier si l'on a envie. Où alors, automatiser la dissociation lors de la suppression de l'étudiant.
