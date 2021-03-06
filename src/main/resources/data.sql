
INSERT IGNORE INTO utilisateur (`id`, `nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('1', 'Gallard', 'Fabrice', 'GF1', 'ADMIN', 'AZER');
INSERT IGNORE INTO utilisateur (`id`, `nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('2', 'Balmine', 'Davy', 'BD2', 'SERGENT', 'QSDF');
INSERT IGNORE INTO utilisateur (`id`, `nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('3', 'Genre', 'Didier', 'GD3', 'INSPECTEUR', 'WXCV');
INSERT IGNORE INTO utilisateur (`id`, `nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('4', 'Gerard', 'Sylvain', 'GS4', 'AGENT', '1234');

INSERT IGNORE INTO arme (`id`, `marque`, `modele`, `type`, `calibre`, `numero_serie`, `infos_complementaire`) VALUES ('1', 'FN', 'FAMAS', 'Fusil automatique', '5.56', '8K345876M13', '');
INSERT IGNORE INTO arme (`id`, `marque`, `modele`, `type`, `calibre`, `numero_serie`, `infos_complementaire`) VALUES ('2', 'Colt', 'Python', 'Revolver', '357 Magnum', '65433HY8', '');
INSERT IGNORE INTO arme (`id`, `marque`, `modele`, `type`, `calibre`, `numero_serie`, `infos_complementaire`) VALUES ('3', 'Berretta', '92S', 'Pistolet', '9mm', '1235TYU678', '');

INSERT IGNORE INTO vehicule (`id`, `infos_complementaire`, `marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('1', 'Antiquité', 'Citroen', '2CV', 'Voiture', 'Gris', '12AB45');
INSERT IGNORE INTO vehicule (`id`, `infos_complementaire`, `marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('2', 'Voiture la Poste', 'Renault', 'Kangoo', 'Utilitaire', 'Jaune', 'AB345RT');
INSERT IGNORE INTO vehicule (`id`, `infos_complementaire`, `marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('3', '', 'Scania', 'Serie G', 'Camion', 'Blanc', 'ER654YU');

INSERT IGNORE INTO affaire (`id_affaire`, `classee`, `date_cloture`, `date_creation`, `nom_affaire`, `pieces_conviction`) VALUES ('1', True, '2016-08-30 19:05:00', '2013-08-16 19:05:00', 'La Brouette disparue', 'Trace de pas, trace de roue.');
INSERT IGNORE INTO affaire (`id_affaire`, `classee`, `date_cloture`, `date_creation`, `nom_affaire`, `pieces_conviction`) VALUES ('2', False, '2015-04-12 19:05:00', '2013-08-24 19:05:00', 'Le petit Grégory', '');
INSERT IGNORE INTO affaire (`id_affaire`, `classee`, `date_cloture`, `date_creation`, `nom_affaire`, `pieces_conviction`) VALUES ('3', True, '2017-09-21 19:05:00', '2013-02-12 19:05:00', 'La sucette abandonnée', '');

INSERT IGNORE INTO suspect (`id`, `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `matricule`, `poids`, `sexe`, `signes_particuliers`, `taille`) VALUES ('1', 'Manson', 'Charles', 'ACAAGATGCCATTGT', '2221 Hanover Street', '1934-11-12 00:00:00', 'Condamné à mort le 25 janvier 1971', 'ML 676487', '70', 'M', 'Un des criminels les plus connus de l’histoire', '170');
INSERT IGNORE INTO suspect (`id`, `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `matricule`, `poids`, `sexe`, `signes_particuliers`, `taille`) VALUES ('2', 'Capone', 'Al', 'CTCCTGCTGCTGCTGCT', '378 Park Avenue', '1899-01-17 00:00:00', 'Un des plus grands gangsters du dernier siècle', 'DF 43345', '65', 'M', 'Surnommé « Scarface »', '159'); 
INSERT IGNORE INTO suspect (`id`, `nom`, `prenom`, `adn`, `adresse`, `date_naissance`, `infos_suspect`, `matricule`, `poids`, `sexe`, `signes_particuliers`, `taille`) VALUES ('3', 'Parker', 'Bonnie', 'CAGTGCCGGGCCCCTCATA', '2154 Canis Heights Drive', '1910-10-01 00:00:00', 'Spécialiste du braquage de banques.', 'CP 97365', '55', 'F', 'Femme, Brune.', '168');

--------------------------------
-- DATA LIEES AUX AFFAIRES -----
--------------------------------

INSERT IGNORE INTO affaire_arme (`id_affaire`, `id_arme`) VALUES ('1', '1');
INSERT IGNORE INTO affaire_arme (`id_affaire`, `id_arme`) VALUES ('2', '3');
INSERT IGNORE INTO affaire_arme (`id_affaire`, `id_arme`) VALUES ('2', '2');

INSERT IGNORE INTO affaire_suspect (`id_affaire`, `id_suspect`) VALUES ('1', '2');
INSERT IGNORE INTO affaire_suspect (`id_affaire`, `id_suspect`) VALUES ('2', '3');
INSERT IGNORE INTO affaire_suspect (`id_affaire`, `id_suspect`) VALUES ('3', '1');