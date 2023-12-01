1. Aus der Klasse "Fish" wird ein neues Objekt namens "shark" instanziiert.
2. Aus der Klasse "Bird" wird ein neues Objekt aus der Subklasse "RoadRunner" namens "bird" instanziiert.
3. Aus der abstrakten Superklasse "Animal" wird ein neues Objekt aus der Klasse "Bird" namens "animal" instanziiert.
4. Für das Objekt "animal" wird die Methode "move" mit dem Input "the left" aus der Klasse "Bird" aufgerufen,
sodass der String "fly to the left" ausgegeben wird.
5. Das Objekt "animal" wird mit dem Objekt "bird" gleichgesetzt, sodass es nun zur Klasse "RoadRunner" gehört und die
entsprechenden Methoden (sowie Attribute) übernimmt bzw. ersetzt.
6. Für das Objekt "shark" wird versucht, die Methode "move" mit dem Input 0 aufzurufen, da in der Klasse "Fish"
allerdings die Methode "move" nicht für einen Input in Form eines "int x" definiert ist, wird auf die vererbte Methode
"move(int x)" aus der Superklasse "Animal" zurückgegriffen, sodass der String "teleport to 0" ausgegeben wird.
7. Für das Objekt "bird" wird die Methode "move" mit dem Input 0 aus der Klasse "RoadRunner" aufgerufen, sodass der
String "run faster to 0" ausgegeben wird.
8. Für das Objekt "animal" wird die Methode "move" mit dem Input "the right" aus der Klasse "RoadRunner" aufgerufen,
sodass der String "run to the right" ausgegeben wird.

Die Signatur einer Methode setzt sich aus ihrem Namen und den akzeptierten Inputparametern zusammen, bspw. akzeptiert
die Methode mit dem Namen "move" aus der Klasse "Fish" als Inputparameter einen beliebigen String "dest".

Nun wurde in der Superklasse "animal" bereits eine abstrakte Methode mit derselben Signatur erstellt. Dass sie abstrakt 
ist bedeutet, es wird zunächst einmal festgehalten, dass diese Methode existiert, sie erfüllt allerdings noch keinen
konkreten Zweck, weil eine entsprechende Implementierung fehlt. Dies geschieht erst durch das Überschreiben in den
Subklassen, die die Signatur dieser Methode übernehmen und ihre Funktion erläutern *müssen*, andernfalls gilt die
Subklasse auch als abstrakt. Für das Überschreiben einer Methode in einer Subklasse *muss* die ursprüngliche Methode aus
der Superklasse jedoch nicht abstrakt sein, so z. B. die "move(int x)"-Methode der "RoadRunner"-Subklasse, die im
spezifischen Anwendungsfall einen sinnvolleren String als die ursprüngliche Methode ausgibt.

Durch das Überladen ist es möglich, andere Inputparameter zu erlauben wie bspw. in der Klasse "animal" selbst, wo die 
Methode "move(String s)" durch die andere, nicht abstrakte Methode "move(int x)" überladen wird, wodurch die
Anwendungsmöglichkeiten und Funktionen einer Methode erweitert werden können.

1. ✔ Aus der abstrakten Superklasse "Animal" wird ein neues Objekt aus der Klasse "Fish" namens "shark" instanziiert.
2. ❌Aus der Klasse "Animal" kann kein neues Objekt direkt instanziiert werden, sonst wäre die Abstraktheit verletzt.
3. ✔ Aus der Klasse "RoadRunner" wird ein neues Objekt namens "coyote" instanziiert.
4. ❌Für die beiden Klassen "Fish" und "RoadRunner" existiert keine gemeinsame direkte Superklasse, wodurch die beiden 
jeweiligen Objekttypen inkompatibel zueinander sind. Da Java allerdings streng mit Typen umgeht, ist deshalb eine
Typzuweisung von dem Objekt "coyote" zu "nemo" nicht erlaubt.