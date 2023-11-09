Algorithmus:
(1) Ist der Dividend und oder der Divisor < 0, beginne nicht mit der Übung0.Division (nicht im Bereich der natürlichen Zahlen möglich)
(2) Ist der Divisor 0, beginne nicht mit der Übung0.Division (Übung0.Division durch 0 nicht definiert)
(3) Ist der Dividend 0, erhalte das Ergebnis 0
(4) Ist der Dividend < Divisor, erhalte das Ergebnis 0 mit dem Rest = Dividend
(5) Berechne den Rest mithilfe von Dividend - Divisor
(5.1) Ist der Rest kleiner als der Divisor, lautet das Ergebnis 1 mit Rest
(5.2) Ist der Rest = 0, lautet das Ergebnis 1
(5.3) Solange der Rest >= Divisor
(5.3.1) Berechne den Rest mithilfe von Dividend - Divisor
(5.3.2) Setze den Rest mit dem vorhergehenden Dividenden gleich
(5.3.3) Zähle 1 zur Anzahl an Abzügen dazu
(5.4) Erhalte das Ergebnis als Anzahl von Abzügen aus Schritt (5.3.3) mit Rest im Bereich von 0 bis (Divisor - 1)

Input:

(1) (-1) / (-2) oder (-1) / 2 oder 1 / (-2)
(2) 3 / 0
(3) 0 / 3
(4) 4 / 5
(5.1) 7 / 4
(5.2) 6 / 6

(5.3) 19 / 6

Output: 

(1) Übung0.Division im Bereich der natürlichen Zahlen nicht möglich
(2) Übung0.Division durch 0 nicht definiert
(3) Das Ergebnis ist 0
(4) Das Ergebnis ist 0 mit Rest 4
(5.1) Rest = 3, 3 < 4 → Das Ergebnis lautet 1 mit Rest 3
(5.2) Rest = 6 - 6 = 0 → Das Ergebnis lautet 1

(5.3) Rest = 19 - 6 = 13, 13 > 6
(5.3.1) Rest = 13, 13 > 6
(5.3.2) neuer Dividend = 13
(5.3.3) Anzahl an Abzügen = 0 + 1 = 1
(5.3.1) Rest = 7, 7 > 6
(5.3.2) neuer Dividend = 7
(5.3.3) Anzahl an Abzügen = 1 + 1 = 2
(5.3.1) Rest = 1, 1 < 6
(5.3.2) neuer Dividend = 1
(5.3.3) Anzahl an Abzügen = 2 + 1 = 3
(5.4) Das Ergebnis lautet 3 mit Rest 1

Zusatzaufgabe:
Sind sowohl Dividend als auch Divisor negativ, ändert sich am eigentlichen Algorithmus nichts, allerdings muss vorher
von beiden Zahlen jeweils der Absolutwert ermittelt werden. Sollte der Divisor allerdings kleiner als der Dividend sein,
ist das Ergebnis 0, aber auch vom Rest muss der Betrag genommen werden.
Ist der Dividend oder der Divisor aber nicht beide negativ, kann mit dem Absolutwert der negativen Zahl der Algorithmus
durchgeführt werden, nur dass beim Ergebnis das Vorzeichen gewechselt werden muss, der Rest bleibt gleich.