create table Categorie(
    id_categorie Serial PRIMARY KEY,
    nom_categorie varchar(50)
);
INSERT INTO Categorie(nom_categorie) VALUES('Dessert');
INSERT INTO Categorie(nom_categorie) VALUES('Resistance');
INSERT INTO Categorie(nom_categorie) VALUES('Entree');

create table Produit(
    id_produit Serial PRIMARY KEY,
    nom_produit varchar(50),
    prix_produit double precision,
    images varchar(50),
    id_categorie int,
    FOREIGN KEY (id_categorie) REFERENCES Categorie(id_categorie)
);

create table Produit(
    id_produit Serial PRIMARY KEY,
    nom_produit varchar(50),
    prix_produit double precision,
    images varchar(50),
    id_categorie int,
    FOREIGN KEY (id_categorie) REFERENCES Categorie(id_categorie)
);

create table Ingredient(
    id_ingredient Serial PRIMARY KEY,
    nom varchar(50)
);

INSERT INTO Ingredient(nom) VALUES ('Tsaramaso');
INSERT INTO Ingredient(nom) VALUES ('Hena Kisoa');
INSERT INTO Ingredient(nom) VALUES ('Votabia');
INSERT INTO Ingredient(nom) VALUES ('Menaka');
INSERT INTO Ingredient(nom) VALUES ('Tongolo');
INSERT INTO Ingredient(nom) VALUES ('Sira');


INSERT INTO Ingredient(nom) VALUES ('Pomme de terre');
INSERT INTO Ingredient(nom) VALUES ('Viande hachée');
INSERT INTO Ingredient(nom) VALUES ('Haricot vert');
INSERT INTO Ingredient(nom) VALUES ('Carotte');
INSERT INTO Ingredient(nom) VALUES ('Saussice');


create table AchatIngredient(
    id_achat Serial PRIMARY KEY,
    prix_unitaire double precision,
    dateAchat Date,
    id_ingredient int,
    quantite int,
    FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',1,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(16000,'2022-03-22',2,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(4500,'2022-03-22',3,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',5,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(16000,'2022-03-22',6,1000);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(2000,'2022-03-22',7,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',8,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',9,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',10,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',11,1000);


create table Recette(
    id_recette Serial PRIMARY KEY,
    dose_ingredient int,
    id_produit int,
    id_ingredient int,
    FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient),
    FOREIGN KEY (id_produit) REFERENCES Produit(id_produit)
);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,3);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,1,2);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(100,1,1);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(1,1,6);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(20,1,5);



INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,2,7);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,2,8);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,2,4);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,2,6);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,3,7);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,3,9);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,3,10);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,3,11);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,3,3);


INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Salade de fruit',10000,'dessert1',1);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Glace',9000,'dessert2',1);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Flan',10000,'dessert3',1);

INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Salade de patte',15000,'Entree1',2);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Masedoine',10000,'Entree2',2);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Salede de charcuterrie',10000,'Entree3',2);

INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Tsaramaso sy henakisoa',15000,'Resistance1',3);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Catelesse',8000,'Resistance2',3);
INSERT INTO Produit(nom_produit,prix_produit,images,id_categorie) VALUES('Legume et saussice',9000,'Resistance3',3);

create table Marge(
    id_marge Serial PRIMARY KEY,
    montant_min double precision,
    montant_max double precision,
    marge int
);

INSERT INTO Marge(montant_min,montant_max,marge)VALUES(0,1000,100);
INSERT INTO Marge(montant_min,montant_max,marge)VALUES(1100,30000,50);


create table Ingredient(
    id_ingredient Serial PRIMARY KEY,
    nom varchar(50)
);

INSERT INTO Ingredient(nom) VALUES ('Tsaramaso');
INSERT INTO Ingredient(nom) VALUES ('Hena Kisoa');
INSERT INTO Ingredient(nom) VALUES ('Votabia');
INSERT INTO Ingredient(nom) VALUES ('Menaka');
INSERT INTO Ingredient(nom) VALUES ('Tongolo');
INSERT INTO Ingredient(nom) VALUES ('Sira');

INSERT INTO Ingredient(nom) VALUES ('Pomme de terre');
INSERT INTO Ingredient(nom) VALUES ('Viande hachée');
INSERT INTO Ingredient(nom) VALUES ('Haricot vert');
INSERT INTO Ingredient(nom) VALUES ('Carotte');
INSERT INTO Ingredient(nom) VALUES ('Saussice');

INSERT INTO Ingredient(nom) VALUES ('Banane');
INSERT INTO Ingredient(nom) VALUES ('Ananas');
INSERT INTO Ingredient(nom) VALUES ('fraise');
INSERT INTO Ingredient(nom) VALUES ('Sucre');
INSERT INTO Ingredient(nom) VALUES ('Lait concentrer');
INSERT INTO Ingredient(nom) VALUES ('creme fresh');
INSERT INTO Ingredient(nom) VALUES ('lait');
INSERT INTO Ingredient(nom) VALUES ('nounous');

INSERT INTO Ingredient(nom) VALUES('Jambon');
INSERT INTO Ingredient(nom) VALUES('Mortadelle');
INSERT INTO Ingredient(nom) VALUES('Mayonnaise');
INSERT INTO Ingredient(nom) VALUES('Olive noir');
INSERT INTO Ingredient(nom) VALUES('Salami');
INSERT INTO Ingredient(nom) VALUES('Saucisson');
INSERT INTO Ingredient(nom) VALUES('Salade');
INSERT INTO Ingredient(nom) VALUES('Macaroni');
INSERT INTO Ingredient(nom) VALUES('Poivron');
INSERT INTO Ingredient(nom) VALUES('Persil');
INSERT INTO Ingredient(nom) VALUES('Poivre');
INSERT INTO Ingredient(nom) VALUES('Vinaigre');
INSERT INTO Ingredient(nom) VALUES('MaÏs doux');
INSERT INTO Ingredient(nom) VALUES('Sardine');


create table AchatIngredient(
    id_achat Serial PRIMARY KEY,
    prix_unitaire double precision,
    dateAchat Date,
    id_ingredient int,
    quantite int,
    FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',1,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(16000,'2022-03-22',2,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(4500,'2022-03-22',3,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',5,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(16000,'2022-03-22',6,1000);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(2000,'2022-03-22',7,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',8,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',9,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',10,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',11,1000);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(1900,'2022-03-22',12,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(1000,'2022-03-22',13,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(1500,'2022-03-22',14,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',15,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',16,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',17,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(3000,'2022-03-22',18,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',19,1000);

INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',20,500);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(10000,'2022-03-22',21,500);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(20000,'2022-03-22',22,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(15000,'2022-03-22',23,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(6000,'2022-03-22',24,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(2000,'2022-03-22',25,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(5000,'2022-03-22',26,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(2000,'2022-03-22',27,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(8000,'2022-03-22',28,1000);
INSERT INTO AchatIngredient(prix_unitaire,dateAchat,id_ingredient,quantite)VALUES(10000,'2022-03-22',29,1000);

create table Recette(
    id_recette Serial PRIMARY KEY,
    dose_ingredient int,
    id_produit int,
    id_ingredient int,
    FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient),
    FOREIGN KEY (id_produit) REFERENCES Produit(id_produit)
);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,3);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,1,2);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(100,1,1);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(1,1,6);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(20,1,5);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,2,7);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,2,8);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,2,4);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,2,6);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,3,7);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,3,9);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,3,10);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,3,11);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,3,11);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,19);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,18);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,17);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,1,15);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(250,2,17);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(250,2,12);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(20,2,15);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(250,3,13);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,3,14);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(20,3,15);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,4,20);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,4,21);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,4,22);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,4,23);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,4,24);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(50,5,20);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,5,24);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,5,25);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,5,28);

INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,6,30);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,6,31);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(30,6,32);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(500,6,33);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,6,24);
INSERT INTO Recette(dose_ingredient,id_produit,id_ingredient)VALUES(10,6,25);

create view prixTotalCommande as (select id_commande,id_serveur,sum(((p.prix_produit*quantite)*2)/100) prix from detailsCommande dc join produit p on dc.id_produit = p.id_produit group by id_serveur,id_commande);

create view pourboireServeur as (select (prix*2)/100 pourboire,id_serveur,daty,id_table from prixTotalCommande pc join commande c on pc.id_commande = c.id_commande);

create table NTable(
    id_table Serial PRIMARY KEY
);

create table Serveur(
    id_serveur Serial PRIMARY KEY,
    nom varchar(50)
)
INSERT INTO Serveur(nom) VALUES ('Sandra');
INSERT INTO Serveur(nom) VALUES ('Felana');

create table Commande(
    id_commande Serial PRIMARY KEY,
    daty Date,
    id_table int,
    FOREIGN KEY (id_table) REFERENCES NTable(id_table)
);

INSERT INTO Commande(id_serveur,daty) VALUES ('2022-03-28',1);

create table DetailsCommande(
    id_detailscommande Serial PRIMARY KEY,
    id_commande int,
    id_serveur int
    id_produit int,
    quantite int,
    etat varchar(20),
    FOREIGN KEY (id_commande) REFERENCES Commande(id_commande),
    FOREIGN KEY (id_serveur) REFERENCES Serveur(id_serveur),
    FOREIGN KEY (id_produit) REFERENCES Produit(id_produit)
);
INSERT INTO Commande(id_commande,id_serveur,id_produit,quantite) VALUES (1,1,1,2);
INSERT INTO Commande(id_commande,id_serveur,id_produit,quantite) VALUES (1,2,2,3);

create table Pourboire(
    id_pourboire Serial PRIMARY KEY,
    id_commande int,
    daty Date,
    pourboire double precision,
    FOREIGN KEY (id_commande) REFERENCES Commande(id_commande)
);

INSERT INTO serveur (nom) VALUES ('Anita') RETURNING id_serveur;

create view ProduitRecetteII as select Produit.id_produit, nom_produit , Ingredient.nom as nom_ingredient , dose_ingredient as quantite  from Produit join Recette on Produit.id_produit = Recette.id_produit join Ingredient on Recette.id_ingredient = Ingredient.id_ingredient;

CREATE OR REPLACE VIEW produittable AS 
 SELECT ntable.id_table,
    produit.id_produit,
    produit.nom_produit,
    detailscommande.quantite,
    produit.prix_produit,
    detailscommande.id_detailscommande
   FROM ntable
     JOIN commande ON commande.id_table = ntable.id_table
     JOIN detailscommande ON detailscommande.id_commande = commande.id_commande
     JOIN produit ON produit.id_produit = detailscommande.id_produit
  WHERE detailscommande.status = 3;

create view IngredientConsommer as 
    select Ingredient.nom as nom_ingredient , sum( dose_ingredient*dc.quantite )as quantite , sum( AchatIngredient.prix_unitaire) as prix, daty 
        from Produit join Recette on Produit.id_produit = Recette.id_produit 
            join Ingredient on Recette.id_ingredient = Ingredient.id_ingredient 
            join AchatIngredient on Ingredient.id_ingredient = AchatIngredient.id_ingredient 
            join detailsCommande dc on dc.id_produit = Produit.id_produit 
            join commande on commande.id_commande = dc.id_commande 
                where dc.status = 4 group by nom_ingredient,daty ;

create table Stock_Ingredient(
    id_stock Serial PRIMARY KEY,
    id_ingredient int,
    daty date,
    entree int,
    sortie int,
    FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id_ingredient)
);

create table ModePaiement(
    id_modePaiment serial PRIMARY KEY,
    intitule varchar(50)
);

INSERT INTO ModePaiement(intitule) VALUES ('Cheque');
INSERT INTO ModePaiement(intitule) VALUES ('Espece');

create table Paiement(
    id_paiment serial PRIMARY KEY,
    id_modePaiment int,
    id_detailsCommande int,
    daty date,
    montant double precision,
    FOREIGN KEY (id_modePaiment) REFERENCES ModePaiement(id_modePaiment),
    FOREIGN KEY (id_detailsCommande) REFERENCES DetailsCommande(id_detailscommande)
);

create view montantPai as select id_modepaiment,daty,sum(montant) as montant from Paiement group by id_modepaiment,daty


create table login (
    id_login serial PRIMARY KEY,
    nom_utilisateur VARCHAR(100),
    mdp VARCHAR(100),
    grade int
);

INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Sandra','sandra',1);
INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Felana','felana',1);
INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Rija','rija',2);
INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Hanitra','hanitra',3);
INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Orlando','orlando',4);
INSERT INTO login (nom_utilisateur,mdp,grade) VALUES ('Dominique','dominique',5);

CREATE OR REPLACE VIEW alls AS 
 SELECT commande.id_commande,
    detailscommande.id_detailscommande,
    produit.id_produit,
    ntable.id_table,
    produit.nom_produit,
    detailscommande.quantite,
    produit.prix_produit,
    detailscommande.status
   FROM commande
     JOIN ntable ON commande.id_table = ntable.id_table
     JOIN detailscommande ON commande.id_commande = detailscommande.id_commande
     JOIN produit ON detailscommande.id_produit = produit.id_produit;

CREATE TABLE seuil(
    id serial PRIMARY KEY,
    idIngredient int,
    seuil int,
    FOREIGN KEY (idIngredient) REFERENCES Ingredient(id_ingredient)
);

INSERT INTO seuil (idIngredient,seuil) VALUES (1,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (2,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (3,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (4,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (5,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (6,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (7,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (8,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (9,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (10,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (11,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (12,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (13,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (14,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (15,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (16,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (17,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (18,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (19,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (20,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (21,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (22,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (23,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (24,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (25,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (26,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (27,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (28,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (29,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (30,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (31,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (32,500);
INSERT INTO seuil (idIngredient,seuil) VALUES (33,500);

create view reste as select id_ingredient,sum(entree-sortie) reste from stock_ingredient group by id_ingredient  

create view stockaEpuise as select stock_ingredient.id_ingredient,nom ,sum(entree-sortie) reste from stock_ingredient join ingredient on stock_ingredient.id_ingredient = ingredient.id_ingredient join seuil on ingredient.id_ingredient = seuil.idIngredient group by stock_ingredient.id_ingredient,nom

create view seuille as select id_ingredient , nom  
    from stockaEpuise join seuil 
        on stockaEpuise.id_ingredient = seuil.idIngredient 
            where reste < seuil