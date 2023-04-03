Skyjo :
	
	Règle :
		X- Ce joue de 2 à 8 joueurs FAIT
		Matériel :
			- 150 cartes
			5 * : -2
			15 * : 0
			10 * : -1 1 2 3 4 5 6 7 8 9 10 11 12
	

		Condition de victoire : FAIT
			X- Dès qu'un joueur à >= 100 points la partie s'arrête et celui qui à le moins de point gagne
		Règle particulière : FAIT
			- 3 Cartes pareil sur la même colonne = enlève la colonne 
			X- Si un joueur retourne ca derniere carte et que son air n'est pas celle qui à le moins de point, il multiplie ces points par deux
			X- Une manche ce fini quand un joueur retourne ca derniere carte face cachée, si il y encore des joueurs après lui dans l'ordre de tour est bien ces derniers joue leur coup

	Action possible du joueur : FAIT
		-Piocher dans la défausse ou la pioche 
		-echanger avec une carte visible ou non
		
	- Modéliser la pioche : FAIT
		
		-Aléatoire 
		-Pile

	- Modéliser la défausse : FAIT
		-Pile 

	- Modéliser le plateau de jeu de chaque joueur : FAIT
		-Tableau d'object de deux dimensions quasi dynamique

	-Affichage du jeux : FAIT
		-Tout les plateaux ?
		-Plusieurs mode de vue ?

	-Systeme de point FAIT

	-La boucle de jeux :
		-Systeme de round FAIT
		-Systeme de tour par round FAIT
		-Systeme de choix : FAIT
			-Echange une carte avec la defausse
			-Echange une carte avec la pioche

	-Mode de jeux :
		- Plusieurs joueur humain ?
		
		- IA :
			A faire de sur : 
				-Une ia

			Optimisation possible :
				-Deep learning ?
				-Strategie ?
				-Mode de difficulté ?
				
				
Fonction à refaire en UI :

	BoardArray :
		-displayTargetBoard(); // Affiche un tableau précis
		-displayBoards(); // Affiches tout les tableaux de jeux ->1*
	BoardSet :
		-displayBoardSet(); // Affiche un tableau de jeu donnée 1*<-
	PointManager : 
		-display(); // Affiche les points de tout les joueurs
	Main :
		-page1(); // PLAYER BOARD
		-page2(); // EVERY BOARDS
		-page3(); // POINTS
		-page4(); // SWITCH CARD
		-victoryScreen(); // VICTORY
