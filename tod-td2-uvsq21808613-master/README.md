# Exercices JUnit/Java

## Importation du projet dans un IDE
Ce projet utilise le l'outil de _build_ [`gradle`](https://gradle.org/). L'intérêt est que le projet peut être à la fois utilisé en ligne de commande sans autre installation préalable qu'un JDK et importé dans un IDE.

Pour importer ce projet, la procédure diffère selon les IDE.
* [IntelliJ](https://www.jetbrains.com/idea/) supporte `gradle` par défaut. Il suffit donc d'importer le projet.
* [Eclipse](https://www.eclipse.org/ide/) a besoin d'un plugin pour intéragir avec `gradle` (cf. [Using the Gradle build system in the Eclipse IDE](https://www.vogella.com/tutorials/EclipseGradle/article.html)).
* pour les autres, il faut consulter la documentation ou tout simplement ouvrir les sources se trouvant dans `src/main/java/fr/uvsq/tod` ou les tests dans `src/test/java/fr/uvsq/tod`. 

## Tests et débogage (présentiel)
### Tests unitaires/TDD
On veut implémenter une classe représentant un compte bancaire.
Les opérations que devra supporter le compte sont :
* l’initialisation avec un solde initial,
* la consultation du solde,
* le crédit,
* le débit et,
* le virement vers un autre compte.

La réalisation devra tenir compte des contraintes suivantes :
* un compte n’est jamais à découvert,
* seules des sommes positives peuvent être passées en paramètre des opérations,
* l’invocation du débit ou du virement ne peut se faire qu’avec une somme inférieure au solde du compte concerné.

Vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
La prise en compte des contraintes se fera par de la gestion d’erreurs (exceptions par exemple).

Pour réaliser cet exercice, vous modifierez les fichiers [Compte.java](src/main/java/fr/uvsq/tod/compte/Compte.java) et [CompteTest.java](src/test/java/fr/uvsq/tod/compte/CompteTest.java).
Vous créerez une nouvelle version (_commit_) à la fin de chaque cas de test afin de pouvoir naviguer dans l’historique (`git checkout`) pour consulter l’état du projet avant le premier test, après le premier, après le second test, ...
Chaque version que vous créerez devra compiler et passer l’ensemble des tests déjà implémentés.

1. Énumérez une liste de cas de tests à réaliser.
    1. un compte créé avec une somme initiale de 100 doit avoir un solde de 100 (**compléter le constructeur et l'accesseur**)
    1. la création d'un compte avec une somme initiale négative doit échouer (**ajouter le test et compléter le constructeur**))
    1. COMPLÉTER ICI
    1. ...
2. Pour chaque cas de test identifié ci-dessus,
    1. écrivez le test JUnit correspondant dans la classe de test,
    1. vérifiez qu’il échoue,
    1. implémentez la fonctionnalité dans la classe `Compte`,
    1. vérifiez que le test passe,
    1. si nécessaire, appliquez une étape de refactoring sur les tests et la classe `Compte`.

### Débogage et tests unitaires
Cet exemple est issu du [tutoriel de Cay Horstmann](http://www.horstmann.com/bigj/help/debugger/tutorial.html).

La classe [`WordAnalyser`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzer.java) permet d’analyser un mot en invoquant diverses méthodes.
Cependant, cette classe contient plusieurs bogues.
Les programmes de test ([`WordAnalyzerTester`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester.java), [`WordAnalyzerTester2`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester2.java), [`WordAnalyzerTester3`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester3.java)) vérifient le fonctionnement des méthodes.

L'objectif de cet exercice est de créer un cas de test pour mettre en évidence chaque bogue, d'utiliser un débogueur pour en identifier la cause pour enfin de corriger.

#### La méthode `firstRepeatedCharacter`
La méthode `firstRepeatedCharacter` retourne le 1er caractère répété (adjacent) dans un mot.
Le programme [`WordAnalyzerTester`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester.java) vérifie le fonctionnement de cette méthode.

1. Exécuter le programme. Que se passe-t-il ? De quel type d'erreur s'agit-il ? 
    * RÉPONDRE ICI
1. Transformer un par un les tests effectués dans [`WordAnalyzerTester`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester.java) en cas de test JUnit (dans la classe [`WordAnalyzerTest`](src/test/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTest.java)).
    * à chaque fois, corriger la méthode `firstRepeatedCharacter` pour que le test passe
1. Réexécuter l'ensemble des tests pour vérifier le bon fonctionnement de la méthode. 

#### La méthode `firstMultipleCharacter`
La méthode `firstRepeatedCharacter` retourne le 1er caractère répété (non forcément adjacent) dans un mot.
Le programme [`WordAnalyzerTester2`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester2.java) vérifie le fonctionnement de cette méthode.

1. Exécuter le programme. Que se passe-t-il ?
    * RÉPONDRE ICI
1. Transformer un par un les tests effectués dans [`WordAnalyzerTester2`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester2.java) en cas de test JUnit (dans la classe [`WordAnalyzerTest`](src/test/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTest.java)).
    1. en cas de résultat inattendu, placer un *point d'arrêt* au début du test
    1. utiliser le débogueur en mode pas à pas pour identifier le problème  
    1. corriger la méthode pour que le test passe
1. Réexécuter l'ensemble des tests pour vérifier le bon fonctionnement de la méthode. 

#### La méthode `countRepeatedCharacters`
La méthode `countRepeatedCharacters` retourne le nombre de séquences composées d'un caractère répété dans un mot.
Le programme [`WordAnalyzerTester3`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester3.java) vérifie le fonctionnement de cette méthode.

1. Exécuter le programme. Que se passe-t-il ?
    * RÉPONDRE ICI
1. Transformer un par un les tests effectués dans [`WordAnalyzerTester3`](src/main/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTester3.java) en cas de test JUnit (dans la classe [`WordAnalyzerTest`](src/test/java/fr/uvsq/tod/wordanalyser/WordAnalyzerTest.java)).
    1. en cas de résultat inattendu, placer un *point d'arrêt* au début du test
    1. utiliser le débogueur en mode pas à pas pour identifier le problème  
    1. corriger la méthode pour que le test passe
1. Réexécuter l'ensemble des tests pour vérifier le bon fonctionnement de la méthode. 

## Révisions : programmation Java (distanciel)
L'objectif de cet exercice est de réaliser une classe *immuable* `Fraction` qui représente un nombre rationnel.
Un exemple d'interface pour une telle classe est donné par la classe [`Fraction`](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](http://commons.apache.org/math/).

La classe utilisera le type [`BigInteger`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html) pour représenter le numérateur et le dénominateur du nombre rationnel.

Pour chaque question ci-dessous, un ou plusieurs cas de test permettront de vérifier l'implémentation (classe [`FractionTest`](src/test/java/fr/uvsq/tod/fraction/FractionTest.java)).
Vous compléterez la classe [`Fraction`](src/main/java/fr/uvsq/tod/fraction/Fraction.java)) afin de faire passer l'ensemble des tests.
Après chaque question, vous validerez les modifications avec `git`.``

1. Qu'est-ce qu'une classe immuable ?
Quel impact cela aura sur l'implémentation ?
    * RÉPONDRE ICI
1. Ajouter un constructeur initialisant la fraction avec un numérateur et un dénominateur (test `shouldInitializeAFractionFromTwoNumbers`)
1. Quels attributs doit-on ajouter ?
Quels [modificateurs](https://docs.oracle.com/javase/specs/jls/se11/html/jls-8.html#jls-8.3.1) doit-on leur appliquer ?
    * RÉPONDRE ICI
1. Ajouter des accesseurs pour le numérateur et le dénominateur
1. Ajouter deux constructeurs (utiliser `this` de la façon présentée dans [How do I call one constructor from another in Java?](https://stackoverflow.com/a/285187/3982584)) :
    1. avec le numérateur (dénominateur égal à _1_) (test `shouldInitializeAFractionFromOneNumber`)
    1. sans argument (numérateur égal _0_ et dénominateur égal à _1_) (test `shouldInitializeAFractionWithoutParameters`)
1. En utilisant des membres de classe (attributs `static`), définir les constantes ZERO (0, 1), UN_DEMI (1, 2) et UN (1, 1)
1. Ajouter la méthode `doubleValue()` retournant la valeur sous la forme d'un nombre en virgule flottante (`double`) (test `shouldReturnAFractionAsADouble`)
1. Ajouter la méthode `add` permettant d'additionner deux fractions (test `shouldAddTwoFractions`)
1. Redéfinir la méthode `toString` pour retourner un représentation de la fraction sous la forme d'une chaîne de caractères (test `shouldReturnAStringRepresentation`),
1. Redéfinir les méthodes `equals` et `hashCode` implémentant le test d'égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) (cf. [Retour sur les bases : equals et hashCode](https://www.infoq.com/fr/articles/retour-sur-les-bases-equals-et-hashcode/)) (tests `shouldBeEquals` et `shouldVerifyEqualAndHashCodeContract`)
1. Implémenter l'interface [`Comparator<T>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html) et redéfinir `compareTo` pour comparer deux fractions selon l'ordre naturel (tests `shouldBeLesserThan` et `shouldVerifyCompareToContract`).
