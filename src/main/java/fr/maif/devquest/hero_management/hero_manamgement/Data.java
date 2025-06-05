package fr.maif.devquest.hero_management.hero_manamgement;

public class Data {
    public static final String HEROES = """
                        [
              {
                "name": "Sir Belric de Griseval",
                "role": "knight",
                "achievements": [
                  "🪑 A défié un trône à un concours de regard",
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé"
                ]
              },
              {
                "name": "Mirelda l'Onguentée",
                "role": "shaman",
                "achievements": [
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🦆 A discuté politique avec une armée de canards",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse"
                ]
              },
              {
                "name": "Thamior Ombrefeuille",
                "role": "elf",
                "achievements": [
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands"
                ]
              },
              {
                "name": "Gromrak Brisecasque",
                "role": "dwarf",
                "achievements": [
                  "🍺 A vidé une taverne de ses bières sans payer",
                  "⛏️ A sculpté un dragon dans une montagne par erreur",
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes"
                ]
              },
              {
                "name": "Sire Balthazar le Frisé",
                "role": "wizard",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille... deux fois",
                  "🎩 A sorti un mouton vivant de son chapeau",
                  "💤 A endormi une armée entière en racontant une anecdote"
                ]
              },
              {
                "name": "Dame Ragonde de Lestour",
                "role": "king",
                "achievements": [
                  "🍰 A interdit les gâteaux trop secs par décret royal",
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🪕 A imposé la musique banjo à la cour pendant un mois"
                ]
              },
              {
                "name": "Alaric Tête-de-Sapin",
                "role": "archer",
                "achievements": [
                  "🏹 A décoché une flèche dans sa propre botte par mégarde",
                  "🐿️ A été adopté par une famille d'écureuils",
                  "🍎 A visé une pomme, a touché un dragon (accidentellement)"
                ]
              },
              {
                "name": "Frangine Morbidelle",
                "role": "necromancer",
                "achievements": [
                  "💀 A organisé une fête surprise pour des squelettes",
                  "🎲 A joué aux dés avec un fantôme tricheur",
                  "🪦 A perdu son grimoire dans un cimetière... puis l'a retrouvé dans une tombe"
                ]
              },
              {
                "name": "Théobald du Fond-des-Bois",
                "role": "shaman",
                "achievements": [
                  "👞 A marché 20 lieues avec une botte à l'envers",
                  "🎤 A dirigé une chorale de bardes enrhumés",
                  "🕺 A dansé trois jours d'affilée pour sauver un fromage maudit"
                ]
              },
              {
                "name": "Léonard Mousse-Râpe",
                "role": "wizard",
                "achievements": [
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "🎭 A été confondu avec une statue... et décoré par erreur"
                ]
              },
              {
                "name": "Eldwen Neigebrume",
                "role": "elf",
                "achievements": [
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "🪶 A négocié une paix durable entre hiboux et belettes"
                ]
              },
              {
                "name": "Borulf Tonnefer",
                "role": "dwarf",
                "achievements": [
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque",
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🎺 A joué du cor de guerre pour appeler ses chèvres"
                ]
              },
              {
                "name": "Zarabella Crochetemps",
                "role": "wizard",
                "achievements": [
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "🐍 A dressé un serpent en lui récitant des devinettes",
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue"
                ]
              },
              {
                "name": "Sœur Gribouille de la Lune",
                "role": "shaman",
                "achievements": [
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Rolmar Crâne-Tordu",
                "role": "king",
                "achievements": [
                  "🫅 A signé une alliance avec une armée de statues vivantes",
                  "🧄 A banni l'ail après un rêve étrange",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'"
                ]
              },
              {
                "name": "Melchior des Ombres-Chaudes",
                "role": "necromancer",
                "achievements": [
                  "🕯️ A ressuscité une chandelle oubliée",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires"
                ]
              },
              {
                "name": "Elowen Boisbrume",
                "role": "wizard",
                "achievements": [
                  "📚 A créé une bibliothèque hantée par des critiques littéraires",
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'"
                ]
              },
              {
                "name": "Quenilda à l'Oeil-Pâle",
                "role": "wizard",
                "achievements": [
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt",
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🧊 A gelé son propre reflet en se complimentant trop fort"
                ]
              },
              {
                "name": "Aldric Lac-Noir",
                "role": "archer",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes",
                  "🏹 A décoché une flèche dans sa propre botte par mégarde"
                ]
              },
              {
                "name": "Hadric de Hautelande",
                "role": "king",
                "achievements": [
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque"
                ]
              },
              {
                "name": "Norwyn Tonnefer",
                "role": "elf",
                "achievements": [
                  "🍺 A vidé une taverne de ses bières sans payer",
                  "🪑 A défié un trône à un concours de regard",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires"
                ]
              },
              {
                "name": "Kaelis Tonnefer",
                "role": "wizard",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Elowen à l'Oeil-Pâle",
                "role": "wizard",
                "achievements": [
                  "🪑 A défié un trône à un concours de regard",
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Brunhilde du Val-Haume",
                "role": "dwarf",
                "achievements": [
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "🎩 A sorti un mouton vivant de son chapeau"
                ]
              },
              {
                "name": "Maelis Lame-Sourde",
                "role": "wizard",
                "achievements": [
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "⛏️ A sculpté un dragon dans une montagne par erreur",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands"
                ]
              },
              {
                "name": "Aldric Lac-Noir",
                "role": "knight",
                "achievements": [
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés"
                ]
              },
              {
                "name": "Fendrel du Fond-des-Bois",
                "role": "elf",
                "achievements": [
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "🕯️ A ressuscité une chandelle oubliée"
                ]
              },
              {
                "name": "Maelis Tête-de-Loup",
                "role": "elf",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🪑 A défié un trône à un concours de regard",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'"
                ]
              },
              {
                "name": "Lazgar de Hautelande",
                "role": "elf",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'"
                ]
              },
              {
                "name": "Fendrel d'Épine-Sang",
                "role": "archer",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Quenilda de Griseval",
                "role": "elf",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule"
                ]
              },
              {
                "name": "Isolde Lame-Sourde",
                "role": "king",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt"
                ]
              },
              {
                "name": "Norwyn d'Épine-Sang",
                "role": "elf",
                "achievements": [
                  "🏹 A décoché une flèche dans sa propre botte par mégarde",
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🎭 A été confondu avec une statue... et décoré par erreur"
                ]
              },
              {
                "name": "Dameon des Ombres",
                "role": "wizard",
                "achievements": [
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🐍 A dressé un serpent en lui récitant des devinettes"
                ]
              },
              {
                "name": "Hadric Tête-de-Loup",
                "role": "necromancer",
                "achievements": [
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "🐍 A dressé un serpent en lui récitant des devinettes"
                ]
              },
              {
                "name": "Seraphine du Fond-des-Bois",
                "role": "wizard",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🪑 A défié un trône à un concours de regard",
                  "🍺 A vidé une taverne de ses bières sans payer"
                ]
              },
              {
                "name": "Vandred des Ombres",
                "role": "elf",
                "achievements": [
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "🪕 A imposé la musique banjo à la cour pendant un mois"
                ]
              },
              {
                "name": "Roderic des Ombres",
                "role": "king",
                "achievements": [
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🦆 A discuté politique avec une armée de canards"
                ]
              },
              {
                "name": "Maelis Lac-Noir",
                "role": "archer",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🎭 A été confondu avec une statue... et décoré par erreur",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Jorund Boisbrume",
                "role": "elf",
                "achievements": [
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🪑 A défié un trône à un concours de regard",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires"
                ]
              },
              {
                "name": "Kaelis Crochetemps",
                "role": "archer",
                "achievements": [
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule"
                ]
              },
              {
                "name": "Jorund Neigebrume",
                "role": "king",
                "achievements": [
                  "🐍 A dressé un serpent en lui récitant des devinettes",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "💤 A endormi une armée entière en racontant une anecdote"
                ]
              },
              {
                "name": "Kaelis Tête-de-Loup",
                "role": "knight",
                "achievements": [
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🎩 A sorti un mouton vivant de son chapeau",
                  "🧃 A tenté de distiller de la potion avec du jus de navet"
                ]
              },
              {
                "name": "Maelis Tête-de-Loup",
                "role": "elf",
                "achievements": [
                  "🐍 A dressé un serpent en lui récitant des devinettes",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Wulfgar de Griseval",
                "role": "archer",
                "achievements": [
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt",
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'"
                ]
              },
              {
                "name": "Zanric des Ombres",
                "role": "wizard",
                "achievements": [
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'",
                  "🎭 A été confondu avec une statue... et décoré par erreur"
                ]
              },
              {
                "name": "Norwyn Tonnefer",
                "role": "king",
                "achievements": [
                  "🕯️ A ressuscité une chandelle oubliée",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🏹 A décoché une flèche dans sa propre botte par mégarde"
                ]
              },
              {
                "name": "Gisla du Fond-des-Bois",
                "role": "archer",
                "achievements": [
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'"
                ]
              },
              {
                "name": "Wulfgar de Griseval",
                "role": "knight",
                "achievements": [
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse"
                ]
              },
              {
                "name": "Maelis Lame-Sourde",
                "role": "archer",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🪑 A défié un trône à un concours de regard"
                ]
              },
              {
                "name": "Ysoria Tête-de-Loup",
                "role": "elf",
                "achievements": [
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite"
                ]
              },
              {
                "name": "Tormund Boisbrume",
                "role": "archer",
                "achievements": [
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes"
                ]
              },
              {
                "name": "Brunhilde Boisbrume",
                "role": "dwarf",
                "achievements": [
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🎩 A sorti un mouton vivant de son chapeau"
                ]
              },
              {
                "name": "Kaelis l'Ensorceleur",
                "role": "shaman",
                "achievements": [
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "🪶 A prédit la pluie avec des plumes de poulet"
                ]
              },
              {
                "name": "Seraphine Crochetemps",
                "role": "elf",
                "achievements": [
                  "📚 A créé une bibliothèque hantée par des critiques littéraires",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🏹 A décoché une flèche dans sa propre botte par mégarde"
                ]
              },
              {
                "name": "Tormund à l'Oeil-Pâle",
                "role": "necromancer",
                "achievements": [
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse"
                ]
              },
              {
                "name": "Maelis à l'Oeil-Pâle",
                "role": "wizard",
                "achievements": [
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "🎺 A joué du cor de guerre pour appeler ses chèvres",
                  "🕯️ A ressuscité une chandelle oubliée"
                ]
              },
              {
                "name": "Maelis Lac-Noir",
                "role": "necromancer",
                "achievements": [
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'"
                ]
              },
              {
                "name": "Seraphine l'Ensorceleur",
                "role": "necromancer",
                "achievements": [
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "🕯️ A ressuscité une chandelle oubliée",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Norwyn des Ombres",
                "role": "wizard",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🪶 A prédit la pluie avec des plumes de poulet"
                ]
              },
              {
                "name": "Wulfgar l'Ensorceleur",
                "role": "wizard",
                "achievements": [
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🎺 A joué du cor de guerre pour appeler ses chèvres",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes"
                ]
              },
              {
                "name": "Brunhilde d'Épine-Sang",
                "role": "necromancer",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🎩 A sorti un mouton vivant de son chapeau",
                  "🐓 A dompté un coq géant avec une flûte cassée"
                ]
              },
              {
                "name": "Fendrel du Val-Haume",
                "role": "wizard",
                "achievements": [
                  "🦆 A discuté politique avec une armée de canards",
                  "🐍 A dressé un serpent en lui récitant des devinettes",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes"
                ]
              },
              {
                "name": "Maelis Tonnefer",
                "role": "wizard",
                "achievements": [
                  "🍺 A vidé une taverne de ses bières sans payer",
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue",
                  "🎺 A joué du cor de guerre pour appeler ses chèvres"
                ]
              },
              {
                "name": "Jorund Lame-Sourde",
                "role": "archer",
                "achievements": [
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel"
                ]
              },
              {
                "name": "Tormund d'Épine-Sang",
                "role": "shaman",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite"
                ]
              },
              {
                "name": "Gisla Brisecasque",
                "role": "archer",
                "achievements": [
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires"
                ]
              },
              {
                "name": "Dameon de Griseval",
                "role": "wizard",
                "achievements": [
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🧊 A gelé son propre reflet en se complimentant trop fort"
                ]
              },
              {
                "name": "Fendrel l'Ensorceleur",
                "role": "knight",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'"
                ]
              },
              {
                "name": "Fendrel du Fond-des-Bois",
                "role": "wizard",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue",
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque"
                ]
              },
              {
                "name": "Vandred du Val-Haume",
                "role": "elf",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Jorund Tête-de-Loup",
                "role": "necromancer",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Dameon Lac-Noir",
                "role": "wizard",
                "achievements": [
                  "🎩 A sorti un mouton vivant de son chapeau",
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque",
                  "🏹 A décoché une flèche dans sa propre botte par mégarde"
                ]
              },
              {
                "name": "Gisla Brisecasque",
                "role": "king",
                "achievements": [
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "🪑 A défié un trône à un concours de regard"
                ]
              },
              {
                "name": "Ysoria Brisecasque",
                "role": "dwarf",
                "achievements": [
                  "🦆 A discuté politique avec une armée de canards",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "🪑 A défié un trône à un concours de regard"
                ]
              },
              {
                "name": "Peredur l'Ensorceleur",
                "role": "king",
                "achievements": [
                  "🧄 A banni l'ail après un rêve étrange",
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel"
                ]
              },
              {
                "name": "Zanric Tête-de-Loup",
                "role": "wizard",
                "achievements": [
                  "🧄 A banni l'ail après un rêve étrange",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🌪️ A invoqué une tornade pour sécher sa lessive"
                ]
              },
              {
                "name": "Fendrel de Griseval",
                "role": "knight",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'"
                ]
              },
              {
                "name": "Aldric de Hautelande",
                "role": "necromancer",
                "achievements": [
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes"
                ]
              },
              {
                "name": "Quenilda Lame-Sourde",
                "role": "king",
                "achievements": [
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue",
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres"
                ]
              },
              {
                "name": "Norwyn Crochetemps",
                "role": "archer",
                "achievements": [
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "📚 A créé une bibliothèque hantée par des critiques littéraires"
                ]
              },
              {
                "name": "Ulfric de Hautelande",
                "role": "elf",
                "achievements": [
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🍺 A vidé une taverne de ses bières sans payer",
                  "🪕 A imposé la musique banjo à la cour pendant un mois"
                ]
              },
              {
                "name": "Aldric Crochetemps",
                "role": "elf",
                "achievements": [
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands"
                ]
              },
              {
                "name": "Ysoria de Hautelande",
                "role": "necromancer",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt",
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite"
                ]
              },
              {
                "name": "Lazgar de Griseval",
                "role": "knight",
                "achievements": [
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🧊 A gelé son propre reflet en se complimentant trop fort"
                ]
              },
              {
                "name": "Isolde de Griseval",
                "role": "necromancer",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "🐍 A dressé un serpent en lui récitant des devinettes"
                ]
              },
              {
                "name": "Ysoria Tête-de-Loup",
                "role": "king",
                "achievements": [
                  "📜 A écrit une pièce de théâtre pour des gobelins illettrés",
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "🕯️ A ressuscité une chandelle oubliée"
                ]
              },
              {
                "name": "Roderic Brisecasque",
                "role": "wizard",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "💤 A endormi une armée entière en racontant une anecdote"
                ]
              },
              {
                "name": "Wulfgar du Val-Haume",
                "role": "dwarf",
                "achievements": [
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🐝 A négocié un traité de paix entre les abeilles et les bardes"
                ]
              },
              {
                "name": "Ysoria Neigebrume",
                "role": "wizard",
                "achievements": [
                  "🪶 A prédit la pluie avec des plumes de poulet",
                  "🎩 A élevé un zombie majordome nommé 'Gédéon'",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte"
                ]
              },
              {
                "name": "Dameon de Griseval",
                "role": "elf",
                "achievements": [
                  "🧄 A banni l'ail après un rêve étrange",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands"
                ]
              },
              {
                "name": "Isolde du Fond-des-Bois",
                "role": "necromancer",
                "achievements": [
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🕯️ A ressuscité une chandelle oubliée",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres"
                ]
              },
              {
                "name": "Norwyn Brisecasque",
                "role": "shaman",
                "achievements": [
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🎯 A lancé une hache qui a gagné au jeu de fléchettes",
                  "🎭 A été confondu avec une statue... et décoré par erreur"
                ]
              },
              {
                "name": "Quenilda des Ombres",
                "role": "shaman",
                "achievements": [
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🐍 A dressé un serpent en lui récitant des devinettes"
                ]
              },
              {
                "name": "Lazgar du Val-Haume",
                "role": "knight",
                "achievements": [
                  "🎭 A été confondu avec une statue... et décoré par erreur",
                  "🧃 A tenté de distiller de la potion avec du jus de navet",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte"
                ]
              },
              {
                "name": "Elowen Neigebrume",
                "role": "archer",
                "achievements": [
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé",
                  "🧊 A gelé son propre reflet en se complimentant trop fort",
                  "🪕 A imposé la musique banjo à la cour pendant un mois"
                ]
              },
              {
                "name": "Lazgar l'Ensorceleur",
                "role": "dwarf",
                "achievements": [
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🏹 A décoché une flèche dans sa propre botte par mégarde",
                  "🪶 A prédit la pluie avec des plumes de poulet"
                ]
              },
              {
                "name": "Gisla des Ombres",
                "role": "shaman",
                "achievements": [
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt"
                ]
              },
              {
                "name": "Roderic Crochetemps",
                "role": "shaman",
                "achievements": [
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🌪️ A invoqué une tornade pour sécher sa lessive",
                  "🧄 A banni l'ail après un rêve étrange"
                ]
              },
              {
                "name": "Aldric Crochetemps",
                "role": "archer",
                "achievements": [
                  "🪑 A défié un trône à un concours de regard",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🍺 A vidé une taverne de ses bières sans payer"
                ]
              },
              {
                "name": "Seraphine à l'Oeil-Pâle",
                "role": "archer",
                "achievements": [
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt"
                ]
              },
              {
                "name": "Lazgar Crochetemps",
                "role": "archer",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Dameon Tête-de-Loup",
                "role": "elf",
                "achievements": [
                  "👑 A perdu sa couronne dans un puits... et l'a remplacée par une marmite",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "🦆 A discuté politique avec une armée de canards"
                ]
              },
              {
                "name": "Fendrel du Fond-des-Bois",
                "role": "elf",
                "achievements": [
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt",
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🦆 A discuté politique avec une armée de canards"
                ]
              },
              {
                "name": "Orlan à l'Oeil-Pâle",
                "role": "shaman",
                "achievements": [
                  "🪕 A imposé la musique banjo à la cour pendant un mois",
                  "🌿 A ressuscité une plante verte en lui chantant une berceuse",
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel"
                ]
              },
              {
                "name": "Lazgar du Fond-des-Bois",
                "role": "elf",
                "achievements": [
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🪑 A défié un trône à un concours de regard",
                  "🦆 A discuté politique avec une armée de canards"
                ]
              },
              {
                "name": "Ulfric des Ombres",
                "role": "necromancer",
                "achievements": [
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🕯️ A ressuscité une chandelle oubliée",
                  "⏳ A remonté le temps pour rater un rendez-vous encore plus tôt"
                ]
              },
              {
                "name": "Jorund d'Épine-Sang",
                "role": "archer",
                "achievements": [
                  "🥨 A mangé un bouclier par erreur en pensant que c'était un bretzel",
                  "📦 A enfermé ses conseillers dans une boîte pour ‘stimuler leur réflexion'",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres"
                ]
              },
              {
                "name": "Vandred Lac-Noir",
                "role": "necromancer",
                "achievements": [
                  "🎻 A ensorcelé une harpe pour qu'elle compose seule",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé"
                ]
              },
              {
                "name": "Gisla de Griseval",
                "role": "archer",
                "achievements": [
                  "🍺 A vidé une taverne de ses bières sans payer",
                  "❄️ A tricoté une écharpe magique de 18 kilomètres",
                  "🛖 A invoqué un esprit... qui s'est endormi aussitôt"
                ]
              },
              {
                "name": "Seraphine de Griseval",
                "role": "wizard",
                "achievements": [
                  "🐍 A dressé un serpent en lui récitant des devinettes",
                  "🧼 A glissé sur une colline savonneuse pour échapper à des brigands",
                  "🪶 A négocié une paix durable entre hiboux et belettes"
                ]
              },
              {
                "name": "Jorund à l'Oeil-Pâle",
                "role": "elf",
                "achievements": [
                  "⛏️ A sculpté un dragon dans une montagne par erreur",
                  "💤 A endormi une armée entière en racontant une anecdote",
                  "🍺 A vidé une taverne de ses bières sans payer"
                ]
              },
              {
                "name": "Vandred des Ombres",
                "role": "elf",
                "achievements": [
                  "🎆 A accidentellement illuminé une ville avec une baguette fourchue",
                  "🍷 A battu un troll au concours de vin sans renverser une goutte",
                  "🦆 A discuté politique avec une armée de canards"
                ]
              },
              {
                "name": "Norwyn Lame-Sourde",
                "role": "wizard",
                "achievements": [
                  "🛢️ A roulé dans un tonneau jusqu'à la frontière orque",
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "⛏️ A sculpté un dragon dans une montagne par erreur"
                ]
              },
              {
                "name": "Peredur d'Épine-Sang",
                "role": "necromancer",
                "achievements": [
                  "🎩 A sorti un mouton vivant de son chapeau",
                  "🐸 A accidentellement transformé un roi en grenouille",
                  "🍖 A volé un banquet royal pour nourrir un hérisson affamé"
                ]
              },
              {
                "name": "Elowen de Hautelande",
                "role": "king",
                "achievements": [
                  "🐓 A dompté un coq géant avec une flûte cassée",
                  "🪶 A négocié une paix durable entre hiboux et belettes",
                  "🪶 A prédit la pluie avec des plumes de poulet"
                ]
              }
            ]""";

    public static final String QUEST_LOCATIONS = """
                        [
              "des cités d'or",
              "de la citadelle endormie",
              "des terres oubliées",
              "du sanctuaire brisé",
              "des abysses gelés",
              "de la tour sans fin",
              "des jungles maudites",
              "des ruines chantantes",
              "du royaume souterrain",
              "de la mer figée",
              "des marais du silence",
              "de la forêt pétrifiée",
              "du désert chantant",
              "des pics de l'oubli",
              "de la vallée des âmes",
              "du canyon du néant",
              "des monts cendrés",
              "des collines hurlantes",
              "de l'île aux murmures",
              "des landes du crépuscule",
              "des steppes endormies",
              "de la faille infinie",
              "des grottes de cristal",
              "du glacier brisé",
              "du tombeau royal",
              "des falaises du vent",
              "des arches d'obsidienne",
              "du gouffre béant",
              "des plaines éternelles",
              "du volcan silencieux",
              "des jardins du temps",
              "de la passe interdite",
              "des catacombes noyées",
              "du port fantôme",
              "de la clairière aux esprits",
              "du bastion oublié",
              "du labyrinthe vivant",
              "des champs d'ossements",
              "du cimetière stellaire",
              "des murailles de feu",
              "du dôme d'argent",
              "des sentiers disparus",
              "du lac sans fond",
              "de l'antre du ver",
              "du pont des étoiles",
              "du cœur des montagnes",
              "des mines d'éternité",
              "du havre des brumes",
              "des ruines sous-marines",
              "des cryptes anciennes",
              "du phare éteint",
              "des terres de cendres",
              "du cercle de pierre",
              "des ruines de verre",
              "du palais effondré",
              "des profondeurs vertes",
              "du marais écarlate",
              "de la clairière obscure",
              "du royaume fracturé",
              "des sables du sommeil",
              "du cercle oublié",
              "des arches du néant",
              "des forteresses silencieuses",
              "du cratère endormi",
              "du tombeau du roi",
              "des plateaux du tonnerre",
              "du sanctuaire des murmures",
              "des grottes sans fin",
              "du sommet isolé",
              "du village englouti",
              "des marais sans étoiles",
              "des montagnes du vent noir",
              "du désert des miroirs",
              "du fjord brisé",
              "du rivage oublié",
              "des pics de l'aube",
              "des lacs de glace",
              "du tunnel du néant",
              "des landes toxiques",
              "du bois hanté",
              "du campement perdu",
              "des vestiges anciens",
              "de l'île en feu",
              "du temple scellé",
              "du val du jugement",
              "des prairies lunaires",
              "du bassin des ombres",
              "du col de l'oubli",
              "des chaînes de brume",
              "du tombeau sans nom",
              "du fort des murmures",
              "des grottes d'émeraude",
              "du volcan d'obsidienne",
              "du delta spectral",
              "du val de givre",
              "du sanctuaire oublié",
              "des ruines du premier âge",
              "du bastion gelé",
              "de la baie maudite",
              "des cieux brisés",
              "du colosse effondré"
            ]
            """;

    public static final String QUEST_NAMES = """
                        [
              "Le crâne maudit",
              "Le grimoire fantastique",
              "L'amulette oubliée",
              "La lame céleste",
              "Le masque d'ombre",
              "Le sceptre interdit",
              "L'oracle perdu",
              "La clé du néant",
              "Le miroir du destin",
              "Le fragment éternel",
              "L'étoile brisée",
              "Le cœur de glace",
              "Le corbeau d'argent",
              "La couronne déchue",
              "L'armure des anciens",
              "Le sang du dragon",
              "La larme du titan",
              "La gemme des âges",
              "Le livre des ombres",
              "La flamme spectrale",
              "Le bouclier de l'aube",
              "La dague du silence",
              "Le tambour du tonnerre",
              "Le totem oublié",
              "La pierre des secrets",
              "La rose de minuit",
              "Le parchemin interdit",
              "La harpe du vent",
              "Le sablier inversé",
              "Le poignard du serpent",
              "Le trident des marées",
              "La lanterne éternelle",
              "Le casque de la folie",
              "Le souffle du colosse",
              "Le talisman voilé",
              "La fiole de vie",
              "La faux du pénitent",
              "Le collier d'épines",
              "La rune de givre",
              "Le marteau du jugement",
              "La plume du phénix",
              "La lyre silencieuse",
              "Le carillon d'obsidienne",
              "La conque des abysses",
              "La boussole du chaos",
              "L'écaille de wyrm",
              "Le sceau du crépuscule",
              "La dent de géant",
              "L'ombre du roi",
              "La pierre du veilleur",
              "Le cri du banshee",
              "La perle du sommeil",
              "Le manteau des brumes",
              "L'épine du destin",
              "Le venin sacré",
              "Le souffle de l'aigle",
              "La griffe de la bête",
              "Le fléau des cieux",
              "La chaîne de lumière",
              "Le chant du silence",
              "La cloche du jugement",
              "L'iris de cristal",
              "Le regard du néant",
              "La voix des profondeurs",
              "Le souffle du néant",
              "La corne du centaure",
              "Le cri du cor",
              "Le halo de la lune",
              "Le médaillon oublié",
              "La couronne du feu",
              "La chaîne du sacrifice",
              "La gemme de sang",
              "Le coffre des âmes",
              "Le sabre des dunes",
              "La lance des cieux",
              "Le lys des morts",
              "La rose des tempêtes",
              "La corde du pendu",
              "Le sceptre du roi-liche",
              "La dent du colosse",
              "La goutte d'éternité",
              "La pierre des larmes",
              "Le grimoire du chaos",
              "La coquille du titan",
              "La braise du dernier feu",
              "Le voile de minuit",
              "La corde d'argent",
              "Le masque du traître",
              "Le souffle oublié",
              "Le fragment du ciel",
              "La flèche du destin",
              "La bannière écarlate",
              "Le tambour du vide",
              "Le sceau des ombres",
              "Le sablier du roi",
              "La main du spectre",
              "Le lys du crépuscule",
              "La pierre de la fin",
              "Le chant du monde",
              "La voix oubliée",
              "Le totem de cendres",
              "Le manuscrit doré"
            ]
            """;
}
