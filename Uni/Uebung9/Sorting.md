Selectionsort:
   - gesamtes Array nach dem kleinsten Wert durchsuchen
   - Platz des ersten Wertes mit dem des kleinsten Wertes tauschen
   - nächstkleineren Wert an die zweite Stelle stellen
   - Wiederholung bis zum vorletzten Wert → letzter Wert muss größter sein

   Gemeinsamkeit: n - 1 äußere Schleifeniterationen
   → gesamtes Array bis zum vorletzten Wert durchlaufen
   Auswirkung auf Selectionsort: n - 1 Vertauschungen, für sortierten Fall "Tausch mit sich selbst"

   Unterschiede:
   → ≈ n²/2 Vergleiche (Gaußsche Summenformel: n - 1 Durchgänge mit n - i Vergleichen für i-ten inneren
   Schleifendurchgang → (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1)/2 ≈ n²/2)
   → nicht stabil, da das Vertauschen über das ganze Array hinweg die Reihenfolge beeinflussen kann, z. B. wenn ein
   kleinerer Wert nach 2 gleichen auftritt ([*2*, 2, 1] → [1, 2, *2*])
    
Insertionsort:
   - (ab dem 2. Wert) den Wert "herausgreifen" und mit dem linken Wert vergleichen
   - solange linker Wert größer → verglichenen Wert "1 nach rechts schieben", mit nächstem Wert vergleichen
   - linker Wert kleiner oder gleich? herausgegriffenen Wert an aktueller Stelle ablegen und nächsten Wert herausgreifen
   - Wiederholung bis zum letzten Wert

   Gemeinsamkeit: n - 1 äußere Schleifeniterationen
   → gesamtes Array mit Ausnahme des 1. Wertes durchlaufen

   Unterschiede:
   → bester Fall: sortiertes Array → n - 1 ≈ n Vergleiche, keine Schiebungen
   → schlechtester Fall: umgekehrt sortiertes Array → n²/2 (siehe Selectionsort) Vergleiche und Schiebungen
   → Im Mittel: Gleichverteilung angenommen → Einfügen bei (i - 1)/2 → Gaußsche Summenformel / 2 = n(n - 1)/4 ≈ n²/4
   Vergleiche und Schiebungen (1 Schiebung ≈ 1/2 Vertauschung → n²/8 Vertauschungen), worst case hat ≈ doppelten Aufwand
   → stabil, da der Reihenfolge nach verglichen und verschoben wird, gleiche Werte werden identisch aneinandergereiht
   
Der Aufwand zu vergleichen ließe sich mithilfe binärer Suche im besten Fall von O(n) auf O(logn) und sonst von O(n²) auf
O(n*logn) verbessern. Abgesehen vom besten Fall, wo nicht geschoben wird, bleibt die Anzahl an Schiebungen bei ca. n²/4.