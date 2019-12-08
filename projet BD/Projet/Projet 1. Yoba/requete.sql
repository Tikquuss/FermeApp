-- Requetes SQL
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------
------------------------ By Yobiyork, The Team Manager ---------------------------
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------

-- Utilisation de la Base de Donnee Zoo
USE zoo;

-- 1. Nom des animaux du Zoo
SELECT nomA FROM LesAnimaux;

-- 2. Fonctionnalites disponibles dans le zoo.
SELECT fonction FROM LesCages;

-- 3. les noms des leopards
SELECT nomA FROM LesAnimaux WHERE LesAnimaux.type = "leopard";

-- 4. Les maladies contractees au moins une fois par des animaux du zoo.
SELECT DISTINCT(nomM) FROM LesMaladies;

-- 5. Les noms et Numeros de cage des animaux males qui sont originaires du kenya et dont la date est anterieure a 1992
SELECT nomA, noCage FROM LesAnimaux, LesCages 
	WHERE 
LesAnimaux.anNais < 1992 AND LesAnimaux.sexe="male" AND LesAnimaux.pays ="Kenya" AND LesAnimaux.noCage = LesCages.noCage;

-- 6. requête produisant l'affichage suivant: Peyrin vit a Noumea Burrut vit a Sartène Sicard vit a Calvi Voiron vit a Pointe a Pitre Scholl vit a ushuaia Adiba vit a Papeete
SELECT description AS CONCAT( SELECT descriptionIntermediaire AS CONCAT(nomE, "vit a", adresse) FROM LesEmployes) FROM LesEmployes;

-- 7. Le nom et l'age des animaux en 2012
SELECT nomA, 2012- anNais FROM LesAnimaux;

--8. Le nom des gardiens qui habitent Ushuaïas
SELECT LesGardiens.nomE FROM LesEmployes, LesGardiens 
WHERE LesEmployes.adresse = "Ushuaïa" AND LesGardiens.nomE = LesEmployes.nomE;

-- 9. La fonctionnalite et le nom du gardien des cages gardees par un employe habitant Calvi.
SELECT LesCages.fonction, LesGardiens.nomE FROM LesCages, LesGardiens, LesEmployes
WHERE LesGardiens.nomE = LesEmployes.nomE AND LesEmployes.adresse = "Calvi";
 
-- 10. Le nom des animaux ainsi que les employes qui en sont les gardiens soit les responsables.
 /*SELECT nomAnimaux as LesAnimaux.nomA, nomEmployes as LesEmployes.nomE FROM LesAnimaux, LesEmployes, LesGardiens
WHERE 
*/
SELECT "Madame Je n'ais pas Compris la Question 10";

-- 11. Le nom des gardiens gardant tous les animaux
SELECT DISTINCT(nomE) FROM LesGardiens;

-- 12. Les noms et types des animaux qui n'ont jamais ete malades.
SELECT lesAnimaux.nomA, LesAnimaux.type FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.nomA NOT IN (SELECT DISTINCT(nomA) FROM LesMaladies);

-- 13. Les noms des animaux originaire du Kenya ayant deja contractes une grippe.
SELECT nomA FROM LesAnimaux, LesMaladies
WHERE
LesAnimaux.pays="Kenya" AND 
	LesAnimaux.nomA IN (SELECT DISTINCT(nomA) FROM LesMaladies WHERE LesMaladies.nomM = "grippe"); 

-- 14. Les numeros et fonctionnalites des cages qui sont innocupees.
SELECT DISTINCT LesCages.noCage, LesCages.fonction 
FROM LesCages ,  LesAnimaux
WHERE 
LesCages.noCage NOT IN (SELECT DISTINCT(LesAnimaux.noCage) FROM LesAnimaux );
	
-- 15. Donner pour chaque animal male l'ensemble des maladies qu'il a contractees (ensemble des couples nom d'animal, nom de maladie).
SELECT DISTINCT LesMaladies.nomA, LesMaladies.nomM 
FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.sexe = "male" AND LesAnimaux.nomA IN (SELECT nomA FROM LesMaladies);

-- 16. Les numeros et fonctionnalites des cages qui sont partagees par des animaux de types differents. En d'autres termes, ce sont les cages qui contiennent au moins deux animaux de types differents.

SELECT LesCages.noCage, LesCages.fonction 
FROM LesCages, LesAnimaux
WHERE
	(SELECT COUNT( SELECT type FROM LesAnimaux WHERE noCage IN ( SELECT DISTINCT(noCage) FROM LesAnimaux )) > 1) 
	AND 
	LesCages.noCage IN (SELECT DISTINCT(noCage) FROM LesAnimaux);  

-- 17. Les noms des responsables et les noms des gardiens de Charly.
SELECT DISTINCT LesResponsables.nomE, LesGardiens.nomE
FROM LesResponsables, LesGardiens, LesCages, LesAnimaux
  WHERE LesGardiens.noCage IN (SELECT noCage FROM LesAnimaux WHERE nomA ="Charly") 
	AND
	LesResponsables.noAllee IN (SELECT noAllee FROM LesCages  
		WHERE noCage IN (SELECT noCage FROM LesAnimaux 
			WHERE nomA="Charly"));
			
-- 18. Le nom et le pays d'origine de l'animal doyen du zoo (il peut y en avoir plusieurs).
SELECT nomA, pays 
FROM LesAnimaux
WHERE type="lion";

-- 19. Le nom, le type et l'annee de naissance des animaux qui ont contracte toutes les maladies (connues) du zoo.
SELECT LesAnimaux.nomA, LesAnimaux.type, LesAnimaux.anNais
FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.nomA IN (SELECT LesMaladies.nomA WHERE LesMaladies.nomM ALL(SELECT DISTINCT(nomM) FROM LesMaladies) );

-- 20. Le nom, le type et l'annee de naissance des animaux qui partagent la cage de Charly.
SELECT DISTINCT nomA, type, pays 
FROM LesAnimaux, LesCages
WHERE
LesAnimaux.noCage IN (SELECT noCage FROM LesAnimaux WHERE LesAnimaux.nomA ="Charly");

-- 21. Le nom et l'adresse des employes qui sont gardiens d'animaux de tous types, on fait references aux types des animaux du zoo. 
/* Cette requête n'est pas termine */
SELECT LesEmployes.nomE, LesEmployes.adresse 
FROM LesEmployes, LesGardiens, LesResponsables
WHERE 
LesEmployes.nomE IN (SELECT nomE FROM LesGardiens WHERE LesGardiens.noCage ALL (SELECT DISTINCT(noCage) FROM LesAnimaux WHERE LesAnimaux.types IN (SELECT DISTINCT(type) FROM LesAnimaux))))
OR
LesEmployes.nomE IN (SELECT nomE FROM LesResponsables WHERE LesResponsables.noAllee IN 

/*LesAnimaux(nomA, sexe, type, pays, anNais, #noCage)
LnesCages(noCage, fonction, #noAllee)
LesResponsables(noAllee, #nomE)
LesMaladies(#nomA, nomM)
LesEmployes(nomE, adresse)
LesGardiens(noCage, #nomE) */