[Les consignes du hand's on sont ici](https://github.com/ptitFicus/devquest-consignes).

## Lancer l'application

### En java (>= 17)

```sh
java -jar hero-management.jar
```

### En docker

```sh
docker run -p 8080:8080 ptitficus/playwright
```

### Avec les binaires

Exécuter un des binaires du dossier [bin](./bin), les binaires sont disponibles pour :

- windows
- linux
- macos (arm)

Une fois l'application démarrée, ouvrez un navigateur et allez sur le port 8080.


## Fonctionnement de l'application

### Choix d'un nom et d'une seed

Sur l'écran d'accueil (situé à l'url [/landing-page](http://localhost:8080/landing-page), il faut saisir un nom d'aventurer.

Il est également possible de choisir une seed qui va "fixer" l'aléatoire pour la partie : deux parties avec la même seed auront les même comportements aléatoires.

<img width="1710" alt="image" src="https://github.com/user-attachments/assets/6a03acd7-8ed1-4c2b-b63f-8081014ccfa6" />


### Recrutement d'un groupe

Une fois l'écran d'accueil passé, il vous faut recruter un groupe de héros, pour ce faire cliquez sur le bouton "Crée ton équipe" de la page principale.

Vous arrivez sur la page de création de groupe, choisissez des héros à recruter (4 max) puis cliquez sur le bouton "Créez le groupe".

Si les héros présents ne sont pas à votre goût, vous pouvez en invoquez de nouveau en cliquant sur "Invoquer un nouveau héro".


<img width="1710" alt="Screenshot 2025-06-07 at 12 32 12" src="https://github.com/user-attachments/assets/25b3f915-6832-4d6d-901e-911b702f7c69" />

### À l'aventure !

Une fois votre groupe créé, l'écran principal vous propose une liste de quête dans laquelle vous pouvez vous lancer.

Les quêtes ont des niveaux de difficulté de 1 à 5 ⚔️, les quêtes les plus difficiles ont plus de chance d'échouer et de tuer vos héros, mais rapportent également plus d'argent si elles sont réussies.

<img width="1710" alt="Screenshot 2025-06-07 at 14 22 43" src="https://github.com/user-attachments/assets/bc9f0dff-ff08-4269-a855-8eaa0ee53806" />

Cliquez sur le bouton "Commencer" à côté d'une quête pour la lancer, une quête peut soit être réussie (et vous rapportez de l'argent) soit être échouée. Dans les deux cas certains de vos héros peuvent y avoir laissé la vie.

Si la liste des quête ne vous convient pas, il est possible de la renouveler complètement en cliquant sur "Reroll", mais cela vous coutera un peu d'argent.

À tout moment, vous pouvez compléter votre groupe si il a moins de 4 héros, chaque héro coutant de l'argent à recruter ou invoquer.

### Fin de partie

La fin de partie se déclenche lorsque deux conditions sont remplies simultanément : 

🪦 Tous vos héros sont morts
💰 Vous avez moins de 1000 pièces (le montant nécessaire pour recruter un nouveau héro)


Un écran de fin de partie est alors indiqué et vous affiche votre score (le nombre d'épées ⚔ que vous avez collectés via vos quêtes).
