Algorithmus: Unter einem Algorithmus versteht man eine Reihe von Anweisungen, mit denen man Schritt-für-Schritt einen
definierten Vorgang erklärt.

Terminierung: Von Terminierung spricht man, wenn ein Algorithmus nach einer begrenzten Anzahl an Schritten beendet wird.

deterministischer Ablauf: Ein Ablauf ist dann deterministisch, wenn die Anweisungen nach einer genauen Reihenfolge 
ausgeführt werden.

determiniertes Ergebnis: Führt ein Algorithmus nach dem Ablauf zu einem vorherbestimmten Ergebnis, ist es determiniert.

(1) Der Algorithmus besteht daraus zwei Bonbons zu entnehmen, bei gleicher Farbe beide zu essen und ein rotes Bonbon aus
der Tüte in das Glas zu legen bzw. bei unterschiedlicher Farbe nur das rote zu essen und das Blaue zurückzulegen. Diese
Schritte werden solange wie möglich wiederholt.

(2) Dieser Vorgang terminiert.

(3) Ist die Anzahl an blauen Bonbons zu Beginn gerade, bleibt irgendwann nur noch ein oder gar kein rotes Bonbon übrig.
    Ist die Anzahl an blauen Bonbons zu Beginn ungerade, bleibt irgendwann eins und keine roten mehr übrig.

(4) Das Ergebnis ist nicht determiniert, da es von der Ausgangsmenge an blauen Bonbons sowie bei einer geraden 
    Anzahl an blauen Bonbons auch von der verbleibenden Menge an roten Bonbons abhängt und je nachdem 3 unterschiedliche
    Endresultate möglich sind. Da "ein deterministischer Algorithmus [] immer determiniert [ist]", kann der Ablauf
    aus Prinzip schon nicht deterministisch sein. Je nachdem, welches Szenario eintritt, ist der letzte Schritt ein
    anderer und der Algorithmus bricht an unterschiedlicher Stelle ab.