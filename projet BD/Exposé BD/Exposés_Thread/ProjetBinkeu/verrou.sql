USE EssaieTrig;

/* les triggers  Suivant  vont mettre a jour la table historique a chaque nouvelle insertion,suppression et mise a jour d'un etudiant */
/* la remarque a faire sur ces trgger est qu'il font la mise a jour de historique uniquement si l'on est a la boe heure le cas echeant un msg d'erreur est provoque'*/

DELIMITER &
CREATE TRIGGER histoIns BEFORE
insert ON etudiant FOR EACH ROW
BEGIN
     insert into historique values(user(), current_timestamp,'Insertion',concat(new.nom,' ',new.prenom), new.dept,new.niveau);
     IF CURRENT_TIME NOT BETWEEN 60000 AND 110000 THEN
              insert into erreur(er) values(concat('Erreur:  Insertion non permise , appeler ','l','administrateur' ));
    END IF;
END &
DELIMITER ;


DELIMITER &
CREATE TRIGGER histoDel BEFORE
delete ON etudiant FOR EACH ROW
BEGIN
   insert into historique values(user(), current_timestamp,'Supression',concat(old.nom,' ',old.prenom), old.dept,old.niveau);
   IF CURRENT_TIME NOT BETWEEN 60000 AND 110000 THEN
              insert into erreur(er) values(concat('Erreur:  Suppresion non permise, appeler ','l','administrateur' ));
    END IF;
END &
DELIMITER ;


DELIMITER &
CREATE TRIGGER hisoUp BEFORE
update ON etudiant FOR EACH ROW
BEGIN
   insert into historique values(user(), current_timestamp,'Mise ajour',concat(new.nom,' ',new.prenom), new.dept,new.niveau);
   IF CURRENT_TIME NOT BETWEEN 60000 AND 110000 THEN
              insert into erreur(er) values(concat('Erreur:  Mise a jour non permise, appeler','l','administrateur' ));
    END IF;
END &
DELIMITER ;


