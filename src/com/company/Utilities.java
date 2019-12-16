package com.company;

public class Utilities {

    /*
    #1] help
- cette commande doit afficher toutes les commandes possibles de votre application ainsi que le formalisme (décrit ci-dessous pour chaque commande)

[#2] exit
- cette commande permet de sortir de la boucle infinie de votre application, et donc de terminer son exécution. C'est grâce à cette commmande exit que vous pouvez quitter votre application normalement.

[#3] adduser <firstname> <lastname> <bank> <loan> <rate>
- La commande doit créer en mémoire un nouvel utilisateur. Un utilisateur devra être considéré comme déjà existant si le nom ET le prénom d'un utilisateur correspondent parfaitement au nom ET prénom dans la commande. Dans ce cas un message d'erreur affiche que l'utilisateur existe déjà.
- La commande doit vérifier que le taux est entre 0 et 100 et l'emprunt supérieur à 100000 (en nombre entier).

[#4] edituser <firstname> <lastname>
- la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
- la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien un taux qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
- si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
- si l'utilisateur est utilisé dans une transaction , alors la modification de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché

[#5] removeuser <firstname> <lastname>
- cette commande recherche un utilisateur avec le même nom ET prénom rentrés et va le supprimer de la liste.
- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
- si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
- si l'utilisateur est utilisé dans une transaction , alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché

[#6] listusers
- affiche tous les utilisateurs



[#7] addhouse <title> <ref> <category> <price>
- ajoute une maison dans la liste
- cherche d'abord un objet qui porte la même référence (ou le même intitulé ET la même catégorie ET le même prix).
- Si un objet existe déjà dans la mémoire, alors on affiche un message d'erreur (avec les infos de la maison existant par exemple)

[#8] edithouse <ref>
- cette commande va rechercher une maison en transaction dans les données et si elle le trouve va demander de remplacer toutes les infos qui y sont liées (comme dans la commande edituser).
- si la référence de la maison n'est pas trouvée, alors on affiche un message d'erreur.
- pour chaque champ de valeur, on peut laisser une chaine vide pour indiquer qu'on ne change pas la valeur (comme expliqué dans la commande edituser).

[#9] removehouse <ref>
- cette commande recherche une référence de maison et la supprime de la liste en mémoire.
- si la référence n'est pas trouvée, un message d'erreur s'affiche.
- si la référence existe, il faut vérifier que cette maison n'est pas utilisée dans une transaction. Si c'est pas le cas, un message d'erreur affichera que cette maison ne peut pas être supprimée car actuellement utilisée.

[#10] listhouses
- affiche toutes les maisons

[#11] createtransaction <firstname> <lastname> <ref>
- cette commande prend en paramètre le prénom et le nom d'un utilisateur ainsi que la référence de l'objet à emprunter
- si l'utilisateur n'existe pas on affiche une erreur.
- si la référence de l'objet n'existe pas on affiche une erreur.
- si l'objet a déjà été emprunté par qqun on affiche une erreur.
- dans tous les autres cas, on stocke l'transaction de cet objet par cet utilisateur avec la date du jour (mettre une valeur aléatoire pour le jour, le mois et l'année histoire d'avoir des dates différentes par emprunt)
- afficher le récapitulatif de l'transaction (utilisateur, ref objet, date d'transaction)

[#12] closetransaction <ref>
- cette commande prend en paramètre la référence d'un objet
- si cette référence n'existe pas, alors on affiche une erreur
- si cet objet n'a pas été acquis aux transactions, on affiche une erreur
- si ce livre est actuellement acquis aux transactions, alors on met a jour l'objet transaction associé pour mettre la date de paiment (mettre une date aléatoire mais qui soit supérieure à la date d'emprunt)
- afficher le récapitulatif de l'transaction terminée(utilisateur, ref objet, date d'transactions, date de paiement)

[#13] listtransaction
- cette commande affiche la liste des transactions
- vous êtes libres du formalisme d'affichage mais toutes les informations doivent apparaitre
- nom et prénom de l'utilisateur, intitulé de la maison + référence (il faut donc aller chercher l'intitulé à partir de la référence stockée dans la transaction), date de signature de compromis, date de signature définitive ou vide si pas encore effectuée.

[#14] save
- cette commande va sauvegarder toutes vos données liés aux utilisateurs, maisons et transactions sur le disque dur dans des fichiers.
- vous êtes libres de sauvegarder un seul fichier qui contient toutes les données ou bien un fichier par donnée quelle qu'elle soit.
- le format des données à l'intérieur des fichiers peut être du texte pur ou tout autre format qui vous semble plus pratique à manipuler.
- vous aurez un bonus sur l'évaluation si vous sauvegardez dans vos fichiers les objets RAM sérialisés (cf. sérialisation et désérialisation des objets Java)

[#15] restore
- cette commande va détecter la présence des fichiers sauvegardés précédemment (si ils existent) et va les ouvrir en lecture et récupérer les informations contenues dedans pour créer de nouveaux objets en mémoire (et donc restaurer l'état mémoire comme au moment de la sauvegarde).
     */
}
