-- Requetes SQL
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------
------------------------ By Yobiyork, The Team Manager ---------------------------
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------

-- Utilisation de la Base de Donnée Zoo
USE zoo;

-- 1. Nom des animaux du Zoo
SELECT nomA FROM LesAnimaux;

-- 2. Fonctionnalités disponibles dans le zoo.
SELECT fonction FROM LesCages;

-- 3. les noms des léopards
SELECT nomA FROM LesAnimaux WHERE LesAnimaux.type = "léopard";

-- 4. Les maladies contractées au moins une fois par des animaux du zoo.
SELECT DISTINCT(nomM) FROM LesMaladies;

-- 5. Les noms et Numéros de cage des animaux mâles qui sont originaires du kenya et dont la date est antérieure à 1992
SELECT nomA, noCage FROM LesAnimaux, LesCages 
	WHERE 
LesAnimaux.anNais < 1992 AND LesAnimaux.sexe="mâle" AND LesAnimaux.pays ="Kenya" AND LesAnimaux.noCage = LesCages.noCage;

-- 6. requête produisant l'affichage suivant: Peyrin vit à Nouméa Burrut vit à Sartène Sicard vit à Calvi Voiron vit à Pointe à Pitre Scholl vit à ushuaia Adiba vit à Papeete
SELECT description AS CONCAT( SELECT descriptionIntermediaire AS CONCAT(nomE, "vit à", adresse) FROM LesEmployés) FROM LesEmployés;

-- 7. Le nom et l'âge des animaux en 2012
SELECT nomA, 2012- anNais FROM LesAnimaux;

--8. Le nom des gardiens qui habitent Ushuaïas
SELECT LesGardiens.nomE FROM LesEmployés, LesGardiens 
WHERE LesEmployés.adresse = "Ushuaïa" AND LesGardiens.nomE = LesEmployés.nomE;

-- 9. La fonctionnalité et le nom du gardien des cages gardées par un employé habitant Calvi.
SELECT LesCages.fonction, LesGardiens.nomE FROM LesCages, LesGardiens, LesEmployés
WHERE LesGardiens.nomE = LesEmployés.nomE AND LesEmployés.adresse = "Calvi";
 
-- 10. Le nom des animaux ainsi que les employés qui en sont les gardiens soit les responsables.
 /*SELECT nomAnimaux as LesAnimaux.nomA, nomEmployés as LesEmployés.nomE FROM LesAnimaux, LesEmployés, LesGardiens
WHERE 
*/
SELECT "Madame Je n'ais pas Compris la Question 10";

-- 11. Le nom des gardiens gardant tous les animaux
SELECT DISTINCT(nomE) FROM LesGardiens;

-- 12. Les noms et types des animaux qui n'ont jamais été malades.
SELECT lesAnimaux.nomA, LesAnimaux.type FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.nomA NOT IN (SELECT DISTINCT(nomA) FROM LesMaladies);

-- 13. Les noms des animaux originaire du Kenya ayant déjà contractés une grippe.
SELECT nomA FROM LesAnimaux, LesMaladies
WHERE
LesAnimaux.pays="Kenya" AND 
	LesAnimaux.nomA IN (SELECT DISTINCT(nomA) FROM LesMaladies WHERE LesMaladies.nomM = "grippe"); 

-- 14. Les numéros et fonctionnalités des cages qui sont innocupées.
SELECT LesCages.noCage, LesCages.fonction 
FROM LesCages ,  LesAnimaux
WHERE 
LesCages.noCage NOT IN (SELECT DISTINCT(LesAnimaux.noCage) FROM LesAnimaux );
	
-- 15. Donner pour chaque animal mâle l'ensemble des maladies qu'il a contractées (ensemble des couples nom d'animal, nom de maladie).
SELECT nomAnimal AS LesMaladies.nomA, nomMaladie AS LesMaladies.nomM 
FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.sexe = "mâle" AND LesAnimaux.nomA IN (SELECT nomA FROM LesMaladies);

-- 16. Les numéros et fonctionnalités des cages qui sont partagées par des animaux de types différents. En d'autres termes, ce sont les cages qui contiennent au moins deux animaux de types différents.

SELECT LesCages.noCage, LesCages.fonction 
FROM LesCages, LesAnimaux
WHERE
	COUNT( SELECT type FROM LesAnimaux WHERE noCage IN ( SELECT DISTINCT(noCage) FROM LesAnimaux )) > 1 
	AND 
	LesCages.noCage IN (SELECT DISTINCT(noCage) FROM LesAnimaux);  

-- 17. Les noms des responsables et les noms des gardiens de Charly.
SELECT  nomResponsable AS LesResponsables.nomE, nomGardiens AS LesGardiens.nomE
FROM LesResponsables, LesGardiens, LesCages, LesAnimaux
  WHERE LesGardiens.noCage IN (SELECT noCage FROM LesAnimaux WHERE nomA ="Charly") 
	AND
	LesResponsables.noAllée IN (SELECT noAllée FROM LesCages  
		WHERE noCage IN (SELECT noCage FROM LesAnimaux 
			WHERE nomA="Charly"));
			
-- 18. Le nom et le pays d'origine de l'animal doyen du zoo (il peut y en avoir plusieurs).
SELECT nomA, pays 
FROM LesAnimaux
WHERE type="lion";

-- 19. Le nom, le type et l'année de naissance des animaux qui ont contracté toutes les maladies (connues) du zoo.
SELECT nomA, type, anNais
FROM LesAnimaux, LesMaladies
WHERE 
LesAnimaux.nomA IN (SELECT LesMaladies.nomA WHERE LesMaladies.nomM ALL(SELECT DISTINCT(nomM) FROM LesMaladies) );

-- 20. Le nom, le type et l'année de naissance des animaux qui partagent la cage de Charly.
SELECT nomA, type, pays 
FROM LesAnimaux, LesCages
WHERE
LesAnimaux.noCage IN (SELECT noCage FROM LesAnimaux WHERE LesAnimaux.nomA ="Charly");

-- 21. Le nom et l'adresse des employés qui sont gardiens d'animaux de tous types, on fait références aux types des animaux du zoo. 
/* Cette requête n'est pas terminé */
SELECT LesEmployés.nomE, LesEmployés.adresse 
FROM LesEmployés, LesGardiens, LesResponsables
WHERE 
LesEmployés.nomE IN (SELECT nomE FROM LesGardiens WHERE LesGardiens.noCage ALL (SELECT DISTINCT(noCage) FROM LesAnimaux WHERE LesAnimaux.types IN (SELECT DISTINCT(type) FROM LesAnimaux))))
OR
LesEmployés.nomE IN (SELECT nomE FROM LesResponsables WHERE LesResponsables.noAllée IN 

/*LesAnimaux(nomA, sexe, type, pays, anNais, #noCage)
LnesCages(noCage, fonction, #noAllée)
LesResponsables(noAllée, #nomE)
LesMaladies(#nomA, nomM)
LesEmployés(nomE, adresse)
LesGardiens(noCage, #nomE) */