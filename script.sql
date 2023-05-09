create table categorie(
    idcategorie serial PRIMARY key,
    label varchar(25)
);

create table image(
    idimage serial PRIMARY key,
    base text,
    legende varchar(255),
    source varchar(255)
);

create table information(
    idinf serial PRIMARY key ,
    titre varchar(255),
    sous_titre varchar(255),
    date timestamp default now(),
    description text,
    idimage integer,
    idcategorie integer
);

create table usera(
    iduser serial PRIMARY key ,
    nom varchar(25),
    mdp varchar(25)
);

insert into categorie(label) values('ia etroite'), ('ia generale'), ('superintelligence');
insert into usera(nom,mdp) values('momo', '1437');
ALTER TABLE information ADD FOREIGN KEY (idimage) REFERENCES image(idimage);
ALTER TABLE information ADD FOREIGN KEY (idcategorie) REFERENCES categorie(idcategorie);

