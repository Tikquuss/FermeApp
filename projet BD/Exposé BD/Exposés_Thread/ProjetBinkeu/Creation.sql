CREATE DATABASE IF NOT exists EssaieTrig;
USE EssaieTrig;

CREATE TABLE IF NOT EXISTS etudiant (matricule VARCHAR(10)  NOT NULL, nom VARCHAR(30), prenom VARCHAR(10),dept VARCHAR(10), niveau INT(10), CONSTRAINT pk_mat PRIMARY KEY (matricule));
INSERT INTO etudiant VALUES
('1A','Akamba','Serge','informatique',3),
('9','Bikola','Fabien','mecanique',3),
('2','Bineli','Herve','informatique',3),
('5','Mawell','toto','MSP',2),
('25P','Akoulouze','bulu','MSP',5);

/*Creation de la table historique*/
CREATE TABLE IF NOT EXISTS historique(utilisateur VARCHAR(20) , dateModif TIMESTAMP ,typeOperation VARCHAR(20),etudiant VARCHAR(30),dept VARCHAR(10), niveau numeric(2) );

/*Ici nous avons notre table des erreurs*/

CREATE TABLE IF NOT EXISTS erreur(id int AUTO_INCREMENT PRIMARY KEY, er VARCHAR(300) UNIQUE);
INSERT INTO erreur(er) VALUES
(CONCAT('Erreur:  Insertion non permise car tu n','est pas administrateur')),
(CONCAT('Erreur:  Mise a jour  non permise car tu n','est pas administrateur')),
(CONCAT('Erreur:  Suppression non permise car tu n','est pas administrateur'));
