USE EssaieTrig;

/* current_timestamp donne le'heure et la date
// current_time donne juste l'heure */

/*test    INSERT INTO tp.etudiant VALUES('85','Ateba','Charle','electrique',4);*/



// creation du trigger correspondant             | update | delete*/
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//INSERT INTO etudiant VALUES('27','Tibati','tantapion','MSP',1);
//INSERT INTO etudiant VALUES('86','Ateba','Charle','electrique',4);


/*test
DELIMITER &
CREATE TRIGGER noinst BEFORE
insert ON etudiant FOR EACH ROW
BEGIN
              insert into erreur(er) values(concat('Erreur:  Insertion non permise car tu n','est pas administrateur' ));
END &
*/

/* le trigger  Suivant interdit l'acess a la bd entre 20 et 06h'*/
/* Nous avons definie une table a erreur car la fonction RAISE_APPLICATION _ERROR nest valide que dans les BD Oracle*/

/*
DELIMITER &
CREATE TRIGGER noinst BEFORE
insert ON etudiant FOR EACH ROW
BEGIN
    IF CURRENT_TIME NOT BETWEEN 60000 AND 120000 THEN
              insert into erreur(er) values(concat('Erreur:  Insertion non permise car tu n','est pas administrateur' ));
    END IF;
END &
DELIMITER ; */


/*drop trigger histoIns;drop trigger histoUp;drop trigger histodel;*/




